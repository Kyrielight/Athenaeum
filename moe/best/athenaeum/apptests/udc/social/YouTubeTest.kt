package moe.best.athenaeum.apptests.udc.social

import org.junit.jupiter.api.Test

import moe.best.athenaeum.apptests.common.ModuleTestBase

class YouTubeTest : ModuleTestBase() {

    @Test
    fun testTarget_NoArgs() {
        testBunny("yt", "https://youtube.com")
    }

    @Test
    fun testTarget_NoArgs_Japanese() {
        testBunny("yt", "https://youtube.co.jp", languageParam = "ja")
        testBunny("yt", "https://youtube.co.jp", languageParam = "jp") // Test misconception
    }

    @Test
    fun testTarget_NoArgs_English() {
        testBunny("yt", "https://youtube.co.uk", languageParam = "en")
        testBunny("yt", "https://youtube.co.uk", acceptLanguageHeader = "en-UK,en;q=0.9")
    }

    @Test
    fun testTarget_NoArgs_Chinese() {
        testBunny("yt", "https://youtube.com.hk", languageParam = "zh")
    }

    @Test
    fun testTarget_WithArgs() {
        testBunny("yt hello world", "https://youtube.com/results?search_query=hello+world")
    }

}
