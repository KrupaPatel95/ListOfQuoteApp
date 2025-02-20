package com.krupa.listofquoteapp.network

import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {
        fun getAllQuote() = apiService.listQuote()
}