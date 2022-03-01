package com.incrediblepath.architecturecomponents.api

import com.incrediblepath.architecturecomponents.model.Post
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface SampleData {
    @GET("posts/1")
    suspend fun getOnePost():Post

    @GET("posts/{post_number}")
    suspend fun getAnyPost(@Path("post_number")postNo:Int):Post


    @Headers(
        "data:data1",
        "other:Otherdata")
    @GET("posts")
    suspend fun getPosts(@Query("userId")userId:Int):List<Post>
}