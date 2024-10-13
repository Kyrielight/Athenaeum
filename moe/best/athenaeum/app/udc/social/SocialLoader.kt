package moe.best.athenaeum.udc.social

import kotlin.text.Regex
import moe.best.athenaeum.command.Pattern
import moe.best.athenaeum.command.Target
import moe.best.athenaeum.startup.loader.Loader

// Begin module imports
import moe.best.athenaeum.udc.social.YouTube

object SocialLoaderGenerated : Loader() {

    override fun loadTargetCommands(): Map<String, Target.Resolver> {

        val targetCommands = mutableMapOf<String, Target.Resolver>()

        // Begin loading target commands in this folder.
        with (TargetLoader) {
            addTarget(YouTube.target, targetCommands)
        }

        // Begin loading target commands from subfolders.
        with (TargetLoader) {}

        // Return all commands
        return targetCommands

    }

    override fun loadPatternCommands(): Set<Pair<Regex, Pattern.Resolver>> {

        val patternCommands = mutableSetOf<Pair<Regex, Pattern.Resolver>>()

        // Begin loading pattern commands in this folder.
        with (PatternLoader) {
            addPattern(YouTube.pattern, patternCommands)
        }

        // Begin loading pattern commands from subfolders.
        with (PatternLoader) {}

        // Return all commands
        return patternCommands

    }

}