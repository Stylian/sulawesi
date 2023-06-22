package el.stylian.sulawesi.datasyncservice.services

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AlphaVantageTickerQuoteServiceTest {

    private val alphaVantageTickerQuoteService = AlphaVantageTickerQuoteService()

    @Test
    fun testTickerQuote() {
        val quote = alphaVantageTickerQuoteService.getPriceAndVolumeQuote("BABA")
        println(quote)
    }

    @Test
    fun failTickerQuote() {
        assertThrows<TickerQuoteServiceException> {
            alphaVantageTickerQuoteService.api = ""
            alphaVantageTickerQuoteService.getPriceAndVolumeQuote("BABA")
        }
    }

}