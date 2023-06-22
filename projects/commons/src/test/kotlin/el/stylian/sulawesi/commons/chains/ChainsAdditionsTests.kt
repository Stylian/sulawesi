package el.stylian.sulawesi.commons.chains

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ChainsAdditionsTests {

    @Test
    fun testAddingLinks() {
        var counter = 0
        val chain = CommandLink<Nothing> { counter++ } + CommandLink { counter += 3 } + CommandLink { counter += 4 }
        chain.run()
        assertEquals(8, counter)
    }

    @Test
    fun testAddingChainAndLinks() {
        var counter = 0
        val chain = CommandLink<Nothing> { counter++ } + CommandLink { counter += 3 } + CommandLink { counter += 4 }
        val link4 = CommandLink<Nothing> { counter-- }
        val chain2 = chain + link4
        chain2.run()
        assertEquals(7, counter)
    }


    @Test
    fun testAddingChains() {
        var counter = 0
        val chain = CommandLink<Nothing> { counter++ } + CommandLink { counter += 3 } + CommandLink { counter += 4 }
        val chain2 = CommandLink<Nothing> { counter-- } + CommandLink { counter -= 2 }
        (chain2 + chain).run()
        assertEquals(5, counter)
    }

}