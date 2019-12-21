package com.maple.player.model.repository

import com.maple.player.base.BaseRepository
import com.maple.player.http.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeRepository : BaseRepository() {


    private val retrofitClient = RetrofitClient.service


    suspend fun getBanner(type: String) = withContext(Dispatchers.IO) {
        retrofitClient.getBanner(type)
    }

    suspend fun getRecommend(limit: String) = withContext(Dispatchers.IO) {
        retrofitClient.getRecommend(limit)
    }

    suspend fun getNewest() = withContext(Dispatchers.IO) {
        retrofitClient.getNewest()
    }


    suspend fun getUserDetail(uid:String) = withContext(Dispatchers.IO) {
        retrofitClient.getUserDetail(uid)
    }
}