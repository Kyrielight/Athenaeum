package moe.best.athenaeum.middleware.metadata

import java.util.Locale
import io.ktor.server.request.ApplicationRequest
import moe.best.athenaeum.routing.Bunny
import moe.best.athenaeum.middleware.metadata.locales.LocalesMetadata
import moe.best.athenaeum.middleware.metadata.locales.LocalesMetadataResolver

interface MetadataResolver :
    LocalesMetadataResolver {}

/**
 * Class that contains metadata associated with each request.
 */
data class Metadata(

    // Indicates the locale of the request used for the return URL.
    val locale: Locale? = null

) {

    companion object {
        
        // Allow creation of a Metadata object using a Bunny Resource and ApplicationRequest.
        operator fun invoke(bunny: Bunny, appRequest: ApplicationRequest, resolver: MetadataResolver): Metadata {
            val locale = LocalesMetadata.getLocale(bunny, appRequest, resolver)
            return Metadata(locale)
        }

        // Removes all metadata related flags, etc. from the query.
        fun String.stripMetadata(): String {
            return LocalesMetadata.stripMetadata(this)
        }

    }

}