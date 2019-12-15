package com.maple.player.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.navigation.findNavController
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.base.BaseActivity
import com.maple.player.db.AppDatabase
import com.maple.player.db.user.Test

class AccountActivity : BaseActivity() {
    override fun getLayoutId(): Int = R.layout.activity_account


    override fun initData(savedInstanceState: Bundle?) {

    }


    override fun onSupportNavigateUp(): Boolean {
//        return super.onSupportNavigateUp()
        return findNavController(R.id.fragment_account).navigateUp()
    }


    fun startHomeActivity(){
        startActivity(Intent(this@AccountActivity,HomeActivity::class.java))
        this@AccountActivity.finish()
    }
}
