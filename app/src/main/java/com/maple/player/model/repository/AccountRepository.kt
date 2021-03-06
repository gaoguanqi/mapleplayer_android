package com.maple.player.model.repository

import com.maple.player.base.BaseRepository
import com.maple.player.http.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AccountRepository : BaseRepository() {

    private val retrofitClient = RetrofitClient.service

    suspend fun loginPhone(phone: String, password: String) = withContext(Dispatchers.IO) {
        retrofitClient.loginPhone(phone, password)
    }

    suspend fun checkPhone(phone: String) = withContext(Dispatchers.IO) {
        retrofitClient.checkPhone(phone)
    }


    suspend fun sendVerifyCode(phone: String) = withContext(Dispatchers.IO) {
        retrofitClient.sendVerifyCode(phone)
    }

    suspend fun checkVerifyCode(phone: String,captcha: String) = withContext(Dispatchers.IO) {
        retrofitClient.checkVerifyCode(phone,captcha)
    }

    suspend fun registerPhone(phone: String,password: String,captcha: String,nickname:String) = withContext(Dispatchers.IO) {
        retrofitClient.registerPhone(phone,password,captcha,nickname)
    }
}