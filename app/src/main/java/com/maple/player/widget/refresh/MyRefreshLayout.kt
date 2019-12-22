package com.maple.player.widget.refresh

import android.content.Context
import android.util.AttributeSet
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class MyRefreshLayout constructor(
    context: Context, attrs: AttributeSet? = null
) : SwipeRefreshLayout(context, attrs) {


    override fun setColorSchemeColors(vararg colors: Int) {
        super.setColorSchemeColors(*colors)
    }
}