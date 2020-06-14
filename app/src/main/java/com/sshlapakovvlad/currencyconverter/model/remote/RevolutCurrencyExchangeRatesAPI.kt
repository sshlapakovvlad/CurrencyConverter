package com.sshlapakovvlad.currencyconverter.model.remote

import com.sshlapakovvlad.currencyconverter.model.model.CurrencyExchangeRatesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface RevolutCurrencyExchangeRatesAPI {

    @GET("latest")
    fun getCurrencyRatesForBase(@Query("base") baseCurrency: Currency): Single<CurrencyExchangeRatesResponse>
}