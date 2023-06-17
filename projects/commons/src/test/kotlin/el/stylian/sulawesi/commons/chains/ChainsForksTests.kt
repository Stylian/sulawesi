package el.stylian.sulawesi.commons.chains

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ChainsForksTests {
    @Test
    fun testForkingCondition() {
        var counter = 0
        val link1 = CommandLink { counter++ }
        val link2 = CommandLink { counter +=3 }
        val link3 = CommandLink { counter +=4 }
        val chain1 = link1 + link2 + link3
        val chainMain = CommandLink { counter-- } + CommandLink { counter -= 2 }
        val chainAlter = CommandLink { counter -= 10 }

        val chain = chain1 + ForkLink(false, chainMain, chainAlter)
        chain.run()
        assertEquals(-2, counter)

    }

    @Test
    fun testForkEnd() {
        var counter = 0
        val link1 = CommandLink { counter++ }
        val link2 = CommandLink { counter +=3 }
        val link3 = CommandLink { counter +=4 }
        val link4 = CommandLink { counter-- }
        val chain1 = link1 + link2 + link3
        val chainMain = CommandLink { counter-- } + CommandLink { counter -= 2 }
        val chainAlter = CommandLink { counter -= 10 }

        val chain = chain1 + ForkLink(false, chainMain, chainAlter) + link4
        chain.run()
        assertEquals(-3, counter)
    }

}