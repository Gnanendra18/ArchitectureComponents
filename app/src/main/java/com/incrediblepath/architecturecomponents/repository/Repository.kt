package com.incrediblepath.architecturecomponents.repository

import com.incrediblepath.architecturecomponents.api.RetrofitInstance
import com.incrediblepath.architecturecomponents.model.Post
import retrofit2.Response

class Repository {
    suspend fun getOnePost(): Post {
        //get from localdatabase else
        return RetrofitInstance.myApi.getOnePost()
    }

    suspend fun getAnyPost(postNo:Int): Post {
        return RetrofitInstance.myApi.getAnyPost(postNo)
    }

    suspend fun getAllPostsOfUser(userId:Int): Response<List<Post>> {
        return RetrofitInstance.myApi.getPostsOfUser(userId)
    }

    suspend fun addPost(data:Post): Post {
        return RetrofitInstance.myApi.addPost(data)
    }
}
