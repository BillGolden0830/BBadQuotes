package com.example.bbquoteapi.golden.model.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory



object BBadNetwork {
        val BBadQuotesAPI: BBadQuotesAPI by lazy{
            initRetrofit()
        }


    private fun initRetrofit(): BBadQuotesAPI{

        /*val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)*/
        val client: OkHttpClient = OkHttpClient.Builder()
            //.addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create(BBadQuotesAPI::class.java)
    }
}