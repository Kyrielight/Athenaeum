package moe.best.athenaeum.udc.social

import io.ktor.http.ParametersBuilder
import io.ktor.http.URLBuilder
import io.ktor.http.URLProtocol
import io.ktor.http.Url
import java.util.Locale
import kotlin.text.Regex
import kotlin.text.RegexOption
import moe.best.athenaeum.command.Target
import moe.best.athenaeum.command.Pattern
import moe.best.athenaeum.middleware.Metadata
import moe.best.athenaeum.middleware.locales.common.LocaleCM
import moe.best.athenaeum.startup.Module

object YouTube : Module {

    override val target = object : Target("YouTube") {
    
        override val description = "Module for YouTube-related comments."

        override val documentation = null // TODO

        override val sources = listOf("yt", "youtube")

        override val resolver = object : Target.Resolver {

            val localeToHost = mapOf<Locale, String>(
                Locale.ENGLISH to "youtube.co.uk",
                Locale.JAPANESE to "youtube.co.jp",
                LocaleCM.JAPANESE to "youtube.co.jp",
            ).withDefault { "youtube.com" }

            override val locales = localeToHost.keys

            override fun resolve(target: String, arguments: String?, metadata: Metadata): Url? {
                // TODO: Implement Metadata based host generation.
                val host = localeToHost.getValue(metadata.locale ?: Locale.ROOT)
                arguments?.let { args -> 
                    when (target) {
                        // "yt" & "youtube" commands correlates to a search.
                        "yt", "youtube" -> run {
                            // "https://youtube.com/results?search_query=%s"
                            return@resolve URLBuilder(
                                    protocol = URLProtocol.HTTPS, 
                                    host = host,
                                    pathSegments = listOf("results"),
                                    parameters = ParametersBuilder().apply {
                                        append("search_query", args)
                                    }.build()
                            ).build()
                        }
                        else -> throw IllegalArgumentException()
                    }
                }
                return URLBuilder(URLProtocol.HTTPS, host).build()
            }

        }

    }

    override val pattern = object : Pattern("YouTube") {

        override val description = "Module for YouTube-related comments."

        override val documentation = null // TODO

        override val patterns = setOf(
            Regex("ytr.*", RegexOption.IGNORE_CASE)
        )

        override val resolver = object : Pattern.Resolver {
        
            override val locales = setOf(Locale.ROOT)

            override fun resolve(query: String, metadata: Metadata): Url? {
                return URLBuilder(URLProtocol.HTTPS, "r.youtube.com").build()
            }

        }

    }

}