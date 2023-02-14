package moe.best.athenaeum.middleware.metadata.locales

import io.ktor.http.Parameters
import io.ktor.server.request.ApplicationRequest
import java.util.Locale
import java.util.Locale.LanguageRange
import kotlin.text.MatchResult
import kotlin.text.MatchGroup
import kotlin.text.MatchGroupCollection
import kotlin.text.Regex
import kotlin.text.RegexOption
import moe.best.athenaeum.routing.Bunny

interface LocalesMetadataResolver {

    val locales: Set<Locale>

}

object LocalesMetadata {

    /**
     * Matches ab-CD or ab_CD, not case sensitive, there can be an E.
     * An additional (optional) space is added at the front for matching at the
     * beginning of an argument.
     */
    val localeRegex = Regex(" ?-in:(\\S{2})(?:[-_](\\S{2,3}))?", RegexOption.IGNORE_CASE)

    /**
     * There are three different ways, in decreasing precedence, how the user's Locale is determined.
     * First, check if the user has manually specified a hard override.
     * Next, check if the user's query parameters has a language set.
     * Last, the user's Accept-Language header (if it exists) is compared against supported locales.
     * If a suitable match cannot be found otherwise, null is returned.
     */
    fun getLocale(bunny: Bunny, appRequest: ApplicationRequest, resolver: LocalesMetadataResolver): Locale? {
        // Check user query itself.
        bunny.query?.let { query ->
            localeRegex.find(query)?.let { matchResult ->
                // Build a safe locale under the given conformities.
                val locale = Locale.Builder().apply {
                    matchResult.groups.elementAtOrNull(1)?.let { lang -> this.setLanguage(lang.value) }
                    matchResult.groups.elementAtOrNull(2)?.let { region -> this.setRegion(region.value) }
                }.build()
                // Use the locale object to safety generate a LanguageRange.
                val range = listOf(LanguageRange(locale.toLanguageTag()))
                return@getLocale Locale.lookup(range, resolver.locales)
            }
        }

        // Check if the user set a permanent language via query
        appRequest.queryParameters.get("locale")?.let { parameter ->
            // Manually break up the parameters into language and region.
            val localeTags = parameter.split("-", "_")
            val lang = localeTags.elementAtOrNull(0)
            val region = localeTags.elementAtOrNull(1)
            // Only build a locale if at least the language exists and is not empty.
            if (!lang.isNullOrEmpty()) {
                val locale = Locale.Builder().apply {
                    this.setLanguage(lang)
                    // Only set region if it exists and is not empty.
                    if (!region.isNullOrEmpty()) {
                        this.setRegion(region)
                    }
                }.build()
                val range = listOf(LanguageRange(locale.toLanguageTag()))
                return@getLocale Locale.lookup(range, resolver.locales)
            }
        }

        // Compare against Accept-Language header.
        appRequest.headers.get("Accept-Language")?.let { rawHeader ->
            LanguageRange.parse(rawHeader)?.let { range ->
                return@getLocale Locale.lookup(range, resolver.locales)
            }
        }

        return null
    }

    /** Removes the (first occurrence) of the language flag from the query. */
    fun stripMetadata(query: String) = localeRegex.replaceFirst(query, "")

}