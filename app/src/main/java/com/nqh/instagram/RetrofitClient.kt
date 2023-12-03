package com.nqh.instagram

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val retrofit : Retrofit.Builder by lazy {

        val levelType : Level = Level.BODY

        val logging = HttpLoggingInterceptor()

        logging.setLevel(levelType)

        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.addInterceptor(logging)


        Retrofit.Builder().baseUrl("https://6567404664fcff8d7310095b.mockapi.io").client(okHttpClient.build()).addConverterFactory(GsonConverterFactory.create())

    }

    val apiInterface: ApiInterface by lazy {
        retrofit.build().create(ApiInterface::class.java)
    }

}