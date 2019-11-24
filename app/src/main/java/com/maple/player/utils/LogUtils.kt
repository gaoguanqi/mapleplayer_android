package com.maple.player.utils

import android.util.Log
import com.maple.player.BuildConfig

class LogUtils {
    companion object {
        @JvmStatic
        fun logGGQ(s: String?) {
            if (BuildConfig.DEBUG) {
                Log.i("GGQ", "->>>$s")
            }
        }
    }
}