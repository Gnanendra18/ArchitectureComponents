package com.incrediblepath.architecturecomponents.api

import com.incrediblepath.architecturecomponents.model.Post
import retrofit2.Response
import retrofit2.http.*

interface SampleApi {
    @GET("posts/1")
    suspend fun getOnePost():Post
    @GET("posts/{post_number}")
    suspend fun getAnyPost(
        @Path("post_number")postNumber:Int
    ):Post

    @GET("posts")
    suspend fun getPostsOfUser(
        @Query("userId")userId:Int
    ):Response<List<Post>>


}