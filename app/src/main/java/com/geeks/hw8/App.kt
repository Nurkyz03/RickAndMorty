package com.geeks.hw8

import android.app.Application
import com.geeks.hw8.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidLogger(RequiresOptIn.Level.INFO)
            modules(appModule)
        }
    }
}