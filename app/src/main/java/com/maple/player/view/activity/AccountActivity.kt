package com.maple.player.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maple.player.R
import com.maple.player.base.BaseActivity

class AccountActivity : BaseActivity() {
    override fun getLayoutId(): Int = R.layout.activity_account


    override fun initData(savedInstanceState: Bundle?) {
        showTopMessage("initData")
    }

}
