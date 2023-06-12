package el.stylian.sulawesi.emailservice.services

import el.stylian.sulawesi.emailservice.dtos.Direction
import el.stylian.sulawesi.emailservice.dtos.PriceAlert
import el.stylian.sulawesi.emailservice.dtos.StockData
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class EmailSenderServiceTests {

    private val emailSenderService = EmailSenderServiceImpl(JavaMailSenderMock())
    @Test
    fun badEmail() {
        assertThrows<InvalidEmailException> {
            emailSenderService.sendPriceAlert(
                "bla@blad@.br",
                PriceAlert(10.0, StockData("BABA", "Alibaba"), Direction.BELOW)
            )
        }
    }
    @Test
    fun goodEmail() {
        emailSenderService.sendPriceAlert("emailmewhenapp@gmail.com",
            PriceAlert(10.0, StockData("BABA", "Alibaba"), Direction.BELOW))
    }
}