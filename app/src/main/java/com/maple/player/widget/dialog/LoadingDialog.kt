package com.maple.player.widget.dialog

import android.content.Context
import android.os.Bundle
import com.maple.player.R

class LoadingDialog(context: Context) : BaseDailog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_loading)
    }

}