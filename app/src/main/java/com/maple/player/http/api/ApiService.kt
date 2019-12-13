package com.maple.player.http.api

import com.maple.player.http.BaseResult
import com.maple.player.model.entity.CheckPhoneEntity
import com.maple.player.model.entity.UserInfoEntity
import retrofit2.http.*

interface ApiService {

    @GET("/login/cellphone")
    suspend fun loginPhone(@Query("phone") phone:String,@Query("password") password:String):UserInfoEntity

    @GET("/cellphone/existence/check")
    suspend fun checkPhone(@Query("phone") phone:String): CheckPhoneEntity
}