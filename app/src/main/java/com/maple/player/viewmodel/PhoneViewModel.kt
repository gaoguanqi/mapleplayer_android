package com.maple.player.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.blankj.utilcode.util.ResourceUtils
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.app.manager.SingleLiveEvent
import com.maple.player.base.BaseViewModel
import com.maple.player.utils.UIUtils

class PhoneViewModel(var app:MyApplication):BaseViewModel(app) {

    val title :ObservableField<String> = ObservableField()
    val backEvent: SingleLiveEvent<Any> = SingleLiveEvent()

    init {
        title.set(UIUtils.getString(R.string.title_login_phone))
    }

    fun onBack(){
        backEvent.call()
    }
}