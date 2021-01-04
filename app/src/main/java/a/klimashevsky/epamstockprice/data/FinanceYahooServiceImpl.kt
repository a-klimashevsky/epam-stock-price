package a.klimashevsky.epamstockprice.data

import a.klimashevsky.epamstockprice.domain.FinanceYahooService
import a.klimashevsky.epamstockprice.domain.StockPriceInfo
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class FinanceYahooServiceImpl(
    private val api: FinanceYahooApi
) : FinanceYahooService {

    override fun getStockPrice(ticker: String): Observable<StockPriceInfo> {
        return api.fetchStockInfo(ticker)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .doOnNext {

            }
            .observeOn(Schedulers.computation())
            .map {
                StockPriceInfo(
                    it.quoteSummary.result[0].price.regularMarketPrice.raw
                )
            }
            //.flatMap { it }
    }
}
