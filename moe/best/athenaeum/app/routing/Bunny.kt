package moe.best.athenaeum.routing

import io.ktor.resources.Resource

// Parameters are not case-sensitive.
@Resource("/bunny")
class Bunny(
    val query: String? = null,
    val language: String? = null,
    val incognito: Boolean = true // =true (not case sensitive)
)