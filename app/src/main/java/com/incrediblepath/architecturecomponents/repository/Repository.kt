package com.incrediblepath.architecturecomponents.repository

import com.incrediblepath.architecturecomponents.api.RetrofitInstance
import com.incrediblepath.architecturecomponents.model.Post
import retrofit2.Response


class Repository {
    suspend fun getOnePost(): Response<Post> {
        return RetrofitInstance.api.getOnePost()
    }

    suspend fun getPost(postNo:Int): Response<Post> {
        return RetrofitInstance.api.getPost(postNo)
    }

    suspend fun getUserPosts(userId:Int):Response<List<Post>>{
        return RetrofitInstance.api.getUserPost(userId)
    }
}