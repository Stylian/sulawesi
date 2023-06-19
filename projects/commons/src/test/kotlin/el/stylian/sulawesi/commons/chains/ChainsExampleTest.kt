package el.stylian.sulawesi.commons.chains

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ChainsExampleTest {
    @Test
    fun testExample() {
        val emailData = EmailDTO("John@papia.el", "")
        val chain = PrepareEmailDataLink() + SendEmailLink() .. emailData
        chain.run()
    }
}

data class EmailDTO(var sender: String, var body: String)
class PrepareEmailDataLink : AbstractLink<EmailDTO>() {
    override fun execute() {
        assertEquals("John@papia.el" , data?.sender)
        data?.body = "Setting the body here"
    }

}

class SendEmailLink : AbstractLink<EmailDTO>() {
    override fun execute() {
        assertEquals("John@papia.el" , data?.sender)
        assertEquals("Setting the body here" , data?.body)
    }

}