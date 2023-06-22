package el.stylian.sulawesi.datasyncservice.repositories

import el.stylian.sulawesi.datasyncservice.entities.Ticker
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TickerRepository : JpaRepository<Ticker, Long> {

}