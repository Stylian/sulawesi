package el.stylian.sulawesi.emailservice.services

import el.stylian.sulawesi.emailservice.dtos.PriceAlert
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service
import java.util.regex.Pattern

@Service
class EmailSenderServiceImpl  @Autowired constructor(
    val emailSender: JavaMailSender
): EmailSenderService {
    override fun sendPriceAlert(email: String, priceAlert: PriceAlert) {

        if(!validateEmail(email)) throw InvalidEmailException("the email: $email is invalid")

        println("ADMIN: email to be sent: $email")
        println("ADMIN: value of stock is ${priceAlert.direction} ${priceAlert.price}")

        // TODO
        val message = SimpleMailMessage()
        message.from = "emailmewhenapp@gmail.com"
//        message.to = arrayOf(email)
        message.subject = "subject here"
        message.text = "${priceAlert.stock.ticker} is now ${priceAlert.direction} \$${priceAlert.price}"

        emailSender.send(message)
    }

    fun validateEmail(email: String) = Pattern.compile("^[a-zA-Z0-9_!#\$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+\$")
        .matcher(email).matches()

}