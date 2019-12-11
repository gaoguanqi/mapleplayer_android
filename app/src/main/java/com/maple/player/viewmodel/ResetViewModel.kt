package com.maple.player.viewmodel

import androidx.databinding.ObservableField
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.app.manager.SingleLiveEvent
import com.maple.player.base.BaseViewModel
import com.maple.player.utils.UIUtils

class ResetViewModel(private val app:MyApplication):BaseViewModel(app) {
    val backEvent: SingleLiveEvent<Any> = SingleLiveEvent()

    val hasPhone: ObservableField<Boolean> = ObservableField(false)
    val hasPassword: ObservableField<Boolean> = ObservableField(false)

    val clearPhoneEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val clearPasswordEvent: SingleLiveEvent<Any> = SingleLiveEvent()

    init {
        defUI.title.set(UIUtils.getString(R.string.title_reset_password))
    }

    fun onBack() {
        backEvent.call()
    }

    fun onPhoneClear() {
        clearPhoneEvent.call()
    }

    fun onPasswordClear() {
        clearPasswordEvent.call()
    }
}