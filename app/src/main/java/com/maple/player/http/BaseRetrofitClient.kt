package com.maple.player.http

import com.maple.player.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseRetrofitClient {
    companion object CLIENT {
        private const val TIME_OUT:Long = 60000L
    }

    protected val client: OkHttpClient
        get() {
            val builder = OkHttpClient.Builder()
            val logging = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG) {
                logging.level = HttpLoggingInterceptor.Level.BODY
            } else {
                logging.level = HttpLoggingInterceptor.Level.BASIC
            }

//            val map:Map<String,String> = HashMap<String,String>()
//            val header = HeaderInterceptor(map)
            builder.addInterceptor(logging)
//            builder.addInterceptor(header)

//                    ssl
//            builder.sslSocketFactory(SSLHelper.sslSocketFactory, SSLHelper.trustManager).hostnameVerifier(SSLHelper.hostnameVerifier)

//            val sslContext = SSLHelper.getSSLContext(caIn, ksIn, ksPwd)
//            builder.sslSocketFactory(sslContext.socketFactory).hostnameVerifier(SSLHelper.hostnameVerifier)
                .connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .readTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
            handleBuilder(builder)
            return builder.build()
        }

    /**
     * 以便对builder可以再扩展
     */
    protected abstract fun handleBuilder(builder: OkHttpClient.Builder)

     fun <S> getService(serviceClass: Class<S>, baseUrl: String): S {
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
            .create(serviceClass)
    }
}