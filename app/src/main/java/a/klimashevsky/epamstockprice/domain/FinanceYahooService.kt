package a.klimashevsky.epamstockprice.domain

import io.reactivex.Observable


interface FinanceYahooService {
    fun getStockPrice(ticker: String): Observable<StockPriceInfo>
}
