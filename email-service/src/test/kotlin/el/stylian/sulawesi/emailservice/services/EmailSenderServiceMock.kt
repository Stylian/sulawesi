package el.stylian.sulawesi.emailservice.services

import el.stylian.sulawesi.emailservice.dtos.PriceAlert
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.javamail.JavaMailSender

class EmailSenderServiceMock  @Autowired constructor(
    val emailSender: JavaMailSender
): EmailSenderService{
    override fun sendPriceAlert(email: String, priceAlert: PriceAlert) {


    }
}