package el.stylian.sulawesi.emailservice.services

import el.stylian.sulawesi.emailservice.dtos.PriceAndVolumeQuote

class AlphaVantageTickerQuoteServiceImpl : TickerQuoteService {
    override fun getPriceQuote(ticker: String): PriceAndVolumeQuote {
        TODO("Not yet implemented")
        return PriceAndVolumeQuote(44.4, 234)
    }
}