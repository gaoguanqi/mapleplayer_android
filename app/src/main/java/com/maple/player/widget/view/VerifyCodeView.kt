package com.maple.player.widget.view

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import com.blankj.utilcode.util.KeyboardUtils
import com.maple.player.R


class VerifyCodeView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {


    private val editText: CursorEditText

    fun getEditText() = editText

    private val textViews: Array<TextView>
    private var inputContent: String = ""

    private val MAX: Int = 4

    private var listener: InputCompleteListener? = null

    fun setListener(listener: InputCompleteListener) {
        this.listener = listener
    }


    init {
        View.inflate(context, R.layout.layout_verify_code, this)
        textViews = arrayOf<TextView>(
            findViewById(R.id.tv_0),
            findViewById(R.id.tv_1),
            findViewById(R.id.tv_2),
            findViewById(R.id.tv_3)
        )
        editText = findViewById(R.id.et_input)
        editText.isCursorVisible = false //隐藏光标
        setEditTextListener()
    }

    private fun setEditTextListener() {
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                inputContent = editText.text.toString()
                inputContent.apply {
                    if (inputContent.length >= MAX) {
                        listener?.inputComplete(inputContent)
                        initContent()
                    } else {
                        listener?.invalidContent()
                    }
                }

               for(index in textViews.indices){
                   if (index < inputContent.length) {
                       textViews[index].text = inputContent[index].toString()
                   } else {
                       textViews[index].text = ""
                   }
               }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }


    fun initContent(){
        inputContent = ""
        editText.setText(inputContent)
    }
    interface InputCompleteListener {
        fun inputComplete(content:String)
        fun invalidContent()
    }
}


