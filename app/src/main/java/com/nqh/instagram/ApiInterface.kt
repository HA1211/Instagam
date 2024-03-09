package com.nqh.instagram

import com.nqh.instagram.model.PostModel
import com.nqh.instagram.model.StoryModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("test")
    fun getData() : Call<List<PostModel>>

    @GET
    fun getData2() : Call<List<StoryModel>>
/*
    @POST("test")
    fun addNewUser(
        @Body requestBody: RequestBody
    ) : Call<PostModel>*/
}