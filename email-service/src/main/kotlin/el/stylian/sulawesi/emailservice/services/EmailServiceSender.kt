package el.stylian.sulawesi.emailservice.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailServiceSender  @Autowired constructor(
        val emailSender: JavaMailSender
){

    // to make priceAlert and import here from another project ?

//    fun sendPriceAlert(priceAlert: priceAlert) {
//        val email = subscription.user.email
//        val price = subscription.value
//        val ticker = subscription.stock.ticker
//        val aboveOrBelow = if(subscription.operator == Subscription.Operator.GREATER_THAN) "above" else "below"
//        println("ADMIN: email to be sent: $email")
//        println("ADMIN: value of stock is $aboveOrBelow $price")

//        val message = SimpleMailMessage()
//        message.from = "emailmewhenapp@gmail.com"
//        message.to = arrayOf(email)
//        message.subject = "subject here"
//        message.text = "$ticker is now $aboveOrBelow \$$price"

        // commented out for testing TODO
//        emailSender.send(message)
//    }

}