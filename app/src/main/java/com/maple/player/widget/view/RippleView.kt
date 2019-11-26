package com.maple.player.widget.view

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.blankj.utilcode.util.SizeUtils
import com.maple.player.R


class RippleView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    // 画笔对象
    private var paint: Paint
    // View宽
    private var width: Float = 10f
    // View高
    private var height: Float = 10f
    // 声波的圆圈集合
    private val rippleList: MutableList<Circle> = ArrayList()
    private var sqrtNumber: Int = 1
    // 圆圈扩散的速度
    private var speed: Int = 1
    // 圆圈之间的密度
    private var density: Int = 10
    // 圆圈的颜色
    private var color: Int = Color.RED
    // 圆圈是否为填充模式
    private var hasFill: Boolean = false
    // 圆圈是否为渐变模式
    private var hasAlpha: Boolean = false


    private val strokeWidth: Float = SizeUtils.dp2px(1.0f).toFloat()

    init {
        paint = Paint()
        paint.isAntiAlias = true //是否抗锯齿

        val array: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.RippleView)
        color = array.getColor(R.styleable.RippleView_rippleColor, color)
        speed = array.getInteger(R.styleable.RippleView_rippleSpeed, speed)
        density = array.getInteger(R.styleable.RippleView_rippleDensity, density)
        density = SizeUtils.dp2px(density.toFloat())
        hasFill = array.getBoolean(R.styleable.RippleView_rippleHasFill, hasFill)
        hasAlpha = array.getBoolean(R.styleable.RippleView_rippleHasAlpha, hasAlpha)
        array.recycle()


        paint.color = color
        paint.strokeWidth = strokeWidth
        paint.style = if (hasFill) Paint.Style.FILL else Paint.Style.STROKE
        paint.strokeCap = Paint.Cap.ROUND

        // 添加第一个圆圈
        rippleList.add(Circle(0, 255))
        // 设置View的圆为半透明
        setBackgroundColor(Color.TRANSPARENT)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // 内切正方形
        drawInCircle(canvas);
        // 外切正方形
//         drawOutCircle(canvas);
    }



    private fun drawInCircle(canvas: Canvas?) {
        canvas?.save()

        // 处理每个圆的宽度和透明度
        var x:Int = 0
        for(i in rippleList.indices){
            val e:Circle =  rippleList.get(i - x);
            paint.alpha = e.alpha //（透明）0~255（不透明）
            canvas?.drawCircle(width / 2, height / 2, e.width - paint.strokeWidth, paint)
            // 当圆超出View的宽度后删除
            if (e.width > width / 2) {
                rippleList.removeAt(i - x)
            } else {
                // 计算不透明的数值，这里有个小知识，就是如果不加上double的话，255除以一个任意比它大的数都将是0
                if (hasAlpha) {
                    e.alpha = (255 - e.width * (255 / (width / 2))).toInt()
                }

                // 修改这个值控制速度
                e.width += speed
            }
            x++
        }

        // 里面添加圆
        if (rippleList.size > 0) {
            // 控制第二个圆出来的间距
            if (rippleList[rippleList.size - 1].width > SizeUtils.dp2px(density.toFloat())) {
                rippleList.add(Circle(0, 255))
            }
        }

        invalidate()
        canvas?.restore()
    }


    private fun drawOutCircle(canvas: Canvas?) {
        canvas?.save()
        // 使用勾股定律求得一个外切正方形中心点离角的距离
        sqrtNumber = (Math.sqrt((width * width).toDouble() + (height * height).toDouble())/2).toInt()

        var x:Int = 0
        for(i in rippleList.indices){
            val e:Circle =  rippleList.get(i - x);
            paint.alpha = e.alpha //（透明）0~255（不透明）
            canvas?.drawCircle(width / 2, height / 2, e.width - paint.strokeWidth, paint)
            // 当圆超出对角线后删掉
            if (e.width > sqrtNumber) {
                rippleList.removeAt(i)
            } else {
                // 计算不透明的度数
                if (hasAlpha) {
                    e.alpha = 255 - e.width * (255 / sqrtNumber)
                    e.width += 1
                }
            }

            // 里面添加圆
            if (rippleList.size > 0) {
                // 控制第二个圆出来的间距
                if (rippleList[rippleList.size - 1].width  == 50) {
                    rippleList.add(Circle(0, 255))
                }
            }
            x++
        }

        invalidate()
        canvas?.restore()
    }
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthSpecMode: Int = MeasureSpec.getMode(widthMeasureSpec)
        val widthSpecSize: Int = MeasureSpec.getSize(widthMeasureSpec)
        val heightSpecMode: Int = MeasureSpec.getMode(heightMeasureSpec)
        val heightSpecSize: Int = MeasureSpec.getSize(heightMeasureSpec)
        // 获取宽度
        if(widthSpecMode == MeasureSpec.EXACTLY){
            width = widthSpecSize.toFloat()
        }else{
            width = SizeUtils.dp2px(120f).toFloat()
        }

        // 获取高度
        if(heightSpecMode == MeasureSpec.EXACTLY){
            height = heightSpecSize.toFloat()
        }else{
            height = SizeUtils.dp2px(120f).toFloat()
        }
        // 设置该view的宽高
        setMeasuredDimension(width.toInt(),height.toInt())
    }

    inner class Circle(var width: Int, var alpha: Int)
}