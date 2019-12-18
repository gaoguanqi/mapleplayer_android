package com.maple.player.viewmodel

import androidx.lifecycle.MutableLiveData
import com.maple.player.app.manager.SingleLiveEvent
import com.maple.player.base.BaseViewModel

class AccountViewModel : BaseViewModel() {

    val bellEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val orderEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val createrEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val settingEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val timerOffEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val timerClockEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val freeLineEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val voucherEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val youngEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val shareEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val aboutEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val logoutEvent: SingleLiveEvent<Any> = SingleLiveEvent()

    val switchDarkValue:MutableLiveData<Boolean> = MutableLiveData(false)

    fun onBellClick(){
        bellEvent.call()
    }
    fun onOrderClick(){
        orderEvent.call()
    }
    fun onCreaterClick(){
        createrEvent.call()
    }
    fun onSettingClick(){
        settingEvent.call()
    }

    fun onTimerOffClick(){
        timerOffEvent.call()
    }
    fun onTimerClockClick(){
        timerClockEvent.call()
    }
    fun onFreeLineClick(){
        freeLineEvent.call()
    }
    fun onVoucherClick(){
        voucherEvent.call()
    }
    fun onYoungClick(){
        youngEvent.call()
    }
    fun onShareClick(){
        shareEvent.call()
    }
    fun onAboutClick(){
        aboutEvent.call()
    }
    fun onLogout(){
        logoutEvent.call()
    }
}