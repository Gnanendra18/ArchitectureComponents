package com.incrediblepath.architecturecomponents.repository

import androidx.lifecycle.LiveData
import com.incrediblepath.architecturecomponents.data.PostDao
import com.incrediblepath.architecturecomponents.model.Post

class PostRepostitory(private val postDao:PostDao) {

    val readAllData :LiveData<List<Post>> = postDao.retrievePosts()

    suspend fun addPost(post:Post){
        postDao.addPost(post)
    }


}