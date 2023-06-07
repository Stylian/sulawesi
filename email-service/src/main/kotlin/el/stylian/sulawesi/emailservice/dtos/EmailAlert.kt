package el.stylian.sulawesi.emailservice.dtos

data class EmailAlert(
    val email: String,
    val priceAlert: PriceAlert
)