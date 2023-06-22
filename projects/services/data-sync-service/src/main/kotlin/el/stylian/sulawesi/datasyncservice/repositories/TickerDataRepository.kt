package el.stylian.sulawesi.datasyncservice.repositories

import el.stylian.sulawesi.datasyncservice.entities.TickerData
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TickerDataRepository : JpaRepository<TickerData, Long> {

    fun findByTickerIdentifier(identifier: String) : List<TickerData>

}