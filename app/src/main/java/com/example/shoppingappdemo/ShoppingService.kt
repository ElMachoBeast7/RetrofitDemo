package com.example.shoppingappdemo

import com.example.shoppingappdemo.data.Shopper
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface ShoppingService {

    @GET("shopping/all")
    fun getAll(): Call<List<Shopper>>

    @POST("shopping")
    fun create(@Body post: Shopper): Call<Message>

    @Multipart
    @POST("images/upload")
    fun uploadImage(@Part image: MultipartBody.Part): Call<ImageUploadResponse>

}