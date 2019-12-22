package com.maple.player.app.global

class Constants {
    object SaveInfoKey {
        const val HAS_WECLOME = "weclome"

        const val KEY_LOGIN_TAG:String = "key_login_tag"

        const val VALUE_LOGIN_TAG_LOGIN:Int = 1
        const val VALUE_LOGIN_TAG_WX:Int = 2
        const val VALUE_LOGIN_TAG_QQ:Int = 3
        const val VALUE_LOGIN_TAG_SINA:Int = 4
        const val VALUE_LOGIN_TAG_163:Int = 5
    }

    object GlobalValue {
        const val VALUE_TIMER_INTERVAL = 1000L
        //val VALUE_TIMER_TOTAL = 3000L
        const val VALUE_TIMER_TOTAL = 1000L
    }

    object BundleKey {
        const val EXTRA_PHONE = "phone"
        const val EXTRA_VERIFY_CODE = "verifyCode"
        const val EXTRA_PASSWORD = "password"

        const val EXTRA_TASTE = "taste"
    }
}