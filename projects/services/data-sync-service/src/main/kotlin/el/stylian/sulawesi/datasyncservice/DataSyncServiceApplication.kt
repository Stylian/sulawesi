package el.stylian.sulawesi.datasyncservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DataSyncServiceApplication

fun main(args: Array<String>) {
	runApplication<DataSyncServiceApplication>(*args)
}
