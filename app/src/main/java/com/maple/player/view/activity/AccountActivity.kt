package com.maple.player.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.maple.player.R
import com.maple.player.base.BaseActivity

class AccountActivity : BaseActivity() {
    override fun getLayoutId(): Int = R.layout.activity_account


    override fun initData(savedInstanceState: Bundle?) {
        showTopMessage("initData")
//        val controller:NavController = Navigation.findNavController(this,R.id.fragment)
//        NavigationUI.setupActionBarWithNavController(this,controller)
    }

    override fun onSupportNavigateUp(): Boolean {
//        return super.onSupportNavigateUp()
        val controller:NavController = Navigation.findNavController(this,R.id.fragment)
        return controller.navigateUp()
    }

}
