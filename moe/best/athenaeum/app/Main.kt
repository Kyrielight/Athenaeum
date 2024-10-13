@file:JvmName("Main") // Sets the name of this class

package moe.best.athenaeum

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.* // TODO: Tighten
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.EngineMain
import io.ktor.server.plugins.statuspages.* // TODO: Tighten
import io.ktor.server.response.respondRedirect
import io.ktor.server.response.respondText
import io.ktor.server.resources.* // TODO: Tighten
import io.ktor.server.routing.* // TODO: Tighten
import moe.best.athenaeum.command.DefaultResolver
import moe.best.athenaeum.library.Library
import moe.best.athenaeum.routing.Bunny
import moe.best.athenaeum.startup.loader.root.RootLoader
import moe.best.athenaeum.udc.Google // Default module

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.usagi() {

    val library = RootLoader.generateLibrary()
    val defaultResolver = Google.target.resolver as DefaultResolver

    install(Resources) // For type-safe routing

    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
        }
    }

    routing {
        get<Bunny> { bunny ->
            val url = library.getURLForRequest(bunny, call.request, defaultResolver)
            call.respondRedirect(url)
        }
    }
}
