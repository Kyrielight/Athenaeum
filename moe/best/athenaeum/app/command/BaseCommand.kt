package moe.best.athenaeum.command

import io.ktor.http.Url
import moe.best.athenaeum.middleware.Metadata
import moe.best.athenaeum.middleware.MetadataResolver

/** A special type of resolver that will always return a Url. Used for defaults. */
interface DefaultResolver : MetadataResolver {
    abstract fun resolve(query: String?, metadata: Metadata): Url
}

abstract class BaseCommand(
    val name: String
) {
    abstract val description: String?
    abstract val documentation: String?

    override fun toString() = name

    abstract val resolver: MetadataResolver

}