package el.stylian.sulawesi.emailservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SubscriptionServiceApplication

fun main(args: Array<String>) {
	runApplication<SubscriptionServiceApplication>(*args)
}