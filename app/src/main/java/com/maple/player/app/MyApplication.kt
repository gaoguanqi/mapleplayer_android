package com.maple.player.app

import android.app.Application

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
    }

    private fun initConfig(app: MyApplication) {

    }
}