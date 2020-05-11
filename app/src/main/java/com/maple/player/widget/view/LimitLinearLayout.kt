package com.maple.player.widget.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.LinearLayoutCompat
import com.blankj.utilcode.util.ScreenUtils
import com.maple.player.utils.UIUtils

class LimitLinearLayout:LinearLayoutCompat {
    constructor(context:Context):this(context,null,0)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs,0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
         val mWitch: Int = (ScreenUtils.getScreenWidth() * 0.80).toInt()
         val mHight: Int = (ScreenUtils.getScreenHeight() * 0.22).toInt()
        setMeasuredDimension(mWitch,mHight)
    }

}