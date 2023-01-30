package moe.best.athenaeum.apptests.common

import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.testing.*

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

abstract class ModuleTestBase {

    /**
     * Tests if a query sent to the server returns the expected URL redirect.
     * This is the most basic unit of test functions for any module and should be preferred
     * for most unit tests.
     *
     * Note: This test doesn't handle potential flakiness introduced from conflicting regexes.
     * As a general rule, Patterns that have overlapping coverage should be covered by ensuring
     * all individual modules have tests that cover as much of the Pattern's match domain as possible.
     */
    fun testBunny(
        query: String,
        expectedURL: String,
        languageParameter: String? = null,
        acceptLanguageHeader: String? = null,
    ) {
        testApplication {
            createClient {
                followRedirects = false // Disable redirects to read the language header.
            }.get("/bunny") {
                header("Accept-Language", acceptLanguageHeader) // Will not be set if null.
                url {
                    parameters.append("query", query)
                    languageParameter?.let { parameters.append("language", languageParameter) }
                }
            }.also { res ->
                assertEquals(HttpStatusCode.Found, res.status)
                assertEquals(expectedURL, res.headers.get("Location")) // Read redirect URL destination.
            }
        }
    }

}