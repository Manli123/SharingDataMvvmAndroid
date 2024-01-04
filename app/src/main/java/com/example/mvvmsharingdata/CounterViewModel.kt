package com.example.mvvmsharingdata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {

    private val counter = MutableLiveData<Int>()

    init {
        counter.value=0
    }

    //!! for not null
     fun increament(){
        counter.value= counter.value!! + 1
    }
    fun decrament(){
        counter.value= counter.value!! - 1
    }


    //getCounter function returns counter
    fun getCounter():LiveData<Int> = counter
}