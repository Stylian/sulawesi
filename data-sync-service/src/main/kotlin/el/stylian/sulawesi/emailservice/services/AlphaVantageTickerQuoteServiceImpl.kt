package el.stylian.sulawesi.emailservice.services

import el.stylian.sulawesi.emailservice.dtos.PriceQuote

class AlphaVantageTickerQuoteServiceImpl : TickerQuoteService {
    override fun getPriceQuote(ticker: String): PriceQuote {
        TODO("Not yet implemented")
        return PriceQuote(44.4, 234)
    }
}