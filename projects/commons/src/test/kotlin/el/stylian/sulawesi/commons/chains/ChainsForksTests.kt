package el.stylian.sulawesi.commons.chains

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ChainsForksTests {
    @Test
    fun testForkingCondition() {
        var counter = 0
        val chain1 = CommandLink<Nothing> { counter++ } + CommandLink { counter +=3 } + CommandLink { counter +=4 }
        val chainMain = CommandLink<Nothing> { counter-- } + CommandLink { counter -= 2 }
        val chainAlter = CommandLink<Nothing> { counter -= 10 }

        val chain = chain1 + ForkLink(false, chainMain, chainAlter)
        chain.run()
        assertEquals(-2, counter)
    }

    @Test
    fun testForkClosure() {
        var counter = 0
        val chain1 = CommandLink<Nothing> { counter++ } + CommandLink { counter +=3 } + CommandLink { counter +=4 }
        val chainMain = CommandLink<Nothing> { counter-- } + CommandLink { counter -= 2 }
        val chainAlter = CommandLink<Nothing> { counter -= 10 }

        val chain = chain1 + ForkLink({ true }, chainMain, chainAlter)
        chain.run()
        assertEquals(5, counter)
    }
    @Test
    fun testForkConditionChange() {
        var counter = 0
        val chain1 = CommandLink<Nothing> { counter++ } + CommandLink { counter +=3 } + CommandLink { counter +=4 }
        val chainMain = CommandLink<Nothing> { counter-- } + CommandLink { counter -= 2 }
        val chainAlter = CommandLink<Nothing> { counter -= 10 }

        val conditionHolder = ConditionHolder(false)
        val fork = ForkLink({ conditionHolder.condition }, chainMain, chainAlter)
        val chain = chain1 + fork

        conditionHolder.condition = true
        chain.run()
        assertEquals(5, counter)

    }
    data class ConditionHolder(var condition: Boolean)
}