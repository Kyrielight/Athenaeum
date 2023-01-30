package moe.best.athenaeum.apptests.udc.social

import org.junit.jupiter.api.Test

import moe.best.athenaeum.apptests.common.ModuleTestBase

class YouTubeTest : ModuleTestBase() {

    @Test
    fun testCommandDefaultOnly() {
        testBunny("yt", "https://youtube.com")
    }

    @Test
    fun testCommandDefaultJP() {
        testBunny("yt", "https://youtube.co.jp", "ja")
        testBunny("yt", "https://youtube.co.jp", "jp")
    }

}