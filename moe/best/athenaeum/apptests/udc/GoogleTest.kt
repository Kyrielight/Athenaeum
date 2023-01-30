package moe.best.athenaeum.apptests.udc

import org.junit.jupiter.api.Test

import moe.best.athenaeum.apptests.common.ModuleTestBase

class GoogleTest : ModuleTestBase() {

    @Test
    fun testTarget_NoArgs() {
        testBunny("g", "https://google.com")
    }

    @Test
    fun testTarget_NoArgs_Japanese() {
        testBunny("g", "https://google.co.jp", languageParam = "ja")
        testBunny("g", "https://google.co.jp", languageParam = "jp") // Test misconception
    }

    @Test
    fun testTarget_NoArgs_English() {
        testBunny("g", "https://google.co.uk", languageParam = "en")
        testBunny("g", "https://google.co.uk", acceptLanguageHeader = "en-UK,en;q=0.9")
    }

    @Test
    fun testTarget_NoArgs_Chinese() {
        testBunny("g", "https://google.com.hk", languageParam = "zh")
    }

    @Test
    fun testTarget_WithArgs() {
        testBunny("g hello world", "https://google.com/search?q=hello+world")
    }

    @Test
    fun testDefaultResolver() {
        testBunny("", "https://google.com")
    }

    @Test
    fun testDefaultResolver_WithLocale() {
        testBunny("", "https://google.co.jp", languageParam = "ja")
    }

}
