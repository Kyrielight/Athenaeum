package moe.best.athenaeum.udc.dictionaries

import io.ktor.http.ParametersBuilder
import io.ktor.http.URLBuilder
import io.ktor.http.URLProtocol
import io.ktor.http.Url
import java.util.Locale
import kotlin.text.Regex
import kotlin.text.RegexOption
import moe.best.athenaeum.command.Target
import moe.best.athenaeum.command.Pattern
import moe.best.athenaeum.middleware.metadata.Metadata
import moe.best.athenaeum.startup.Module

object Jisho : Module {

    override val target = object : Target("Jisho.org") {
    
        override val description = "Module for Jisho.org (Japanese dictionary) lookups."

        override val documentation = null // TODO

        override val sources = listOf("jisho")

        override val resolver = object : Target.Resolver {

            val host = "jisho.org"

            override val locales = setOf(Locale.ROOT)

            override fun resolve(target: String, arguments: String?, metadata: Metadata): Url? {
                return arguments?.let { args -> 
                    URLBuilder(
                        protocol = URLProtocol.HTTPS,
                        host = host,
                        pathSegments = listOf("search", args)
                    ).build()
                } ?: URLBuilder(URLProtocol.HTTPS, host).build()
            }
        }
    }

    override val pattern = null

}