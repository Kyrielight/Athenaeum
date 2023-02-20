package moe.best.athenaeum.apptests.udc.knowledge

import org.junit.jupiter.api.Test

import moe.best.athenaeum.apptests.common.ModuleTestBase

class WikipediaTest : ModuleTestBase() {

    @Test
    fun testTarget_NoArgs() {
        testBunny("wk", "https://en.wikipedia.org/wiki/Main_Page")
        testBunny("wiki", "https://en.wikipedia.org/wiki/Main_Page")
        testBunny("wikipedia", "https://en.wikipedia.org/wiki/Main_Page")
    }

    @Test
    fun testTarget_NoArgs_English() {
        testBunny("wk", "https://en.wikipedia.org/wiki/Main_Page", languageParam = "en")
        testBunny("wk", "https://en.wikipedia.org/wiki/Main_Page", acceptLanguageHeader = "en-UK,en;q=0.9")
    }

    @Test
    fun testTarget_NoArgs_Japanese_JA() {
        // Equivalent of "https://ja.wikipedia.org/メインページ"
        val mainPage = "https://ja.wikipedia.org/wiki/%E3%83%A1%E3%82%A4%E3%83%B3%E3%83%9A%E3%83%BC%E3%82%B8"
        testBunny("wk", mainPage, languageParam = "ja")
        testBunny("wiki", mainPage, languageParam = "ja") 
        testBunny("wikipedia", mainPage, languageParam = "ja")
    }

    @Test
    fun testTarget_NoArgs_Japanese_JP() {
        // Equivalent of "https://ja.wikipedia.org/メインページ"
        val mainPage = "https://ja.wikipedia.org/wiki/%E3%83%A1%E3%82%A4%E3%83%B3%E3%83%9A%E3%83%BC%E3%82%B8"
        testBunny("wk", mainPage, languageParam = "jp")
        testBunny("wiki", mainPage, languageParam = "jp") 
        testBunny("wikipedia", mainPage, languageParam = "jp")
    }

    @Test
    fun testTarget_NoArgs_Chinese() {
        // Equivalent of "https://zh.wikipedia.org/Wikipedia:首页"
        val mainPage = "https://zh.wikipedia.org/wiki/Wikipedia:%E9%A6%96%E9%A1%B5"
        testBunny("wk", mainPage, languageParam = "zh")
        testBunny("wiki", mainPage, languageParam = "zh")
        testBunny("wikipedia", mainPage, languageParam = "zh")
    }

    @Test
    fun testTarget_WithArgs() {
        testBunny("wikipedia Tokyo", "https://en.wikipedia.org/wiki/Tokyo")
        testBunny("wikipedia Special Wards of Tokyo", "https://en.wikipedia.org/wiki/Special%20Wards%20of%20Tokyo")
    }

}
