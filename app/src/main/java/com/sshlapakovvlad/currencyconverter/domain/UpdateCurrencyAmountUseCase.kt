package com.sshlapakovvlad.currencyconverter.domain

import com.sshlapakovvlad.currencyconverter.model.repository.CurrencyExchangeRatesRepository
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers
import java.math.BigDecimal

/**
 * Updates currency amount to the new, selected one.
 *
 */
class UpdateCurrencyAmountUseCase(private val repository: CurrencyExchangeRatesRepository) {

    fun run(newCurrencyAmount: BigDecimal): Completable =
        repository
            .updateUserCurrencyAmountSelection(newCurrencyAmount)
            .subscribeOn(Schedulers.io())
}