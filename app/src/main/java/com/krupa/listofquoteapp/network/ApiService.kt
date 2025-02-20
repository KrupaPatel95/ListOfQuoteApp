package com.krupa.listofquoteapp.network

import com.krupa.listofquoteapp.response.QuoteList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("quotes")
    fun listQuote(): Call<QuoteList>
}