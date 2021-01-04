package a.klimashevsky.epamstockprice

import a.klimashevsky.epamstockprice.data.FinanceYahooApi
import a.klimashevsky.epamstockprice.data.FinanceYahooServiceImpl
import a.klimashevsky.epamstockprice.domain.FinanceYahooService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object DI {



    fun provideFinanceYahooService(): FinanceYahooService {

         val retrofit = Retrofit.Builder()
            .baseUrl("https://query1.finance.yahoo.com/v10/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

         val api = retrofit.create(FinanceYahooApi::class.java)
        return FinanceYahooServiceImpl(api)
    }
}
