package com.nqh.instagram

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @GET("test")
    fun getData() : Call<List<UserService>>

    @POST("test")
    fun addNewUser(
        @Body requestBody: RequestBody
    ) : Call<UserService>
}