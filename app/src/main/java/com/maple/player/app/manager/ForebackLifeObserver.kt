package com.maple.player.app.manager

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.maple.player.utils.ToastUtil

/**
 * 前后台切换的观察者
 */
class ForebackLifeObserver:LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onForeground(){
        ToastUtil.showToast("APP进入前台")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onBackground(){
        ToastUtil.showToast("APP进入后台")
    }
}