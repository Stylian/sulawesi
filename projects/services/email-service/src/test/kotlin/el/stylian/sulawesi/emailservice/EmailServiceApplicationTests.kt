package el.stylian.sulawesi.emailservice

import com.netflix.discovery.EurekaClient
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class EmailServiceApplicationTests {
	@MockBean
	private val eurekaClient: EurekaClient? = null
	@Test
	fun contextLoads() {
	}

}