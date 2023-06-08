package el.stylian.sulawesi.emailservice.services

import el.stylian.sulawesi.emailservice.dtos.PriceAndVolumeQuote

interface TickerQuoteService {
    fun getPriceQuote(ticker: String): PriceAndVolumeQuote
}