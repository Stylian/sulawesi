package el.stylian.sulawesi.emailservice.services

import jakarta.mail.internet.MimeMessage
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessagePreparator
import java.io.InputStream

class JavaMailSenderMock : JavaMailSender {
    override fun send(mimeMessage: MimeMessage) {
        throw NotImplementedError("An operation is not implemented:")
    }

    override fun send(vararg mimeMessages: MimeMessage?) {
        throw NotImplementedError("An operation is not implemented:")
    }

    override fun send(mimeMessagePreparator: MimeMessagePreparator) {
        throw NotImplementedError("An operation is not implemented:")
    }

    override fun send(vararg mimeMessagePreparators: MimeMessagePreparator?) {
        throw NotImplementedError("An operation is not implemented:")
    }

    override fun send(simpleMessage: SimpleMailMessage) {
        println("ADMIN: email mock sent ")
    }

    override fun send(vararg simpleMessages: SimpleMailMessage?) {
        throw NotImplementedError("An operation is not implemented:")
    }

    override fun createMimeMessage(): MimeMessage {
        throw NotImplementedError("An operation is not implemented:")
    }

    override fun createMimeMessage(contentStream: InputStream): MimeMessage {
        throw NotImplementedError("An operation is not implemented:")
    }
}