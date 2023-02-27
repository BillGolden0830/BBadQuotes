package com.example.bbquoteapi.golden.model.remote

import com.squareup.moshi.Json

data class QuoteResponse (
    val quoteItem: QuoteItem
)

data class FiveQuotes(
    val fiveQuotes: List<QuoteItem>
)

data class QuoteItem(
    val quote: String,
    val author: String
)