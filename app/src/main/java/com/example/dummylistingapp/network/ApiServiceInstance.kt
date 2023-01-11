package com.example.dummylistingapp.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiServiceInstance {

    companion object{
        val baseUrl = "http://www.omdbapi.com/"

        // Build a Retrofit object
        fun getRetroInstance(): Retrofit{
            return Retrofit.Builder()
                .baseUrl(baseUrl)   // Set baseUrl
                // Set default converter, then it will translate the JSON response automatically.
                .addConverterFactory(GsonConverterFactory.create())
                // Retrofit ships with a default adapter for executing Call instances.
                // But can apply one or more additional adapters by supplying an instance of that adapter
                // when you’re building the Retrofit instance.
                // To use RxJava alongside Retrofit, need to added as below.
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }
    }
}