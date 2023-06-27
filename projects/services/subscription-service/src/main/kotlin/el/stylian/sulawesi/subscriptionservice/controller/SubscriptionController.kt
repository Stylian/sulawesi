package el.stylian.sulawesi.subscriptionservice.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/subscriptions")
class SubscriptionController @Autowired constructor(
//    val dataSyncService: DataSyncService
) {

    @GetMapping("/test")
    fun test(): String {
        return "testworks"
    }

}