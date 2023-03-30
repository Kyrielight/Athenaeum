package moe.best.athenaeum.apptests.udc.dictionaries

import org.junit.jupiter.api.Test

import moe.best.athenaeum.apptests.common.ModuleTestBase

class JishoTest : ModuleTestBase() {

    @Test
    fun test_NoArgs() {
        testBunny("jisho", "https://jisho.org")
        testBunny("jisho", "https://jisho.org", languageParam = "jp")
    }

    @Test
    fun test_English_SingleArg() {
        testBunny("jisho hello", "https://jisho.org/search/hello")
    }

    @Test
    fun test_English_MultipleArgs() {
        testBunny("jisho hello world", "https://jisho.org/search/hello%20world")
    }

    @Test
    fun test_Japanese_Args() {
        testBunny("jisho こんにちは", "https://jisho.org/search/%E3%81%93%E3%82%93%E3%81%AB%E3%81%A1%E3%81%AF")
    }

    @Test
    fun test_Japanese_ArgsWithWhitspace() {
        testBunny("jisho こんにちは　こんにちは", "https://jisho.org/search/%E3%81%93%E3%82%93%E3%81%AB%E3%81%A1%E3%81%AF%E3%80%80%E3%81%93%E3%82%93%E3%81%AB%E3%81%A1%E3%81%AF")
    }

}
