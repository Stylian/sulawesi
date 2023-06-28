package el.stylian.sulawesi.emailservice.services

import el.stylian.sulawesi.shared.dtos.PriceAlert


interface EmailSenderService {
    fun sendPriceAlert(email: String, priceAlert: PriceAlert)

}