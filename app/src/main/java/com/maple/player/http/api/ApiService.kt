package com.maple.player.http.api

import com.maple.player.model.entity.*
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

    @GET("/banner")
    suspend fun getBanner(@Query("type") type:String): BannerEntity

    @GET("/personalized")
    suspend fun getRecommend(@Query("limit") limit:String): RecommendEntity

    @GET("/album/newest")
    suspend fun getNewest(): NewestEntity




    @GET("/user/detail")
    suspend fun getUserDetail(@Query("uid") uid: String): UserDetailEntity


}