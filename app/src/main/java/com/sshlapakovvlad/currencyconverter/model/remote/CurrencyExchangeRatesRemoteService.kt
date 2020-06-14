package com.sshlapakovvlad.currencyconverter.model.remote

import com.sshlapakovvlad.currencyconverter.model.model.CurrencyExchangeRatesModel
import io.reactivex.Single
import java.util.*

interface CurrencyExchangeRatesRemoteService {

    fun getExchangeRatesForBase(baseCurrency: Currency): Single<CurrencyExchangeRatesModel>
}