package com.incrediblepath.architecturecomponents.api

import com.incrediblepath.architecturecomponents.model.Post
import retrofit2.http.GET

interface SampleApi {
    @GET("posts/1")
    suspend fun getOnePost():Post
    @GET("posts")
    suspend fun getAnyPost():Post
}