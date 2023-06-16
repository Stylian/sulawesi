package el.stylian.sulawesi.commons.chains

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ChainsTests {

    @Test
    fun testLinks() {

        var counter = 0
        val link1 = Link { counter++ }
        val link2 = Link { counter +=3 }
        val link3 = Link { counter +=4 }

        val chain = link1 + link2 + link3
        chain.run()
        assertEquals(8, counter)

        counter = 0
        val link4 = Link { counter-- }
        val chain2 = chain + link4
        chain2.run()
        assertEquals(7, counter)

        counter = 0
        val chain3 = chain2 + chain
        chain3.run()
        assertEquals(15, counter)
    }


    @Test
    fun testLinkImplementation() {

        var counter = 0
        class Link1 : AbstractLink() {
            override fun execute() {
                counter ++
            }
        }
        val link1 = Link1()
        link1.run()
        assertEquals(1, counter)
    }
    @Test
    fun testLinkImplementationWithFunction() {

        var counter = 0
        class Link2 : AbstractLink() {
            override fun execute() {
                counter ++
            }
        }
        // to look into it if possible
        val link1 = Link2() // { counter += 4 }
        link1.run()
//        assertEquals(5, counter)
    }
}