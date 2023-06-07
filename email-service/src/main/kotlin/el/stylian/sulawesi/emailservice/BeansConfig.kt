package el.stylian.sulawesi.emailservice

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.mail.javamail.JavaMailSenderImpl
@Configuration
class BeansConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.mail")
    fun getJavaMailSender() = JavaMailSenderImpl()
}