package moe.best.athenaeum.library

import io.ktor.http.Url
import io.ktor.server.request.ApplicationRequest
import moe.best.athenaeum.command.DefaultResolver
import moe.best.athenaeum.command.Target
import moe.best.athenaeum.command.Pattern
import moe.best.athenaeum.middleware.Metadata
import moe.best.athenaeum.middleware.Metadata.Companion.stripMetadata
import moe.best.athenaeum.routing.Bunny

final class Library(
    val targetCommands: Map<String, Target.Resolver>,
    val patternCommands: List<Pair<Regex, Pattern.Resolver>>
) {

    /**
     * Queries are processed in the following order:
     * 1. If the first word exactly matches a target, that command is used.
     * 2. If the first slash word (if it exists) matches a target, that command is used.
     * 3. Check if the query [fully] matches any of the pattern commands.
     * Else, return nil.
     */
    public fun getURLForRequest(bunny: Bunny, appRequest: ApplicationRequest): Url? {

        bunny.query?.sanitize()?.let { query ->

            // Step 1. Check for target exact match.
            Target.Extractor.targetCommandExactForQuery(query)?.let { command ->
                targetCommands.get(command)?.let { resolver ->
                    // Fetch the arguments after the command, and trim all whitespace.
                    val arguments = query.substringAfter(command).let { 
                        // Queries need to be stripped of metadata and sanitized.
                        val args = it.sanitize().stripMetadata()
                        // Empty args should be passed as null.
                        if (args.isNullOrEmpty()) null else args
                    }
                    val metadata = Metadata(bunny, appRequest, resolver)
                    return@getURLForRequest resolver.resolve(command, arguments, metadata)
                }
            }

            // Step 2. Check for slash match.
            Target.Extractor.targetCommandSlashForQuery(query)?.let { command -> 
                targetCommands.get(command)?.let { resolver ->
                    // Fetch the arguments after the command (and slash), and trim all whitespace.
                    val arguments = query.substringAfter(command + "/").let { 
                        // Queries need to be stripped of metadata and sanitized.
                        val args = it.sanitize().stripMetadata()
                        // Empty args should be passed as null.
                        if (args.isNullOrEmpty()) null else args
                    } 
                    val metadata = Metadata(bunny, appRequest, resolver)
                    return@getURLForRequest resolver.resolve(command, arguments, metadata)
                }
            }

            // Step 3. Check against patterns.
            // Because this check is inefficient, it should be lowest priority.
            patternCommands.forEach { patternPair ->
                val regex = patternPair.first
                if (regex.matches(query)) {
                    val resolver = patternPair.second
                    val sanitizedQuery = query.stripMetadata()
                    val metadata = Metadata(bunny, appRequest, resolver)
                    return@getURLForRequest resolver.resolve(sanitizedQuery, metadata)
                }
            }
        }

        // If no matching command was found, return null.
        return null
    }

    /** Overloaded query processor, but accepts a default resolver to fall back to. */
    public fun getURLForRequest(bunny: Bunny, appRequest: ApplicationRequest, defaultResolver: DefaultResolver): Url {
        getURLForRequest(bunny, appRequest)?.let { url -> return@getURLForRequest url }
        val metadata = Metadata(bunny, appRequest, defaultResolver)
        bunny.query?.sanitize()?.stripMetadata().let { query ->
            return@getURLForRequest defaultResolver.resolve(query, metadata)
        }
    }

    companion object {

        // Simple function to ensure a passed in query is ready for processing.
        fun String.sanitize() = this.trim()

    }

}
