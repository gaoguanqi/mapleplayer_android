package com.maple.player.view.activity

import android.os.Bundle
import androidx.navigation.findNavController
import com.maple.player.R
import com.maple.player.base.BaseActivity

class AccountActivity : BaseActivity() {
    override fun getLayoutId(): Int = R.layout.activity_account


    override fun initData(savedInstanceState: Bundle?) {
        showTopMessage("initData")

    }


    override fun onSupportNavigateUp(): Boolean {
//        return super.onSupportNavigateUp()
        return findNavController(R.id.fragment_account).navigateUp()
    }
}
