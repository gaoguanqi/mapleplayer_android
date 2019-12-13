package com.maple.player.http

import com.maple.player.app.config.Config
import com.maple.player.http.api.ApiService
import okhttp3.OkHttpClient

object RetrofitClient : BaseRetrofitClient() {

     val service by lazy { getService(ApiService::class.java, Config.BASE_URL) }
    override fun handleBuilder(builder: OkHttpClient.Builder) {

    }
}