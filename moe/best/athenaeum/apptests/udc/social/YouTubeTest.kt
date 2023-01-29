package moe.best.athenaeum.apptests.udc.social

import moe.best.athenaeum.library.Library
import moe.best.athenaeum.startup.loader.root.RootLoader

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.AfterEach

class YouTubeTest {

    @Test
    fun sampleTest() {
        // TODO: Create bunny and appRequest mock objects.
    }

    companion object {

        private var library: Library? = null

        @BeforeEach
        fun setUp() {
            library = RootLoader.generateLibrary()
        }

        @AfterEach
        fun tearDown() {
            library = null
        }

    }

}