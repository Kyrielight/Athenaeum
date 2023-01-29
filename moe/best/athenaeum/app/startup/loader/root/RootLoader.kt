package moe.best.athenaeum.startup.loader.root

import moe.best.athenaeum.library.Library
import moe.best.athenaeum.startup.loader.Loader
import moe.best.athenaeum.udc.UDCLoaderGenerated

import moe.best.athenaeum.command.Pattern
import kotlin.text.Regex

/**
 * Core loader that handles the logic for calling all other loaders to generate a
 * Library object.
 */
object RootLoader {

    /**
     * Generates a Library object that acts as the storage and lookup
     * for all commands.
     */
    fun generateLibrary(): Library {

        // Get all target commands, starting from the root UDC loader.
        val targetCommands = UDCLoaderGenerated.loadTargetCommands()
        val patternCommands = UDCLoaderGenerated.loadPatternCommands().toList()
        return Library(targetCommands, patternCommands)

    }

}