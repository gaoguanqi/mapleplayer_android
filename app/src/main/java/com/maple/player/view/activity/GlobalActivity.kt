package com.maple.player.view.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.maple.player.R
import com.maple.player.app.global.Constants
import kotlinx.android.synthetic.main.activity_global.*

class GlobalActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_global)

        btn_confirm.setOnClickListener {
            startActivity(Intent(this@GlobalActivity,AccountActivity::class.java).putExtra(Constants.BundleKey.EXTRA_TASTE,true))
            this@GlobalActivity.finish()
        }
    }


//    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            return true
//        }
//        return super.onKeyDown(keyCode, event)
//    }

}
