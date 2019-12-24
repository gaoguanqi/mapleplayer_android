package com.maple.player.http

import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.AppUtils
import com.maple.player.utils.LogUtils
import com.maple.player.view.activity.GlobalActivity
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.nio.charset.Charset

class TokenInterceptor : Interceptor {
    val UTF8: Charset = Charset.forName("UTF-8")

    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val response: Response = chain.proceed(request)
        try {
            val charset: Charset = UTF8
            response.body?.also {
                val sBody = it.source().buffer.clone().readString(charset)
                val jsonObject: JSONObject = JSONObject(sBody)
                val code: Int = jsonObject.getInt("code")
                LogUtils.logGGQ("TokenInterceptor : ${code}")
                if (code == 200) {
                    ActivityUtils.startActivity(GlobalActivity::class.java)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return response
    }
}