package a.klimashevsky.epamstockprice

import a.klimashevsky.epamstockprice.domain.FinanceYahooService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import io.reactivex.android.schedulers.AndroidSchedulers

class MainActivity : AppCompatActivity() {

    private lateinit var priceView: TextView

    private lateinit var service: FinanceYahooService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        priceView = findViewById(R.id.price_view)

        service = DI.provideFinanceYahooService()
    }

    override fun onStart() {
        super.onStart()

        service.getStockPrice("EPAM")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                priceView.text = it.price.toString()
            }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
