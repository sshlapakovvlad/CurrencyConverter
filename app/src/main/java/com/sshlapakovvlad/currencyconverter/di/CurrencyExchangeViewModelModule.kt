package com.sshlapakovvlad.currencyconverter.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sshlapakovvlad.currencyconverter.presentation.viewmodel.CurrencyExchangeRatesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class CurrencyExchangeViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CurrencyExchangeRatesViewModel::class)
    abstract fun bindCurrencyExchangeRatesViewModel(viewModel: CurrencyExchangeRatesViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: CurrencyExchangeViewModelFactory): ViewModelProvider.Factory
}