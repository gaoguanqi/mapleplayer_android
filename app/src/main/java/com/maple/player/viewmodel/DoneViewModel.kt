package com.maple.player.viewmodel

import androidx.databinding.ObservableField
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.app.manager.SingleLiveEvent
import com.maple.player.base.BaseViewModel
import com.maple.player.utils.UIUtils

class DoneViewModel(var app:MyApplication):BaseViewModel(app) {


    val title: ObservableField<String> = ObservableField()
    val backEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val doneEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val clearEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val resetEvent: SingleLiveEvent<Any> = SingleLiveEvent()

    val hasDone: ObservableField<Boolean> = ObservableField(false)


    init {
        title.set(UIUtils.getString(R.string.title_login_phone))
    }

    fun onBack() {
        backEvent.call()
    }



    fun onClear() {
        clearEvent.call()
    }

    fun onDone() {
        doneEvent.call()
    }

    fun onReset(){
        resetEvent.call()
    }
}