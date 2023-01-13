package com.example.dummylistingapp

import android.app.Application
import com.example.dummylistingapp.module.networkModule
import com.example.dummylistingapp.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidContext(this@MyApplication)
            modules(listOf(networkModule, viewModelModule))
        }
    }
}