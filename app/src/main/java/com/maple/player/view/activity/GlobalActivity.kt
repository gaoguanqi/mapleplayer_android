package com.maple.player.view.activity

import android.app.Activity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.LinearLayout
import com.maple.player.R

class GlobalActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_global)

    }

//    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            return true
//        }
//        return super.onKeyDown(keyCode, event)
//    }

}
