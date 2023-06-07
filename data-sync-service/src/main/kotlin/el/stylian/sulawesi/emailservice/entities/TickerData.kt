package el.stylian.sulawesi.emailservice.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.sql.Timestamp

@Entity
data class TickerData(
    @Column(unique=true)
    val ticker: String,
    val name: String,
    val latestPrice: Double,
    val lastChecked: Timestamp,
    @Id
    @GeneratedValue
    var id: Long? = null
){
    constructor(ticker: String) : this(ticker, "", 0.0, Timestamp(0))
}

