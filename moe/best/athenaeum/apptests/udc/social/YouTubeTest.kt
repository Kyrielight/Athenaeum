package moe.best.athenaeum.apptests.udc.social

import org.junit.jupiter.api.Test

import moe.best.athenaeum.apptests.common.ModuleTestBase

class YouTubeTest : ModuleTestBase() {

    @Test
    fun testTargetDefaultOnly() {
        testBunny("yt", "https://youtube.com")
    }

    @Test
    fun testTargetDefaultJapanese() {
        testBunny("yt", "https://youtube.co.jp", languageParam = "ja")
        testBunny("yt", "https://youtube.co.jp", languageParam = "jp") // Test misconception
    }

    @Test
    fun testTargetDefaultEnglish() {
        testBunny("yt", "https://youtube.co.uk", languageParam = "en")
        testBunny("yt", "https://youtube.co.uk", acceptLanguageHeader = "en-UK,en;q=0.9")
    }

    @Test
    fun testTargetWithSearch() {
        testBunny("yt hello world", "https://youtube.com/results?search_query=hello+world")
    }

}
