package el.stylian.sulawesi.emailservice.services

import el.stylian.sulawesi.emailservice.entities.TickerPriceAndVolume
import el.stylian.sulawesi.emailservice.repositories.TickerDataRepository
import el.stylian.sulawesi.emailservice.repositories.TickerRepository
import org.springframework.beans.factory.annotation.Autowired

class DataSyncServiceImpl @Autowired constructor(
    val tickerRepository: TickerRepository,
    val tickerDataRepository: TickerDataRepository,
    val tickerQuoteService: TickerQuoteService
): DataSyncService {
    override fun syncTickerPrices() {

        for(ticker in tickerRepository.findAll()) {
            val priceQuote = tickerQuoteService.getPriceQuote(ticker.identifier)

            val tickerPriceAndVolume = TickerPriceAndVolume(ticker, priceQuote.price, priceQuote.volume)
            tickerDataRepository.save(tickerPriceAndVolume) // TODO to make as batch
        }

    }

}