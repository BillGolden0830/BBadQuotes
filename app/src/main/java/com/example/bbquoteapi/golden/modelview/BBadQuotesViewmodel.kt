package com.example.bbquoteapi.golden.modelview

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bbquoteapi.golden.model.remote.*
import kotlinx.coroutines.*

class BBadQuotesViewmodel: ViewModel() {
    private val _quote = MutableLiveData<QuoteItem>()
    val newQuote: LiveData<QuoteItem>
        get() = _quote

    private val _fiveQuotes = MutableLiveData<FiveQuotes>()
    val newFive: LiveData<FiveQuotes>
        get()  = _fiveQuotes

    private val exHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
    }

    private val coroutineScope = CoroutineScope(Job() + Dispatchers.Main + exHandler)

    private val currentDispatcher = Dispatchers.IO

    init {
        coroutineScope.launch {
            val quoteResponse = BBadNetwork.BBadQuotesAPI.getAQuote()

            //Log.d(TAG, "COMPANY: $companyResponse")

            if (quoteResponse.isSuccessful)
               quoteResponse.body()?.let {
                    _quote.value = it
                }
            //async{}
        }

        coroutineScope.launch {
            val FiveResponse = BBadNetwork.BBadQuotesAPI.getFiveQuotes()

            //Log.d(TAG, "COMPANY: $companyResponse")

            if (FiveResponse.isSuccessful)
                FiveResponse.body()?.let {
                    _quote.value = it
                }
            //async{}
        }


}