package com.incrediblepath.architecturecomponents.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.incrediblepath.architecturecomponents.data.PostDao
import com.incrediblepath.architecturecomponents.data.PostDatabase
import com.incrediblepath.architecturecomponents.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SampleDatabaseViewModel(application: Application) : AndroidViewModel(application) {
    var postDao: PostDao

    var listOfPost = MutableLiveData<List<Post>>()
    init {
        val database = PostDatabase.getDatabase(application)
        postDao = database.postDao()



    }

    fun retrievePosts(){
        viewModelScope.launch(Dispatchers.IO) {
            listOfPost = postDao.retrievePosts() as MutableLiveData<List<Post>>
        }
    }

    fun addPost(post: Post){
        viewModelScope.launch(Dispatchers.IO) {
            postDao.addPost(post)
        }
    }

    fun updatePost(post: Post){
        viewModelScope.launch(Dispatchers.IO) {
            postDao.updatePost(post)
        }
    }

    fun deletePost(post: Post){
        viewModelScope.launch(Dispatchers.IO) {
            postDao.deletePost(post)
        }
    }


}