package el.stylian.sulawesi.datasyncservice.services

import el.stylian.sulawesi.datasyncservice.entities.TickerData
import el.stylian.sulawesi.datasyncservice.repositories.TickerDataRepository
import el.stylian.sulawesi.datasyncservice.repositories.TickerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DataSyncServiceImpl @Autowired constructor(
    val tickerRepository: TickerRepository,
    val tickerDataRepository: TickerDataRepository,
    val tickerQuoteService: TickerQuoteService
): DataSyncService {
    override fun syncTickerPrices() {
        var counter = 0
//        LibraryUtils()
        for(ticker in tickerRepository.findAll()) {
            println(++counter)
            println(ticker)
            val priceQuote = tickerQuoteService.getPriceAndVolumeQuote(ticker.identifier)

            val tickerPriceAndVolume = TickerData(ticker, priceQuote.price, priceQuote.volume)
            tickerDataRepository.save(tickerPriceAndVolume) // TODO to make as batch
        }

    }

}