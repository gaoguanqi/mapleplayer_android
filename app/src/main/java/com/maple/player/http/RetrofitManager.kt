package com.maple.player.http

import com.maple.player.app.config.Config
import com.maple.player.http.api.ApiService
import com.maple.player.utils.LogUtils
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitManager private constructor() {

    private val okhttpClient: OkHttpClient

    companion object {
        private lateinit var retrofit: Retrofit
        @JvmStatic
        fun get(): RetrofitManager {
            return Holder.MANAGER
        }
    }

    init {
        val builder = OkHttpClient.Builder()
        //设置超时
        builder.writeTimeout((5 * 1000).toLong(), TimeUnit.MILLISECONDS)
        builder.readTimeout((5 * 1000).toLong(), TimeUnit.MILLISECONDS)
        builder.connectTimeout((5 * 1000).toLong(), TimeUnit.MILLISECONDS)

        val httpLoggingInterceptor = HttpLoggingInterceptor(
            object : HttpLoggingInterceptor.Logger {
                override fun log(message: String) {

                    // 如果是 json 格式内容则打印 json
//                    if ((message.startsWith("{") && message.endsWith("}")) ||
//                        (message.startsWith("[") && message.endsWith("]"))
//                    )
//                        LogUtils.json(message)
//                    else
//                        LogUtils.verbose(message)

                    LogUtils.logGGQ(message)
                }
            })

        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(httpLoggingInterceptor)
        okhttpClient = builder.build()

        retrofit = Retrofit.Builder()
            .baseUrl(Config.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) //设置 gson 转换器
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 设置 RxJava2 适配器
            .client(okhttpClient)
            .build()
    }

    private object Holder {
        val MANAGER = RetrofitManager()
    }

    val apiService: ApiService by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        retrofit.create(ApiService::class.java)
    }
}