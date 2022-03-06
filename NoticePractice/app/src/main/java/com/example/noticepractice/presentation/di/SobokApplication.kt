package com.example.noticepractice.presentation.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SobokApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SobokApplication)
            modules(dataSourceModule, repositoryModule, viewModelModule)
        }

//        SobokSharedPreference.init(applicationContext)
    }
}
