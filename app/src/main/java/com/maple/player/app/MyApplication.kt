package com.maple.player.app

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import com.maple.player.app.manager.AppLifeCycleCallBack
import com.maple.player.app.manager.ForebackLifeObserver

class MyApplication : Application() {
    companion object {
        @JvmStatic
        lateinit var instance: MyApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initConfig(this)
        //@SuppressLint("StaticFieldLeak")//防止内存泄漏，也可以使用软引用
    }

    private fun initConfig(app: MyApplication) {
        app.registerActivityLifecycleCallbacks(AppLifeCycleCallBack())
        ProcessLifecycleOwner.get().lifecycle.addObserver(ForebackLifeObserver())
    }
}