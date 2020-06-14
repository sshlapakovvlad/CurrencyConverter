package com.sshlapakovvlad.currencyconverter.di

import android.app.Application
import com.sshlapakovvlad.currencyconverter.model.local.RoomUserCurrencySelectionDatabase
import com.sshlapakovvlad.currencyconverter.model.local.RoomUserCurrencySelectionLocalService
import com.sshlapakovvlad.currencyconverter.model.local.UserCurrencySelectionLocalService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalServiceModule {

    @Singleton
    @Provides
    fun providesCurrencyExchangeRateLocalService(roomUserCurrencySelectionDatabase: RoomUserCurrencySelectionDatabase): UserCurrencySelectionLocalService =
        RoomUserCurrencySelectionLocalService(roomUserCurrencySelectionDatabase)

    @Singleton
    @Provides
    fun providesRoomCurrencyExchangeRatesDatabase(application: Application): RoomUserCurrencySelectionDatabase =
        RoomUserCurrencySelectionDatabase.getInstance(application)
}