package com.sshlapakovvlad.currencyconverter.di

import com.sshlapakovvlad.currencyconverter.config.CurrencyExchangeApplicationConfiguration
import com.sshlapakovvlad.currencyconverter.model.remote.CurrencyExchangeRatesRemoteService
import com.sshlapakovvlad.currencyconverter.model.remote.RevolutCurrencyExchangeRatesAPI
import com.sshlapakovvlad.currencyconverter.model.remote.RevolutCurrencyExchangeRatesRemoteService
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RemoteServiceModule {

    @Singleton
    @Provides
    fun providesCurrencyExchangeRatesRemoteService(revolutCurrencyExchangeRatesAPI: RevolutCurrencyExchangeRatesAPI): CurrencyExchangeRatesRemoteService =
        RevolutCurrencyExchangeRatesRemoteService(revolutCurrencyExchangeRatesAPI)

    @Singleton
    @Provides
    fun providesRevolutCurrencyExchangeRatesAPI(restAdapter: Retrofit): RevolutCurrencyExchangeRatesAPI =
        restAdapter.create(RevolutCurrencyExchangeRatesAPI::class.java)


    @Singleton
    @Provides
    fun providesRestAdapter(applicationConfiguration: CurrencyExchangeApplicationConfiguration): Retrofit =
        Retrofit.Builder()
            .baseUrl(applicationConfiguration.currencyExchangeRatesApiEndpoint)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    @Singleton
    @Provides
    fun providesOkHttpClient(applicationConfiguration: CurrencyExchangeApplicationConfiguration): OkHttpClient =
            OkHttpClient.Builder()
                .connectTimeout(applicationConfiguration.connectionTimeoutValue, applicationConfiguration.connectionTimeoutTimeUnit)
                .readTimeout(applicationConfiguration.readTimeoutValue, applicationConfiguration.readTimeoutTimeUnit)
                .build()
}