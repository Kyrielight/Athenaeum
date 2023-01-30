package moe.best.athenaeum.apptests.udc.social

import org.junit.jupiter.api.Test

import moe.best.athenaeum.apptests.common.ModuleTestBase

class YouTubeTest : ModuleTestBase() {

    @Test
    fun testCommandOnly() {
        testBunny("yt", "https://youtube.com")
    }

}