package el.stylian.sulawesi.emailservice.repositories

import el.stylian.sulawesi.emailservice.entities.Ticker
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TickerRepository : JpaRepository<Ticker, Long> {

}