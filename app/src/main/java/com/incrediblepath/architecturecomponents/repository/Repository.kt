package com.incrediblepath.architecturecomponents.repository

import com.incrediblepath.architecturecomponents.api.RetrofitInstance
import com.incrediblepath.architecturecomponents.model.Post

class Repository {

    suspend fun getOnePost():Post{
        return RetrofitInstance.myApi.getOnePost()
    }

    suspend fun getAnyPost(postNo:Int):Post{
        return RetrofitInstance.myApi.getAnyPost(postNo)
    }
    suspend fun getAllPostsOfUser(userId:Int):List<Post>{
        return RetrofitInstance.myApi.getPosts(userId)
    }


}