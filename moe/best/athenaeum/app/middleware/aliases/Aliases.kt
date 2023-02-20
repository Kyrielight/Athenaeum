package moe.best.athenaeum.middleware.aliases

/**
 * Middleware object that allows users to set aliases for target commands
 * via environment variables:
 * ATHENAEUM_TARGET_ALIAS_<alias>=<target>
 *
 * IMPORTANT: No validation is performed if the end target is valid, because the swap
 * happens before the target lookup occurs.
 */
object Aliases {

    private val targetAliases = mutableMapOf<String, String>()

    const val ENV_ALIAS_PREFIX = "ATHENAEUM_TARGET_ALIAS_"

    fun initialise(): Unit {
        // Check all environment variables.
        // Register commands matching the prefix into the alias lookup map.
        System.getenv().forEach { (key, existingCommand) ->
            if (key.startsWith(ENV_ALIAS_PREFIX)) {
                with (key.removePrefix(ENV_ALIAS_PREFIX)) {
                    // Alias is not valid if the alias or the target command is empty/null, i.e.:
                    // ATHENAEUM_TARGET_ALIAS_=<command>
                    // ATHENAEUM_TARGET_ALIAS_X=   # Empty
                    if (this.isNullOrEmpty() or existingCommand.isNullOrEmpty()) {
                        throw IllegalArgumentException("Invalid alias, please check your environment variables.")
                    }
                    targetAliases.put(this, existingCommand)
                }
            }
        }
    }

    /**
     * If the command matches an alias, returns the alias's target command.
     * Else, return command as-is.
     */
    fun resolveTargetAlias(command: String): String {
        return targetAliases.getOrDefault(command, command)
    }

}
