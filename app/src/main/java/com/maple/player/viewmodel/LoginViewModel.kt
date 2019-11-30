package com.maple.player.viewmodel

import android.view.animation.AnimationUtils
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.base.BaseViewModel
import com.maple.player.utils.ToastUtil

class LoginViewModel(var app:MyApplication) : BaseViewModel(app) {

    var loginEvent: MutableLiveData<Boolean> = MutableLiveData()
    var tasteEvent: MutableLiveData<Boolean> = MutableLiveData()
    var shakeEvent: MutableLiveData<Boolean> = MutableLiveData()
    val isAgree: ObservableField<Boolean> = ObservableField(false)

    fun onLogin() {
        if (isAgree.get()!!) {
            loginEvent.postValue(true)
        } else {
            ToastUtil.showToast("请先同意条款")
            shakeEvent.postValue(true)
        }
    }

    fun onTaste() {
        if (isAgree.get()!!) {
            tasteEvent.postValue(true)
        } else {
            ToastUtil.showToast("请先同意条款")
            shakeEvent.postValue(true)
        }
    }
}