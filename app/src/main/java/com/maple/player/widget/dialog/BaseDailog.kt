package com.maple.player.widget.dialog

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.WindowManager
import com.maple.player.R

open class BaseDailog : Dialog {

    constructor(context: Context) : super(context, R.style.DialogCommon) {
//        setCancelable(false)
        window?.setGravity(Gravity.CENTER)
        //默认的Dialog只有5/6左右的宽度
        window?.decorView?.setPadding(0, 0, 0, 0);
        val lp = window?.attributes
        lp?.width = WindowManager.LayoutParams.WRAP_CONTENT
//    lp?.width = (ScreenUtils.getScreenWidth() * 0.8).toInt()
        //lp?.height = (ScreenUtils.getScreenHeight() * 0.4).toInt()
        lp?.height = WindowManager.LayoutParams.WRAP_CONTENT
        window?.attributes = lp
    }

}