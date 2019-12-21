package com.maple.player.view.activity

import android.content.Intent
import android.os.Bundle
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.base.BaseActivity
import com.maple.player.db.AppDatabase
import com.maple.player.utils.LogUtils

class SplashActivity : BaseActivity() {
    override fun getLayoutId(): Int = R.layout.activity_splash

    override fun initData(savedInstanceState: Bundle?) {

        val userList = AppDatabase.getInstance(MyApplication.instance).userDao().getAllUser()
        for (user in userList) {
            LogUtils.logGGQ("user:${user.nickname} --- ${userList.size}")
        }
        if(userList.isNullOrEmpty()){
            startActivity(Intent(this@SplashActivity,AccountActivity::class.java))
            this@SplashActivity.finish()
        }else{
            startActivity(Intent(this@SplashActivity,HomeActivity::class.java))
            this@SplashActivity.finish()
        }

    }
}
