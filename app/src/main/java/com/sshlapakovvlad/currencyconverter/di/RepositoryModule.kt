package com.sshlapakovvlad.currencyconverter.di

import com.sshlapakovvlad.currencyconverter.config.CurrencyExchangeApplicationConfiguration
import com.sshlapakovvlad.currencyconverter.model.local.UserCurrencySelectionLocalService
import com.sshlapakovvlad.currencyconverter.model.remote.CurrencyExchangeRatesRemoteService
import com.sshlapakovvlad.currencyconverter.model.repository.CurrencyExchangeRatesRepository
import com.sshlapakovvlad.currencyconverter.model.repository.DualCurrencyExchangeRatesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesCurrencyExchangeRatesRepository(localServiceUser: UserCurrencySelectionLocalService,
                                                remoteService: CurrencyExchangeRatesRemoteService,
                                                applicationConfiguration: CurrencyExchangeApplicationConfiguration
    ): CurrencyExchangeRatesRepository =
        DualCurrencyExchangeRatesRepository(localServiceUser,remoteService, applicationConfiguration)
}