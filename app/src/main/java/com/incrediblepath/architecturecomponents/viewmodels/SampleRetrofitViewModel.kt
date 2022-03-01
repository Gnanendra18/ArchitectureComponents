package com.incrediblepath.architecturecomponents.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.incrediblepath.architecturecomponents.model.Post
import com.incrediblepath.architecturecomponents.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class SampleRetrofitViewModel(private val repo:Repository):ViewModel() {

    val response = MutableLiveData<Post>()
    val listOfPosts = MutableLiveData<Response<List<Post>>>()
    fun getOnePost(postNo:Int){
        viewModelScope.launch {
            response.value = repo.getAnyPost(postNo)
        }

    }

    fun getPostsOfUser(userId:Int){
        viewModelScope.launch {
            listOfPosts.value = repo.getAllPostsOfUser(userId)
        }

    }
}