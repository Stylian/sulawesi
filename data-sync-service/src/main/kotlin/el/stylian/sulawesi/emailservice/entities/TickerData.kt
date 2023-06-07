package el.stylian.sulawesi.emailservice.entities

import jakarta.persistence.*
import java.sql.Timestamp
import java.time.LocalDate
import java.util.Date

@Entity
data class TickerData(
    @ManyToOne(cascade = [CascadeType.PERSIST])
    val ticker: Ticker,
    val attribute: TickerAttribute,
    val value: Double,
    val date: Date,
    @Id
    @GeneratedValue
    var id: Long? = null
){
    constructor(
        ticker: Ticker,
        attribute: TickerAttribute,
        value: Double
    ) : this(ticker, attribute, value, Date()) // TODO date
}

