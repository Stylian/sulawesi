package el.stylian.sulawesi.commons.chains

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ChainsAdditionsTests {

    @Test
    fun testAddingLinks() {
        var counter = 0
        val link1 = CommandLink { counter++ }
        val link2 = CommandLink { counter +=3 }
        val link3 = CommandLink { counter +=4 }
        val chain = link1 + link2 + link3
        chain.run()
        assertEquals(8, counter)
    }

    @Test
    fun testAddingChainAndLinks() {
        var counter = 0
        val link1 = CommandLink { counter++ }
        val link2 = CommandLink { counter +=3 }
        val link3 = CommandLink { counter +=4 }
        val chain = link1 + link2 + link3
        val link4 = CommandLink { counter-- }
        val chain2 = chain + link4
        chain2.run()
        assertEquals(7, counter)
    }


    @Test
    fun testAddingChains() {
        var counter = 0
        val link1 = CommandLink { counter++ }
        val link2 = CommandLink { counter +=3 }
        val link3 = CommandLink { counter +=4 }
        val chain1 = link1 + link2 + link3
        val chain2 = CommandLink {counter--} + CommandLink { counter -= 2 }
        (chain2+chain1).run()
        assertEquals(5, counter)
    }

}