package el.stylian.sulawesi.emailservice.services

import el.stylian.sulawesi.emailservice.repositories.TickerDataRepository
import org.springframework.beans.factory.annotation.Autowired

class DataSyncServiceImpl @Autowired constructor(
    val tickerDataRepository: TickerDataRepository,
    val tickerQuoteService: TickerQuoteService
): DataSyncService {
    override fun syncTickerPrices() {

        for(tickerData in tickerDataRepository.findAll()) {
            val priceQuote = tickerQuoteService.getPriceQuote(tickerData.ticker)

            // todo
            // I actually need a separate ticker class and to hold all old prices.
            // but need to fetch the latest
            // need that to make charts
            val newTickerData = tickerData.copy()
//            newTickerData.latestPrice = priceQuote.price
//            newTickerData.
        }

    }

}