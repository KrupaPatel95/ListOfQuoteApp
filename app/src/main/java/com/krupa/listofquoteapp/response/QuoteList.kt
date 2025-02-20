package com.krupa.listofquoteapp.response

data class QuoteList(
    val quotes: List<Quote> = listOf()
)

data class Quote(
    val id: Int,
    val quote: String
)
