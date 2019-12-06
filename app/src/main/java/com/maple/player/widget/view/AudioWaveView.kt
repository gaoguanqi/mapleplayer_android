package com.maple.player.widget.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.os.Handler
import android.os.Message
import android.util.AttributeSet
import android.view.View
import java.util.*


class AudioWaveView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    // 画笔对象
    private var paint: Paint
    //线个数
    private var count: Int = 4
    private var rectFList: MutableList<RectF> = mutableListOf()
    //线间距
    private val space: Int = 14
    //每个线条的宽度
    private var rectWidth: Int = 0
    //线条随机高度
    private var randomHeight = 0
    private var random: Random

    private var viewWidth: Int = 0
    private var viewHeigh: Int = 0

    private var isPlay: Boolean = false

    private var isOne: Boolean = true

    private val handle: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            invalidate();
        }
    }

    init {
        paint = Paint()
        paint.isAntiAlias = true //是否抗锯齿
        paint.style = Paint.Style.FILL
        paint.color = Color.BLACK

        random = Random()

        for (index: Int in 1..count) {
            rectFList.add(RectF())
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        viewWidth = MeasureSpec.getSize(widthMeasureSpec)
        viewHeigh = MeasureSpec.getSize(heightMeasureSpec)
        rectWidth = (viewWidth - space * (count - 1)) / count
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (isPlay) {
            val left: Int = rectWidth + space
            //画每个条之前高度都重新随机生成
            for ((index, element) in rectFList.withIndex()) {
                randomHeight = random.nextInt(viewHeigh)
                element.set(
                    left * index.toFloat(),
                    randomHeight.toFloat(),
                    left * index + rectWidth.toFloat(),
                    viewHeigh.toFloat()
                )
                canvas?.drawRoundRect(element,4f,4f, paint)
            }
            handle.sendEmptyMessageDelayed(0, 200) //每间隔200毫秒发送消息刷新
        } else if(isOne){
                val left: Int = rectWidth + space
                //画一次
                var oneHeight: Float = viewHeigh.toFloat()
                for ((index, element) in rectFList.withIndex()) {
                    when(index){
                        0 ->  element.set(
                            left * index.toFloat(),
                            oneHeight / 2,
                            left * index + rectWidth.toFloat(),
                            viewHeigh.toFloat()
                        )
                        1->  element.set(
                            left * index.toFloat(),
                            oneHeight / 5,
                            left * index + rectWidth.toFloat(),
                            viewHeigh.toFloat()
                        )
                        2->  element.set(
                            left * index.toFloat(),
                            oneHeight / 2,
                            left * index + rectWidth.toFloat(),
                            viewHeigh.toFloat()
                        )
                        3->  element.set(
                            left * index.toFloat(),
                            oneHeight / 3,
                            left * index + rectWidth.toFloat(),
                            viewHeigh.toFloat()
                        )
                    }
                    canvas?.drawRoundRect(element,4f,4f, paint)
                    isOne = false
            }
        }
    }


    fun setPlay(isPlay: Boolean) {
        this.isPlay = isPlay
        invalidate();
    }


    fun getPlyState():Boolean = this.isPlay

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        handle.removeMessages(0)
        handle.removeCallbacksAndMessages(null)
    }

}