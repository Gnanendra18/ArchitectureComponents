package com.incrediblepath.architecturecomponents.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.incrediblepath.architecturecomponents.repository.Repository
import java.lang.IllegalArgumentException

class SampleRetrofitActivityViewModelFactory(val repo:Repository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SampleRetrofitActivityViewModel::class.java)){
            return SampleRetrofitActivityViewModel(repo) as T
        }else{
            throw IllegalArgumentException("Invalid Model Class")
        }
    }
}