package el.stylian.sulawesi.emailservice.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
data class Ticker (
    @Id
    @GeneratedValue
    var id: Long? = null,
    val identifier: String
)