package com.example.dummylistingapp.module

import com.example.dummylistingapp.BuildConfig
import com.example.dummylistingapp.network.ApiServiceInstance.Companion.getRetroInstance
import com.example.dummylistingapp.network.HTTPClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        getRetroInstance()
        getHttpClient(get())
    }
}

fun getRetroInstance(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)   // Set baseUrl
        // Set default converter, then it will translate the JSON response automatically.
        .addConverterFactory(GsonConverterFactory.create())
        // Retrofit ships with a default adapter for executing Call instances.
        // But can apply one or more additional adapters by supplying an instance of that adapter
        // when you’re building the Retrofit instance.
        // To use RxJava alongside Retrofit, need to added as below.
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
}

fun getHttpClient(retrofit: Retrofit): HTTPClient {
    return retrofit.create(HTTPClient::class.java)
}