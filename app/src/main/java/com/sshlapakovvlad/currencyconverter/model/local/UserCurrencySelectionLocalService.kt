package com.sshlapakovvlad.currencyconverter.model.local

import com.sshlapakovvlad.currencyconverter.model.model.UserCurrencySelectionModel
import io.reactivex.Completable
import io.reactivex.Flowable
import java.math.BigDecimal
import java.util.*

interface UserCurrencySelectionLocalService {

    fun observeUserCurrencySelections(): Flowable<UserCurrencySelectionModel>

    fun updateUserBaseCurrencySelection(newBaseCurrency: Currency): Completable

    fun updateUserCurrencyAmountSelection(newCurrencyAmount: BigDecimal): Completable
}