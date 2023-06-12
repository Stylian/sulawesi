package el.stylian.sulawesi.emailservice.services

import el.stylian.sulawesi.emailservice.dtos.PriceAndVolumeQuote
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.BufferedReader
import java.net.HttpURLConnection
import java.net.URL

@Service
class AlphaVantageTickerQuoteService : TickerQuoteService {

    @Value("\${alpha-vantage.api}")
    var api = "LK7K77EXHJTC65S7"
    override fun getPriceAndVolumeQuote(ticker: String): PriceAndVolumeQuote {

        val url = URL("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=$ticker&apikey=$api")

        // to move to separate library project
        val connection = url.openConnection() as HttpURLConnection
        try {
            val content = connection.inputStream.bufferedReader().use(BufferedReader::readText)
            return getPriceAndVolumeFromQuote(content)

        }catch (e: Exception) {
            throw TickerQuoteServiceException()
        }finally{
            connection.disconnect()
        }
    }

    private fun getPriceAndVolumeFromQuote(quote: String): PriceAndVolumeQuote {
        var priceLine: String? = null
        var volumeLine: String? = null
        quote.split("\n").forEach{
            if(it.contains("price"))
                priceLine = it
            if(it.contains("volume"))
                volumeLine = it
        }

        return PriceAndVolumeQuote(
            priceLine!!.split("\"")[3].toDouble(),
            volumeLine!!.split("\"")[3].toInt()
        )
    }
}