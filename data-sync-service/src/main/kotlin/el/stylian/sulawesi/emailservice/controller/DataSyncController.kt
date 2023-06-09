package el.stylian.sulawesi.emailservice.controller

import el.stylian.sulawesi.emailservice.services.DataSyncService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/data-sync")
class DataSyncController @Autowired constructor(
    val dataSyncService: DataSyncService
) {

    @PostMapping("/sync-tickers")
    fun syncTickers(): String {
        dataSyncService.syncTickerPrices()
        return "ticker prices have been synced"
    }

}