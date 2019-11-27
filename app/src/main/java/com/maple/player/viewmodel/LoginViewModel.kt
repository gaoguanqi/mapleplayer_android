package com.maple.player.viewmodel

import com.maple.player.app.MyApplication
import com.maple.player.base.BaseViewModel
import com.maple.player.utils.ToastUtil

class LoginViewModel():BaseViewModel() {


     fun onLogin(){
        ToastUtil.showToast("手机号登录")
    }

    fun onTaste(){
        ToastUtil.showToast("立即体验")
    }
}