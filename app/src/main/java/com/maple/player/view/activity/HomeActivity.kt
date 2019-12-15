package com.maple.player.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.base.BaseActivity
import com.maple.player.db.AppDatabase
import com.maple.player.db.user.Test
import com.maple.player.db.user.User
import okhttp3.internal.userAgent

class HomeActivity : BaseActivity() {
    override fun getLayoutId(): Int = R.layout.activity_home

    override fun initData(savedInstanceState: Bundle?) {



        val user = AppDatabase.getInstance(MyApplication.instance).userDao().getAllUser()

        showTopMessage(user.last().nickname)



    }

}
