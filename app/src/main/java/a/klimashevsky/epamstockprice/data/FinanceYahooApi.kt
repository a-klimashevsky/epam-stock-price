package a.klimashevsky.epamstockprice.data

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface FinanceYahooApi {
    @GET("finance/quoteSummary/{ticker}?modules=price")
    fun fetchStockInfo(@Path("ticker") ticker: String): Observable<StockInfo>
}
