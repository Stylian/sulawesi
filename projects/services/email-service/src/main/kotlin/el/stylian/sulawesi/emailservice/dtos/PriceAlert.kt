package el.stylian.sulawesi.emailservice.dtos

data class PriceAlert(
    val price: Double,
    val stock: StockData,
    val direction: Direction
)


