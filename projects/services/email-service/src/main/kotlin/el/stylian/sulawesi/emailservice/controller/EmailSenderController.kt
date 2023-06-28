package el.stylian.sulawesi.emailservice.controller

import el.stylian.sulawesi.emailservice.services.EmailSenderService
import el.stylian.sulawesi.shared.dtos.EmailAlert
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/email")
class EmailSenderController @Autowired constructor(
    val emailSenderService: EmailSenderService
) {

    @PostMapping("/send")
    fun sendEmail(@RequestBody emailAlert: EmailAlert): String {
        emailSenderService.sendPriceAlert(emailAlert.email, emailAlert.priceAlert)
        return "email sent successfully"
    }

}