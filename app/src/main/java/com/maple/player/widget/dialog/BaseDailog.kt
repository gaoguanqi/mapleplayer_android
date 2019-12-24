package com.maple.player.widget.dialog

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.WindowManager
import com.maple.player.R

open class BaseDailog(
    context: Context,
    val width: Int = WindowManager.LayoutParams.WRAP_CONTENT,
    val height: Int = WindowManager.LayoutParams.WRAP_CONTENT
) : Dialog(context, R.style.DialogCommon) {

    init {
        //        setCancelable(false)
        window?.setGravity(Gravity.CENTER)
        //默认的Dialog只有5/6左右的宽度
        window?.decorView?.setPadding(0, 0, 0, 0);
        val lp = window?.attributes
        lp?.width = width
//    lp?.width = (ScreenUtils.getScreenWidth() * 0.8).toInt()
        //lp?.height = (ScreenUtils.getScreenHeight() * 0.4).toInt()
        lp?.height = height
        window?.attributes = lp
    }
}