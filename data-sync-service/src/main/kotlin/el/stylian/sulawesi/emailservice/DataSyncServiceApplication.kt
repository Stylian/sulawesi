package el.stylian.sulawesi.emailservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
//@EnableEurekaClient
class DataSyncServiceApplication

fun main(args: Array<String>) {
	runApplication<DataSyncServiceApplication>(*args)
}
