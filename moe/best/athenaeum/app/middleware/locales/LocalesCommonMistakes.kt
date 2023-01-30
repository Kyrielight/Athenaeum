package moe.best.athenaeum.middleware.locales

import java.util.Locale

/**
 * Stores common Locale mistakes.
 * This is necessary because the matching against the BCP-like tags occurs
 * by extracting the first code as the language for the Locale object. Therefore,
 * this object stores common language mistakes.
 */
object LocaleCM {

    // Japanese is often mistaken from "JA" to "JP"
    val JAPANESE = Locale.Builder().apply {
                      setLanguage("jp")
                   }.build()

}
