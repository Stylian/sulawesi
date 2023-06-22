package el.stylian.sulawesi.datasyncservice.services

import el.stylian.sulawesi.datasyncservice.dtos.PriceAndVolumeQuote

interface TickerQuoteService {
    fun getPriceAndVolumeQuote(ticker: String): PriceAndVolumeQuote
}