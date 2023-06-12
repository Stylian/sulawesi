package el.stylian.sulawesi.emailservice.controllers

import el.stylian.sulawesi.emailservice.entities.Ticker
import el.stylian.sulawesi.emailservice.repositories.TickerDataRepository
import el.stylian.sulawesi.emailservice.repositories.TickerRepository
import el.stylian.sulawesi.emailservice.services.DataSyncService
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers


@SpringBootTest
@Testcontainers
@TestInstance(Lifecycle.PER_CLASS)
class DataSyncControllerTests @Autowired constructor(
    val tickerRepository: TickerRepository,
    val tickerDataRepository: TickerDataRepository,
    val dataSyncService: DataSyncService
) {

    @Container
    var mySQLContainer = MySQLContainer("mysql:8.0.30")

    init {
        mySQLContainer.start()
        System.setProperty("spring.datasource.url", mySQLContainer.getJdbcUrl());
    }
    @BeforeAll
    fun init() {
        tickerDataRepository.deleteAll()
        tickerRepository.deleteAll()
        tickerRepository.save(Ticker("BABA"))
        tickerRepository.save(Ticker("TSLA"))
    }
    @Test
    fun shouldSyncTickers() {
        dataSyncService.syncTickerPrices()
        assert(tickerDataRepository.findByTickerIdentifier("BABA").isNotEmpty())
    }

}