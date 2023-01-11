package com.example.dummylistingapp.network

import com.example.dummylistingapp.model.Item
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface HTTPClient {

    @GET("/")
    fun getItems(
        @Query("apikey") apiKey: String,
        @Query("t") text: String
    ): Observable<Item>
}