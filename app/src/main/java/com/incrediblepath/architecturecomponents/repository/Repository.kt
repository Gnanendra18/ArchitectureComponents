package com.incrediblepath.architecturecomponents.repository

import com.incrediblepath.architecturecomponents.api.RetrofitInstance
import com.incrediblepath.architecturecomponents.model.Post

class Repository {
    suspend fun getOnePost(): Post {
        return RetrofitInstance.myApi.getOnePost()
    }
}