package moe.best.athenaeum.apptests.udc.social

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.testing.*

class YouTubeTest {

    @Test
    fun testCommandOnly() {
        createTestApplication()
    }

        // TODO: Make this more widely available to all tests
        // TODO: Enable adding things like AcceptLanguage parameters
        companion object {

            fun createTestApplication() = testApplication {
                val client = createClient {
                    followRedirects = false
                }

                val response = client?.get("/bunny") {
                    url {
                        parameters.append("query", "yt")
                    }
                }
                assertEquals(HttpStatusCode.Found, response?.status)
                assertEquals("https://youtube.com", response?.headers?.get("Location"))
        }
    }
}