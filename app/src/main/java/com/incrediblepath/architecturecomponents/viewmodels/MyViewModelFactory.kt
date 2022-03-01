package com.incrediblepath.architecturecomponents.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.incrediblepath.architecturecomponents.repository.Repository
import java.lang.IllegalArgumentException

class MyViewModelFactory(val repo:Repository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SampleRetrofitViewModel::class.java)){
            return SampleRetrofitViewModel(repo) as T
        } else{
            throw IllegalArgumentException("Model class is Invalid")
        }
    }
}