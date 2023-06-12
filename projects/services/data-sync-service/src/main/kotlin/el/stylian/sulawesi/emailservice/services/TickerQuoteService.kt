package el.stylian.sulawesi.emailservice.services

import el.stylian.sulawesi.emailservice.dtos.PriceAndVolumeQuote

interface TickerQuoteService {
    fun getPriceAndVolumeQuote(ticker: String): PriceAndVolumeQuote
}