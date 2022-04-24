package com.cheezycode.quotify

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class MainViewModel(val context: Context): ViewModel() {
    private var quoteList: Array<Quote> = emptyArray()
    private var index = 0
    
    init {
        quoteList = loadQuoteFromAssets()
//
//        Log.d("rishu",(++index).toString())
//        Log.d("rishu",(index % quoteList.size).toString())
    }

    private fun loadQuoteFromAssets(): Array<Quote> {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        return gson.fromJson(json, Array<Quote>::class.java)
    }

    fun getQuote() :Quote= quoteList[index]




    fun nextQuote():Quote   = quoteList[++index]
lateinit var a:Quote
    fun previousQuote():Quote = quoteList[(--index ) ]
}
