package com.sshlapakovvlad.currencyconverter.di

import com.sshlapakovvlad.currencyconverter.presentation.activity.CurrencyExchangeListActivity
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule : AndroidInjector<CurrencyExchangeListActivity> {

    @ContributesAndroidInjector
    fun contributeCurrencyExchangeListActivity(): CurrencyExchangeListActivity
}