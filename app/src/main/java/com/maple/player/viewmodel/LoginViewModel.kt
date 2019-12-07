package com.maple.player.viewmodel

import android.view.View
import androidx.databinding.ObservableField
import com.blankj.utilcode.util.SPUtils
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.app.global.Constants.SaveInfoKey.KEY_LOGIN_TAG
import com.maple.player.app.global.Constants.SaveInfoKey.VALUE_LOGIN_TAG_163
import com.maple.player.app.global.Constants.SaveInfoKey.VALUE_LOGIN_TAG_LOGIN
import com.maple.player.app.global.Constants.SaveInfoKey.VALUE_LOGIN_TAG_QQ
import com.maple.player.app.global.Constants.SaveInfoKey.VALUE_LOGIN_TAG_SINA
import com.maple.player.app.global.Constants.SaveInfoKey.VALUE_LOGIN_TAG_WX
import com.maple.player.app.manager.SingleLiveEvent
import com.maple.player.base.BaseViewModel
import com.maple.player.model.AuthEntity
import com.maple.player.utils.ToastUtil

class LoginViewModel(var app: MyApplication) : BaseViewModel(app) {

    val loginEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val tasteEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val shakeEvent: SingleLiveEvent<Any> = SingleLiveEvent()

    val isAgree: ObservableField<Boolean> = ObservableField(false)
    val loginTag: ObservableField<Int> = ObservableField()
    val authList: ObservableField<List<AuthEntity>> = ObservableField()

    init {
        val tag: Int = SPUtils.getInstance().getInt(KEY_LOGIN_TAG);
        if (VALUE_LOGIN_TAG_LOGIN == tag) loginTag.set(View.VISIBLE) else loginTag.set(View.GONE)
        val list: MutableList<AuthEntity> = mutableListOf()
        list.add(AuthEntity(VALUE_LOGIN_TAG_WX == tag, R.drawable.icon_logo_wx))
        list.add(AuthEntity(VALUE_LOGIN_TAG_QQ == tag, R.drawable.icon_logo_qq))
        list.add(AuthEntity(VALUE_LOGIN_TAG_SINA == tag, R.drawable.icon_logo_sina))
        list.add(AuthEntity(VALUE_LOGIN_TAG_163 == tag, R.drawable.icon_logo_163))
        authList.set(list)
    }

    fun onLogin() {
        if (isAgree.get()!!) {
            loginEvent.call()
        } else {
            ToastUtil.showTipToast("请先同意条款")
            shakeEvent.call()
        }
    }

    fun onTaste() {
        if (isAgree.get()!!) {
            tasteEvent.call()
        } else {
            ToastUtil.showTipToast("请先同意条款")
            shakeEvent.call()
        }
    }

    fun onAuto(pos: Int) {
        if (isAgree.get()!!) {
            when (pos) {
                0 -> SPUtils.getInstance().put(KEY_LOGIN_TAG, VALUE_LOGIN_TAG_WX)
                1 -> SPUtils.getInstance().put(KEY_LOGIN_TAG, VALUE_LOGIN_TAG_QQ)
                2 -> SPUtils.getInstance().put(KEY_LOGIN_TAG, VALUE_LOGIN_TAG_SINA)
                3 -> SPUtils.getInstance().put(KEY_LOGIN_TAG, VALUE_LOGIN_TAG_163)
            }
            ToastUtil.showTipToast("pos${pos}")
        } else {
            ToastUtil.showTipToast("请先同意条款")
            shakeEvent.call()
        }
    }
}