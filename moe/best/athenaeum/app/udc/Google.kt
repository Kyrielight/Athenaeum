package moe.best.athenaeum.udc

import io.ktor.http.ParametersBuilder
import io.ktor.http.URLBuilder
import io.ktor.http.URLProtocol
import io.ktor.http.Url
import java.util.Locale
import kotlin.text.Regex
import kotlin.text.RegexOption
import moe.best.athenaeum.command.DefaultResolver
import moe.best.athenaeum.command.Target
import moe.best.athenaeum.command.Pattern
import moe.best.athenaeum.middleware.Metadata
import moe.best.athenaeum.middleware.locales.common.LocaleCM
import moe.best.athenaeum.startup.Module

object Google : Module {

    override val target = object : Target("Google") {

        override val description = "Google Search related commands."
        override val documentation = null // TODO

        override val sources = listOf("g")

        override val resolver = object : DefaultResolver, Target.Resolver {

            val localeToHost = mapOf<Locale, String>(
                Locale.ENGLISH to "google.co.uk",
                Locale.JAPANESE to "google.co.jp",
                LocaleCM.JAPANESE to "google.co.jp",
                Locale.Builder().apply {
                    setLanguage("zh")
                }.build() to "google.com.hk",
            ).withDefault { "google.com" }

            override val locales = localeToHost.keys

            override fun resolve(query: String?, metadata: Metadata): Url {
                return resolveAbsolute("g", query, metadata)
            }

            override fun resolve(target: String, arguments: String?, metadata: Metadata): Url? {
                return resolveAbsolute(target, arguments, metadata)
            }

            /** Abstract away the resolution logic to allow conformance with the DefaultResolver. */
            private fun resolveAbsolute(target: String, 
                                        arguments: String?, 
                                        metadata: Metadata): Url {

                val host = localeToHost.getValue(metadata.locale ?: Locale.ROOT)
                return arguments?.let { args ->
                    when (target) {
                        "g" -> run {
                            return@resolveAbsolute URLBuilder(
                                protocol = URLProtocol.HTTPS,
                                host = host,
                                pathSegments = listOf("search"),
                                parameters = ParametersBuilder().apply {
                                    append("q", args)
                                }.build()
                            ).build()
                        } 
                        else -> throw IllegalArgumentException()
                    }
                } ?: URLBuilder(URLProtocol.HTTPS, host).build() 
            }
        }
    }

    override val pattern = null

}