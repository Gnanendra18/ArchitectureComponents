package com.incrediblepath.architecturecomponents.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.incrediblepath.architecturecomponents.model.Post
import com.incrediblepath.architecturecomponents.repository.Repository
import kotlinx.coroutines.launch

class SampleRetrofitViewModel(private val repo:Repository):ViewModel() {

    val response = MutableLiveData<Post>()
    fun getOnePost(){
        viewModelScope.launch {
            response.value = repo.getOnePost()
        }

    }
}