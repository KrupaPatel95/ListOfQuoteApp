package com.krupa.listofquoteapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.krupa.listofquoteapp.network.ApiRepository
import com.krupa.listofquoteapp.response.Quote
import com.krupa.listofquoteapp.response.QuoteList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel  @Inject constructor(
    private val apiRepository: ApiRepository
) : ViewModel() {

    private val _dataList = MutableStateFlow<List<Quote>>(emptyList())
    var dataList: StateFlow<List<Quote>> = _dataList

    //call api
    fun fetchQuote(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = apiRepository.getAllQuote().execute()
                Log.e("response",response.body().toString())
                if (response.isSuccessful) {
                    _dataList.value = response.body()?.quotes ?: emptyList()
                } else {
                    _dataList.value = emptyList()
                }
            } catch (e: Exception) {
                Log.e("e",e.toString())
                _dataList.value = emptyList()
            }
        }


    }
}