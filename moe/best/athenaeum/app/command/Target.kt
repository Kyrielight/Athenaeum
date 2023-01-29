package moe.best.athenaeum.command

import moe.best.athenaeum.command.BaseCommand
import moe.best.athenaeum.middleware.Metadata
import moe.best.athenaeum.middleware.MetadataResolver
import io.ktor.http.Url

abstract class Target(
    name: String
) : BaseCommand(name) {

    interface Resolver : MetadataResolver {

        fun resolve(target: String, arguments: String?, metadata: Metadata): Url?

    }
    
    /**
     * A list of words that will resolve to this command.
     * TODO: Make sources not case-sensitive.
     */
    abstract val sources: List<String>

    abstract override val resolver: Resolver

    companion object Extractor {

        // Cases to handle:
        // 1. Empty string (or only whitespace): return null
        // 2. String is one word: return the string itself
        // 3. String is multiple words: return the first word
        fun targetCommandExactForQuery(query: String): String? {
            val target = query.substringBefore(' ')
            return if (!target.isEmpty()) target else null
        }

        // Cases to handle:
        // 1. Empty string (or only whitespace): return null
        // 2. String is one word, does not contain a slash: return null
        // 3. String is one word, contains a slash: return the pre-slash section
        // 4. String is multiple words, first word does not contain a slash: return null
        // 5. String is multiple words, first word contains a slash: return the pre-slash section
        // There is no coverage for slashes coming in later words, i.e. targets with whitespace
        fun targetCommandSlashForQuery(query: String): String? {
            val target = targetCommandExactForQuery(query)?.substringBefore('/')
            return if (!(target?.isEmpty() == true)) target else null
        }

    }

}