package com.maple.player.model.repository

import com.maple.player.app.config.Config
import com.maple.player.base.BaseRepository
import com.maple.player.http.RetrofitClient
import com.maple.player.http.api.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AccountRepository:BaseRepository() {

    private val retrofitClient =  RetrofitClient.getService(ApiService::class.java,Config.BASE_URL)

    suspend fun loginPhone(phone:String,password:String) = withContext(Dispatchers.IO){
        retrofitClient.loginPhone(phone,password)
    }
}