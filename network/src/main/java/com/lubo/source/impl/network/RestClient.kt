package com.lubo.source.impl.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClient {

    private const val baseUrl = "https://devlightapp-299821.ew.r.appspot.com/"
    val retrofit: Retrofit by lazy(LazyThreadSafetyMode.NONE) {
        Retrofit.Builder()
            .client(
                OkHttpClient().newBuilder()
                    .addInterceptor(HttpLoggingInterceptor().also {
                        it.setLevel(HttpLoggingInterceptor.Level.BODY)
                    })
                    .addInterceptor(object : Interceptor {
                        override fun intercept(chain: Interceptor.Chain): Response {
                            val requestBuilder: Request.Builder = chain.request().newBuilder()
                            requestBuilder.header("Content-Type", "application/json")
                            return chain.proceed(requestBuilder.build())
                        }
                    }).build()
            )
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}