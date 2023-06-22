package el.stylian.sulawesi.commons.chains

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ChainsExampleTest {
    @Test
    fun testExampleWithFallbackAndData() {
        var counter = 0
        val emailData = EmailDTO("John@papia.el", "")
        val chain = PrepareEmailDataLink() + (SendEmailLink() / CommandLink { counter++ })..emailData
        chain.run()
        assertEquals(1, counter)
    }
}

data class EmailDTO(var sender: String, var body: String)
class PrepareEmailDataLink : ExecutableLink<EmailDTO>() {
    override fun execute() {
        assertEquals("John@papia.el", data?.sender)
        data?.body = "the body"
    }

}

class SendEmailLink : ExecutableLink<EmailDTO>() {
    override fun execute() {
        assertEquals("John@papia.el", data?.sender)
        assertEquals("the body", data?.body)
        throw FallbackException("Something goes wrong here")
    }

}
