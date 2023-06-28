package el.stylian.sulawesi.shared.dtos

data class EmailAlert(
    val email: String,
    val priceAlert: PriceAlert
)