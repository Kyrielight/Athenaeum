package moe.best.athenaeum.startup

import moe.best.athenaeum.command.Pattern
import moe.best.athenaeum.command.Target

interface Module {

    val pattern: Pattern?

    val target: Target?

}