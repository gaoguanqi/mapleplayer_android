package com.maple.player.widget.dialog

import android.content.Context
import android.os.Bundle
import android.widget.Button
import com.blankj.utilcode.util.ScreenUtils
import com.maple.player.R

class PermissionDialog(context: Context,val listener:OnClickListener):BaseDailog(context,width = (ScreenUtils.getScreenWidth() * 0.82).toInt(),height = (ScreenUtils.getScreenHeight() * 0.42).toInt()) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCancelable(false)
        setContentView(R.layout.dialog_permission)
        findViewById<Button>(R.id.btn_cancle).let {
            it.setOnClickListener { listener.onCancleClick()}
        }
        findViewById<Button>(R.id.btn_confirm).let {
            it.setOnClickListener { listener.onConfirmClick()}
        }
    }

    interface OnClickListener{
        fun onCancleClick()
        fun onConfirmClick()
    }
}