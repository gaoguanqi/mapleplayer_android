package com.maple.player.utils

import android.text.TextUtils
import android.view.Gravity
import com.blankj.utilcode.util.ColorUtils
import com.maple.player.R
import com.blankj.utilcode.util.ToastUtils as Toast

class ToastUtil {
    companion object {
        @JvmStatic
        fun showToast(s: String?) {
            if (!TextUtils.isEmpty(s)) {
                Toast.setBgColor(ColorUtils.getColor(R.color.color_toast))
                Toast.showShort(s)
            }
        }


        @JvmStatic
        fun showTipToast(s: String?) {
            if (!TextUtils.isEmpty(s)) {
                Toast.setBgColor(ColorUtils.getColor(R.color.color_toast))
                Toast.setGravity(Gravity.CENTER,0,0)
                Toast.showShort(s)
            }
        }
    }
}


//enum class Gravity{
//    BOTTOM,CENTER
//}

