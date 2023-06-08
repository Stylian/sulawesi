package el.stylian.sulawesi.emailservice.repositories

import el.stylian.sulawesi.emailservice.entities.TickerPriceAndVolume
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TickerDataRepository : JpaRepository<TickerPriceAndVolume, Long> {

}