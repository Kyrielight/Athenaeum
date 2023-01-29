package moe.best.athenaeum.udc

import kotlin.text.Regex
import io.ktor.http.Url
import moe.best.athenaeum.command.Pattern
import moe.best.athenaeum.command.Target
import moe.best.athenaeum.library.Library
import moe.best.athenaeum.startup.loader.Loader

// Begin imports for udc commands
import moe.best.athenaeum.udc.Google
import moe.best.athenaeum.udc.social.SocialLoaderGenerated

object UDCLoaderGenerated : Loader() {

    override fun loadTargetCommands(): Map<String, Target.Resolver> {

        val targetCommands = mutableMapOf<String, Target.Resolver>()

        // Begin loading target commands in this folder.
        with (TargetLoader) {
            addTarget(Google.target, targetCommands)
        }

        // Begin loading target commands from subfolders.
        with (TargetLoader) {
            addTarget(SocialLoaderGenerated.loadTargetCommands(), targetCommands)
        }

        // Return all commands
        return targetCommands
    }

    override fun loadPatternCommands(): Set<Pair<Regex, Pattern.Resolver>> {

        val patternCommands = mutableSetOf<Pair<Regex, Pattern.Resolver>>()

        // Begin loading pattern commands in this folder.
        with (PatternLoader) {}

        // Begin loading pattern commands from subfolders.
        with (PatternLoader) {
            addPattern(SocialLoaderGenerated.loadPatternCommands(), patternCommands)
        }

        // Return all commands
        return patternCommands

    }

}