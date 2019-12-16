package com.maple.player.view.activity

import android.content.Intent
import android.os.Bundle
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.base.BaseActivity
import com.maple.player.db.AppDatabase

class SplashActivity : BaseActivity() {
    override fun getLayoutId(): Int = R.layout.activity_splash

    override fun initData(savedInstanceState: Bundle?) {

        val userList = AppDatabase.getInstance(MyApplication.instance).userDao().getAllUser()
        if(userList.isNullOrEmpty()){
            startActivity(Intent(this@SplashActivity,AccountActivity::class.java))
            this@SplashActivity.finish()
        }else{
            startActivity(Intent(this@SplashActivity,HomeActivity::class.java))
            this@SplashActivity.finish()
        }

    }
}
