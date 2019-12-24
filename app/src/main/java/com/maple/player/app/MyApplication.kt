package com.maple.player.app

import android.app.Activity
import android.app.Application
import android.os.Bundle

class MyApplication : Application() {
    companion object {
        @JvmStatic
        lateinit var instance: MyApplication
            private set

        @JvmStatic
         var currentActivity: Activity? = null
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initConfig(this)
        //@SuppressLint("StaticFieldLeak")//防止内存泄漏，也可以使用软引用
        registerActivityLifecycleCallbacks(object :ActivityLifecycleCallbacks{
            override fun onActivityPaused(activity: Activity) {
            }

            override fun onActivityStarted(activity: Activity) {
                currentActivity = activity
            }

            override fun onActivityDestroyed(activity: Activity) {
                currentActivity = null
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
            }

            override fun onActivityStopped(activity: Activity) {
            }

            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                currentActivity = activity
            }

            override fun onActivityResumed(activity: Activity) {
            }
        })
    }

    private fun initConfig(app: MyApplication) {

    }
}