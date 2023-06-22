package el.stylian.sulawesi.datasyncservice.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
data class Ticker (
    @Column(unique=true)
    val identifier: String,

    @Id
    @GeneratedValue
    var id: Long? = null
) {
    constructor(identifier: String) : this(identifier,  -1L)
}