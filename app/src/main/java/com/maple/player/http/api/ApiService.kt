package com.maple.player.http.api

import com.maple.player.http.BaseResult
import retrofit2.http.*

interface ApiService {

    @GET("/login/cellphone")
    suspend fun loginPhone(@Query("phone") phone:String,@Query("password") password:String):BaseResult<String>
}