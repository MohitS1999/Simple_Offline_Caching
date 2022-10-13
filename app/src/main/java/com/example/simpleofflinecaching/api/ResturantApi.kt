package com.example.simpleofflinecaching.api

import com.example.simpleofflinecaching.data.Resturant
import retrofit2.http.GET

interface ResturantApi {

    companion object{
        const val BASE_URL = "https://random-data-api.com/api/v2/"
    }

    @GET("users?size=100")
    suspend fun getRestaurant() : List<Resturant>

}