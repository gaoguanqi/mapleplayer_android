package com.maple.player.view.activity

import android.content.Intent
import android.os.Bundle
import com.maple.player.R
import com.maple.player.base.BaseActivity

class SplashActivity : BaseActivity() {
    override fun getLayoutId(): Int = R.layout.activity_splash

    override fun initData(savedInstanceState: Bundle?) {
        startActivity(Intent(this@SplashActivity,AccountActivity::class.java))
        this@SplashActivity.finish()
    }
}
