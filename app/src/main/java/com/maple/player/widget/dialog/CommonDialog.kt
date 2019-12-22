package com.maple.player.widget.dialog

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.maple.player.R
import com.maple.player.utils.UIUtils

class CommonDialog : BaseDailog {
    private val title: String
    private val content: String
    private val cancle: String
    private val confirm: String
    private val listener:OnClickListener

    constructor(
        context: Context,
        title: String,
        content: String,
        cancle: String = UIUtils.getString(R.string.text_cancle),
        confirm: String = UIUtils.getString(R.string.text_confirm),
        listener:OnClickListener
    ) : super(context) {
        this.title = title
        this.content = content
        this.cancle = cancle
        this.confirm = confirm
        this.listener = listener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_common)
        findViewById<TextView>(R.id.tv_title).let {
            it.text = title
        }

        findViewById<TextView>(R.id.tv_content).let {
            it.text = content
        }
        findViewById<Button>(R.id.btn_cancle).let {
            it.text = cancle
            it.setOnClickListener { listener.onCancleClick()}
        }
        findViewById<Button>(R.id.btn_confirm).let {
            it.text = confirm
            it.setOnClickListener { listener.onConfirmClick()}
        }
    }

    interface OnClickListener{
        fun onCancleClick()
        fun onConfirmClick()
    }
}