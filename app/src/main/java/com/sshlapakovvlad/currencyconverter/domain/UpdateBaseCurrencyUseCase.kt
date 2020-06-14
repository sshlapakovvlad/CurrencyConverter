package com.sshlapakovvlad.currencyconverter.domain

import com.sshlapakovvlad.currencyconverter.model.repository.CurrencyExchangeRatesRepository
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers
import java.util.*

/**
 * Updated base currency to the new selected one.
 *
 */
class UpdateBaseCurrencyUseCase(private val repository: CurrencyExchangeRatesRepository) {


    fun run(newBaseCurrency: Currency): Completable =
        repository.updateUserBaseCurrencySelection(newBaseCurrency)
            .subscribeOn(Schedulers.io())
}