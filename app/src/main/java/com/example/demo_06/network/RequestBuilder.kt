package com.example.demo_06.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RequestBuilder {
    private var retrofitBuilder:Retrofit

//  APIとのリングを確立
    init {
        OkHttpClient.Builder()
            .connectTimeout(5,TimeUnit.SECONDS)
            .build().apply {
                retrofitBuilder=Retrofit.Builder()
                    .baseUrl(REQUEST_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(this)
                    .build()
            }
    }
    fun <T>getAPI(apiType:Class<T>):T= retrofitBuilder.create(apiType)
    companion object {
//      固定IP
//        const val REQUEST_URL="http://192.168.0.87:8080" // 11F
        const val REQUEST_URL="http://192.168.1.134:8080"
//        const val REQUEST_URL="http://192.168.0.79:8080"
    }
}