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

    suspend fun getArtists(offset: Int,limit: String) = withContext(Dispatchers.IO) {
        retrofitClient.getArtists(offset.toString(),limit)
    }

    suspend fun getUserDetail(uid:String) = withContext(Dispatchers.IO) {
        retrofitClient.getUserDetail(uid)
    }


    suspend fun getVideoGroup() = withContext(Dispatchers.IO) {
        retrofitClient.getVideoGroup()
    }


    suspend fun logout() = withContext(Dispatchers.IO) {
        retrofitClient.logout()
    }

    suspend fun getVideoList(id:String) = withContext(Dispatchers.IO) {
        retrofitClient.getVideoList(id)
    }

    suspend fun getListener(limit: String) = withContext(Dispatchers.IO) {
        retrofitClient.getListener(limit)
    }

}