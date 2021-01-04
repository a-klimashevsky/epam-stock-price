package a.klimashevsky.epamstockprice.data

import com.google.gson.annotations.SerializedName

data class StockInfo(
    @SerializedName("quoteSummary")
    val quoteSummary: QuoteSummary
) {
    data class QuoteSummary(
        @SerializedName("error")
        val error: String?,
        @SerializedName("result")
        val result: List<Result>
    ) {
        data class Result(
            @SerializedName("price")
            val price: Price
        ) {
            data class Price(
                val regularMarketPrice: Value
            ) {

            }
        }
    }
}

data class Value(
    @SerializedName("raw")
    val raw: Double,
    @SerializedName("fmt")
    val formatted: String
)
