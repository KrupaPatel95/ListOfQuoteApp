package com.krupa.listofquoteapp

import android.content.ClipData.Item
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun QuoteScreen(){
    val viewModel: QuoteViewModel = hiltViewModel()
    val list by viewModel.dataList.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchQuote()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        if (list.isNotEmpty()){
            LazyColumn {
                items(list) {
                    Text(text = it.quote)
                }
            }
        }
    }


}