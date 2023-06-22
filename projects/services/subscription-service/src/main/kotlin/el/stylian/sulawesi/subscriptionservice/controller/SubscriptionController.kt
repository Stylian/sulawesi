package el.stylian.sulawesi.subscriptionservice.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/subscriptions")
class SubscriptionController @Autowired constructor(
//    val dataSyncService: DataSyncService
) {

//    @PostMapping("/sync-tickers")
//    fun syncTickers(): String {
//        dataSyncService.syncTickerPrices()
//        return "ticker prices have been synced"
//    }

}