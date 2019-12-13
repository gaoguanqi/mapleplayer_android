package com.maple.player.utils

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import com.blankj.utilcode.util.ColorUtils
import com.blankj.utilcode.util.StringUtils

class UIUtils {
    companion object {
        fun getString(@StringRes resId:Int): String {
            return StringUtils.getString(resId)
        }

        fun getColor(@ColorRes resId: Int) : Int{
            return ColorUtils.getColor(resId)
        }
    }
}