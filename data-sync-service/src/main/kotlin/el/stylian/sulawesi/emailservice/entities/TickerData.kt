package el.stylian.sulawesi.emailservice.entities

import jakarta.persistence.*
import java.util.*

@Entity
data class TickerData(
    @ManyToOne(cascade = [CascadeType.PERSIST])
    val ticker: Ticker,
    val price: Double,
    val volume: Int,
    val date: Date,
    @Id
    @GeneratedValue
    var id: Long? = null
){
    constructor(
        ticker: Ticker,
        price: Double,
        volume: Int,
    ) : this(ticker, price, volume, Date()) // TODO date
}

