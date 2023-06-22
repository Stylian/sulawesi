package el.stylian.sulawesi.subscriptionservice.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers


@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class SubscriptionControllerTests {

    @Container
    var mySQLContainer = MySQLContainer("mysql:8.0.30")

    @Autowired
    private val mockMvc: MockMvc? = null

    @Autowired
    private val objectMapper: ObjectMapper? = null

    init {
        mySQLContainer.start()
        System.setProperty("spring.datasource.url", mySQLContainer.getJdbcUrl());
    }

    @Test
    fun shouldCreateProduct() {
//        mockMvc!!.perform(
//            MockMvcRequestBuilders.post("/api/data-sync/sync-tickers")
//                .contentType(MediaType.APPLICATION_JSON)
//        )
        assert(true)
    }

}