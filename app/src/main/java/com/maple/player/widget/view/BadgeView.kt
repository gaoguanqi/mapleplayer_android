package com.maple.player.widget.view

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import com.blankj.utilcode.util.SizeUtils
import com.maple.player.R
import com.maple.player.utils.UIUtils

class BadgeView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {


    init {
        width = SizeUtils.dp2px(12f)
        height = SizeUtils.dp2px(12f)
        gravity = Gravity.CENTER
        background = UIUtils.getDrawable(R.drawable.shape_badge_bg)
    }


    override fun setText(text: CharSequence?, type: BufferType?) {
        var txt: String? = text?.toString()
        if (TextUtils.isEmpty(text)) {
            visibility = View.GONE
        }else{
            if (text.toString().toInt() > 99) {
                txt = "99"
            }
        }
        super.setText(txt, type)
    }
}