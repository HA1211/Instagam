package com.nqh.instagram

import com.nqh.instagram.model.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("test")
    fun getData() : Call<List<PostModel>>
/*
    @POST("test")
    fun addNewUser(
        @Body requestBody: RequestBody
    ) : Call<PostModel>*/
}