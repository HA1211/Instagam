package com.nqh.instagram

import com.nqh.instagram.Model.PostModel
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @GET("tuvi")
    fun getData() : Call<List<PostModel>>

    @POST("tuvi")
    fun addNewUser(
        @Body requestBody: RequestBody
    ) : Call<PostModel>
}