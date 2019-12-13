package com.maple.player.viewmodel

import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.app.manager.SingleLiveEvent
import com.maple.player.base.BaseViewModel
import com.maple.player.utils.UIUtils

class VerifyViewModel(private val app:MyApplication):BaseViewModel(app) {

    val backEvent: SingleLiveEvent<Any> = SingleLiveEvent()

    init {
        defUI.title.set(UIUtils.getString(R.string.title_verify_phone))
    }


    fun onBack() {
        backEvent.call()
    }
}