package com.maple.player.http.api

import com.maple.player.model.entity.CheckPhoneEntity
import com.maple.player.model.entity.UserInfoEntity
import com.maple.player.model.entity.ResultEntity
import retrofit2.http.*

interface ApiService {

    @GET("/login/cellphone")
    suspend fun loginPhone(@Query("phone") phone:String,@Query("password") password:String):UserInfoEntity

    @GET("/cellphone/existence/check")
    suspend fun checkPhone(@Query("phone") phone:String): CheckPhoneEntity

    @GET("/captcha/sent")
    suspend fun sendVerifyCode(@Query("phone") phone:String): ResultEntity

    @GET("/captcha/verify")
    suspend fun checkVerifyCode(@Query("phone") phone:String,@Query("captcha") captcha:String): ResultEntity

    @GET("/register/cellphone")
    suspend fun registerPhone(@Query("phone")phone: String, @Query("password")password: String, @Query("captcha")captcha: String, @Query("nickname")nickname: String): UserInfoEntity

}