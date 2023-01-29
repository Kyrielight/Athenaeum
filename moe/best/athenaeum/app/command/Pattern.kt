package moe.best.athenaeum.command

import moe.best.athenaeum.command.BaseCommand
import moe.best.athenaeum.middleware.Metadata
import moe.best.athenaeum.middleware.MetadataResolver
import io.ktor.http.Url
import kotlin.text.Regex

/**
 * This command type matches to queries via regex.
 * It is called "Pattern" to differentiate itself from
 * Kotlin's official "Regex" class.
 */
abstract class Pattern(
    name: String
) : BaseCommand(name) {

    interface Resolver : MetadataResolver {

        fun resolve(query: String, metadata: Metadata): Url?

    }

    /**
     * A list of Regexes that will resolve to this command.
     * The regex must match the FULL query (i.e. full string match).
     */
    abstract val patterns: Set<Regex>

    abstract override val resolver: Resolver

}