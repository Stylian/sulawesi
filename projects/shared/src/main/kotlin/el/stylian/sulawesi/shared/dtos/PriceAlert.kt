package el.stylian.sulawesi.shared.dtos

data class PriceAlert(
    val price: Double,
    val stock: StockData,
    val direction: Direction
)


