package com.example.bbquoteapi.golden.model.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface BBadQuotesAPI {
    @GET(RAND_QUOTE)
    suspend fun getAQuote(): QuoteResponse

    @GET(RAND_FIVE)
    suspend fun getFiveQuotes(): FiveQuotes
}