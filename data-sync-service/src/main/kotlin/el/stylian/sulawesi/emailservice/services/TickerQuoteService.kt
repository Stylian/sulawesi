package el.stylian.sulawesi.emailservice.services

import el.stylian.sulawesi.emailservice.dtos.PriceQuote

interface TickerQuoteService {
    fun getPriceQuote(ticker: String): PriceQuote
}