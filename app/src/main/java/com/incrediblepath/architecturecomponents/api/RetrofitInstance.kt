package com.incrediblepath.architecturecomponents.api

import com.incrediblepath.architecturecomponents.utils.NetworkConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit:Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(NetworkConstants.ROOT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val myApi:SampleApi by lazy {
        retrofit.create(SampleApi::class.java)
    }
}