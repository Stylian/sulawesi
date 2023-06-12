package el.stylian.sulawesi.emailservice.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import el.stylian.sulawesi.emailservice.entities.Ticker
import el.stylian.sulawesi.emailservice.repositories.TickerDataRepository
import el.stylian.sulawesi.emailservice.repositories.TickerRepository
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers


@SpringBootTest
@Testcontainers
@TestInstance(Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
class DataSyncControllerTests @Autowired constructor(
    val tickerRepository: TickerRepository,
    val tickerDataRepository: TickerDataRepository,
) {

    @Container
    var mySQLContainer = MySQLContainer("mysql:8.0.30")

    @Autowired
    private val mockMvc: MockMvc? = null

    @Autowired
    private val objectMapper: ObjectMapper? = null

    init {
        mySQLContainer.start()
        System.setProperty("spring.datasource.url", mySQLContainer.getJdbcUrl());
        System.setProperty("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
    }
    @BeforeAll
    fun init() {
        tickerRepository.save(Ticker("BABA"))
        tickerRepository.save(Ticker("TSLA"))
    }
    @Test
    fun shouldSyncTickers() {

        mockMvc!!.perform(
            MockMvcRequestBuilders.post("/api/data-sync/sync-tickers")
                .contentType(MediaType.APPLICATION_JSON)
        )

        assert(tickerDataRepository.findByTickerIdentifier("BABA").isNotEmpty())
    }

    @AfterAll
    fun tearDown() {
        tickerDataRepository.deleteAll()
        tickerRepository.deleteAll()
    }

}