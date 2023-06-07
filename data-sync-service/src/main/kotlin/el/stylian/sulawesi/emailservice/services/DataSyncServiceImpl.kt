package el.stylian.sulawesi.emailservice.services

import el.stylian.sulawesi.emailservice.entities.TickerAttribute
import el.stylian.sulawesi.emailservice.entities.TickerData
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

            val tickerData = TickerData(ticker, TickerAttribute.PRICE, priceQuote.price)
            tickerDataRepository.save(tickerData) // TODO to make as batch
        }

    }

}