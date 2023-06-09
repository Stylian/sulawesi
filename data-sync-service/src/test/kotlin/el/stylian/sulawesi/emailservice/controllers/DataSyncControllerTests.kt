package el.stylian.sulawesi.emailservice.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import el.stylian.sulawesi.emailservice.entities.Ticker
import el.stylian.sulawesi.emailservice.repositories.TickerDataRepository
import el.stylian.sulawesi.emailservice.repositories.TickerRepository
import el.stylian.sulawesi.emailservice.services.DataSyncService
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers


@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class DataSyncControllerTests @Autowired constructor(
    val tickerRepository: TickerRepository,
    val tickerDataRepository: TickerDataRepository,
) {

    @Container
    var mongoDBContainer: MongoDBContainer = MongoDBContainer("mongo:4.4.2")

    @Autowired
    private val mockMvc: MockMvc? = null

    @Autowired
    private val objectMapper: ObjectMapper? = null

    init {
        mongoDBContainer.start()
        System.setProperty("spring.data.mongodb.uri", mongoDBContainer.getReplicaSetUrl());
    }

    @Test
    fun shouldSyncTickers() {

        tickerRepository.save(Ticker("BABA"))
        tickerRepository.save(Ticker("TSLA"))

        mockMvc!!.perform(
            MockMvcRequestBuilders.post("/api/data-sync/sync-tickers")
                .contentType(MediaType.APPLICATION_JSON)
        )

        assert(tickerDataRepository.findByTickerIdentifier("BABA").isNotEmpty())

    }

}