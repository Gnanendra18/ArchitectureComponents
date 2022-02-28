package com.incrediblepath.architecturecomponents.api

import com.incrediblepath.architecturecomponents.model.Post
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface SampleApi {
    @GET("posts/1")
    suspend fun getOnePost(): Response<Post>

    @GET("posts/{post_number}")
    suspend fun getPost(@Path("post_number")postNo:Int):Response<Post>

    //@QueryMap
    @GET("/posts")
    suspend fun getUserPost(
        @Query("userId")userId:Int


    ):Response<List<Post>>
}