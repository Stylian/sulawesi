package el.stylian.sulawesi.subscriptionservice.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers


@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class SubscriptionControllerTests {

    @Container
    var mongoDBContainer: MongoDBContainer = MongoDBContainer("mongo:4.4.2")

    @Autowired
    private val mockMvc: MockMvc? = null

    @Autowired
    private val objectMapper: ObjectMapper? = null

    init {
        mongoDBContainer.start()
        System.setProperty("spring.data.mongodb.uri", mongoDBContainer.replicaSetUrl);
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