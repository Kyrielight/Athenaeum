package moe.best.athenaeum.startup.loader

import moe.best.athenaeum.command.Pattern
import moe.best.athenaeum.command.Target
import kotlin.text.Regex

abstract class Loader() {

    // Currently, all implementations should union two lists.
    abstract fun loadTargetCommands(): Map<String, Target.Resolver>

    // Note: There is no startup validation for overlap of regexes.
    // This should be verified by unit tests intead.
    abstract fun loadPatternCommands(): Set<Pair<Regex, Pattern.Resolver>>

    object TargetLoader {

        // TODO: Throw an exception if the source key is empty.
        fun sanitizeTargetSourceKey(source: String): String? = 
            if (source.isEmpty()) null
            else source.lowercase().trim()

        // Method used to merge keys to build the overall target map.
        // If the source key already exists, throw an Exception.
        fun addTarget(target: Target, targetCommands: MutableMap<String, Target.Resolver>) {
            target.sources.forEach { dirtySource ->
                sanitizeTargetSourceKey(dirtySource)?.let { source ->
                    // Check if there are any intersecting source keys.
                    if (targetCommands.containsKey(source)) {
                        throw Exception("Duplicate source key: $source")
                    }

                    // Add the targets into the map.
                    targetCommands.put(source, target.resolver)
                }
            }
        }

        // Method used to merge two maps of target commands.
        // If there is an intersection in source keys, throw an Exception.
        fun addTarget(subTargetCommands: Map<String, Target.Resolver>,
                         targetCommands: MutableMap<String, Target.Resolver>) {
            // Check for key intersection
            val sourceKeyIntersects = targetCommands.keys.intersect(subTargetCommands.keys)
            if (sourceKeyIntersects.size != 0) {
                val exceptionPrint = "Duplicate source keys: " + sourceKeyIntersects.joinToString(" ")
                throw Exception(exceptionPrint)
            }

            // Merge the commands from the lower map into the upper map.
            targetCommands.putAll(subTargetCommands.toList())
        }

    }

    object PatternLoader {

        // Method used to add a pattern to the overall set.
        // Does not validate for duplicates.
        fun addPattern(pattern: Pattern, patternCommands: MutableSet<Pair<Regex, Pattern.Resolver>>) {
            pattern.patterns.forEach { regex ->
                // There is no validation for duplicates.
                patternCommands.add(Pair(regex, pattern.resolver))
            }
        }

        // Method use to merge two sets of pattern commands.
        // The sub patterns will be added to the [main] patterns.
        // There is no check for intersected elements.
        fun addPattern(subPatternCommands: Set<Pair<Regex, Pattern.Resolver>>,
                          patternCommands: MutableSet<Pair<Regex, Pattern.Resolver>>) {
            patternCommands.addAll(subPatternCommands)
        }

    }
}