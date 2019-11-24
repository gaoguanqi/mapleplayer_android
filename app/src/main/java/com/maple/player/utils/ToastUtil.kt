package com.maple.player.utils

import android.text.TextUtils
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
    }
}