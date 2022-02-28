package com.incrediblepath.architecturecomponents.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.incrediblepath.architecturecomponents.model.Post
import com.incrediblepath.architecturecomponents.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response

class SampleRetrofitActivityViewModel(private val repository:Repository):ViewModel() {

    val response = MutableLiveData<Response<Post>>()
    val userPostsResponse = MutableLiveData<Response<List<Post>>>()
    fun getPostData(){
        viewModelScope.launch {
            response.value = repository.getOnePost()
        }
    }

    fun getPostDataOfPostNo(postNo:Int){
        viewModelScope.launch {
            response.value = repository.getPost(postNo)
        }
    }

    fun getUserPosts(userId:Int){
        viewModelScope.launch {
            userPostsResponse.value = repository.getUserPosts(userId)
        }
    }
}