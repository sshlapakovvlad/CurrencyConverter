package com.sshlapakovvlad.currencyconverter

import android.app.Activity
import android.app.Application
import com.sshlapakovvlad.currencyconverter.config.CurrencyExchangeApplicationConfiguration
import com.sshlapakovvlad.currencyconverter.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class CurrencyExchangeApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerApplicationComponent.builder()
            .withApplicationContext(this)
            .withApplicationConfiguration(CurrencyExchangeApplicationConfiguration())
            .build()
            .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}