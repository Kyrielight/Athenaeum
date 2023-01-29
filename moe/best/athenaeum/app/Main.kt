@file:JvmName("Main") // Sets the name of this class

package moe.best.athenaeum

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.* // TODO: Tighten
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.response.respondText
import io.ktor.server.response.respondRedirect
import io.ktor.server.resources.* // TODO: Tighten
import io.ktor.server.routing.* // TODO: Tighten
import io.ktor.server.plugins.statuspages.* // TODO: Tighten
import moe.best.athenaeum.command.DefaultResolver
import moe.best.athenaeum.library.Library
import moe.best.athenaeum.routing.Bunny
import moe.best.athenaeum.startup.loader.root.RootLoader
import moe.best.athenaeum.udc.Google // Default module

fun main() {

    val library = RootLoader.generateLibrary()
    val defaultResolver = Google.target.resolver as DefaultResolver

    embeddedServer(Netty, port = 8080) {

        install(Resources) // For type-safe routing

        install(StatusPages) {
            exception<Throwable> { call, cause ->
                call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
            }
        }

        routing {
            get("/") {
                call.respondText("Hello, world!")
            }

            get<Bunny> { bunny ->
                library.getURLForRequest(bunny, call.request, defaultResolver).let { url ->
                    call.respondRedirect(url)
                }
            }
        }
    }.start(wait = true)
}
