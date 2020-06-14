package com.sshlapakovvlad.currencyconverter.di

import com.sshlapakovvlad.currencyconverter.config.CurrencyExchangeApplicationConfiguration
import com.sshlapakovvlad.currencyconverter.domain.ObserveUserCurrencyExchangeRatesListChangesUseCase
import com.sshlapakovvlad.currencyconverter.domain.UpdateBaseCurrencyUseCase
import com.sshlapakovvlad.currencyconverter.domain.UpdateCurrencyAmountUseCase
import com.sshlapakovvlad.currencyconverter.model.repository.CurrencyExchangeRatesRepository
import dagger.Module
import dagger.Provides
import java.math.MathContext
import javax.inject.Singleton

@Module
class CurrencyExchangeModule {

    @Singleton
    @Provides
    fun providesObserveUserCurrencyExchangeRatesListUseCase(
        repository: CurrencyExchangeRatesRepository,
        configuration: CurrencyExchangeApplicationConfiguration,
        mathContext: MathContext): ObserveUserCurrencyExchangeRatesListChangesUseCase
            = ObserveUserCurrencyExchangeRatesListChangesUseCase(repository, configuration, mathContext)

    @Singleton
    @Provides
    fun providesChangeCurrencyAmountUseCase(repository: CurrencyExchangeRatesRepository): UpdateCurrencyAmountUseCase
            = UpdateCurrencyAmountUseCase(repository)

    @Singleton
    @Provides
    fun providesChangeBaseCurrencyUseCase(repository: CurrencyExchangeRatesRepository): UpdateBaseCurrencyUseCase
            = UpdateBaseCurrencyUseCase(repository)

    @Singleton
    @Provides
    fun providesMathContext(configuration: CurrencyExchangeApplicationConfiguration): MathContext
            = MathContext(configuration.mathCalculationPrecision, configuration.mathCalculationRoundingMode)
}