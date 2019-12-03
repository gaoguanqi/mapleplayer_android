package com.maple.player.widget.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class ArrowTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private var paint: Paint



    init {
        paint = Paint()
        paint.isAntiAlias = true //是否抗锯齿
        paint.strokeWidth = 1f //设置线宽
        paint.color = Color.WHITE //设置线的颜色
    }

    override fun onDraw(canvas: Canvas?) {
        setOnDraw(canvas)
        super.onDraw(canvas)
    }

    private fun setOnDraw(canvas: Canvas?) {
        //框定文本显示的区域
        canvas?.drawRoundRect(RectF(paddingLeft - 20f,paddingTop - 20f,paddingRight - 20f ,paddingBottom + 20f),30f,30f,paint)
        //以下是绘制文本的那个箭头
        val path:Path = Path()
        path.moveTo(width/2f,height.toFloat()) //三角形顶点
        path.lineTo(width/2f - 20,height - paddingBottom.toFloat()) //三角形左边的点
        path.lineTo(width/2f + 20,height - paddingBottom.toFloat()) //三角形右边的点
        path.close()
        canvas?.drawPath(path,paint)
    }
}