package el.stylian.sulawesi.emailservice.dtos

data class PriceAlert (
    val price: Double,
    val stock: StockData,
    val direction: Direction
)

data class StockData(
    val ticker: String,
    val name: String
)

enum class Direction {
    ABOVE,
    BELOW
}