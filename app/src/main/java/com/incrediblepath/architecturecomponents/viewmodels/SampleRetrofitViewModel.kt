package com.incrediblepath.architecturecomponents.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.incrediblepath.architecturecomponents.model.Post
import com.incrediblepath.architecturecomponents.repository.Repository
import kotlinx.coroutines.launch

class SampleRetrofitViewModel(private val repo:Repository):ViewModel() {

    val response = MutableLiveData<Post>()
    val listResponse = MutableLiveData<List<Post>>()
    fun getOnePost(){
        viewModelScope.launch {
                response.value = repo.getOnePost()
        }
    }

    fun getAnyPost(postNo:Int){
        viewModelScope.launch {
            response.value = repo.getAnyPost(postNo)
        }
    }
    fun getAllPostsOfUserId(userId:Int){
        viewModelScope.launch {
            listResponse.value = repo.getAllPostsOfUser(userId)
        }
    }
}