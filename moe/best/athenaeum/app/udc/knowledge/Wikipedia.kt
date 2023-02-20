package moe.best.athenaeum.udc.knowledge

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

object Wikipedia : Module {

    override val target = object : Target("Wikipedia") {
    
        override val description = "Module for Wikipedia articles."

        override val documentation = null // TODO

        override val sources = listOf("wk", "wiki", "wikipedia")

        override val resolver = object : Target.Resolver {

            val localeToHost = mapOf<Locale, String>(
                Locale.JAPANESE to "ja.wikipedia.org",
                LocaleCM.JAPANESE to "ja.wikipedia.org",
                Locale.Builder().apply {
                    setLanguage("zh")
                }.build() to "zh.wikipedia.org",
            ).withDefault { "en.wikipedia.org" }

            val mainPageToHost = mapOf<Locale, String>(
                Locale.JAPANESE to "メインページ",
                LocaleCM.JAPANESE to "メインページ",
                Locale.Builder().apply {
                    setLanguage("zh")
                }.build() to "Wikipedia:首页",
            ).withDefault { "Main_Page" }

            override val locales = localeToHost.keys

            override fun resolve(target: String, arguments: String?, metadata: Metadata): Url? {
                val host = localeToHost.getValue(metadata.locale ?: Locale.ROOT)
                arguments?.let { args -> 
                    return@resolve URLBuilder(
                            protocol = URLProtocol.HTTPS, 
                            host = host,
                            pathSegments = mutableListOf("wiki", args),
                    ).build()
                }

                val mainPage = mainPageToHost.getValue(metadata.locale ?: Locale.ROOT)
                return URLBuilder(
                    protocol = URLProtocol.HTTPS,
                    host = host,
                    pathSegments = listOf("wiki", mainPage)
                ).build()
            }

        }

    }

    override val pattern = null

}