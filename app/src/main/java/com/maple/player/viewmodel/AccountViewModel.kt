package com.maple.player.viewmodel

import com.maple.player.app.manager.SingleLiveEvent
import com.maple.player.base.BaseViewModel

class AccountViewModel : BaseViewModel() {

    val bellEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val orderEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val createrEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val settingEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val darkEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val timerOffEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val timerClockEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val freeLineEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val voucherEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val youngEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val shareEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val aboutEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val logoutEvent: SingleLiveEvent<Any> = SingleLiveEvent()


    fun onBell(){
        bellEvent.call()
    }
    fun onOrder(){
        bellEvent.call()
    }
    fun onCreater(){
        bellEvent.call()
    }
    fun onSetting(){
        bellEvent.call()
    }
    fun onDark(){
        bellEvent.call()
    }
    fun onTimerOff(){
        bellEvent.call()
    }
    fun onTimerClock(){
        bellEvent.call()
    }
    fun onFreeLine(){
        bellEvent.call()
    }
    fun onVoucher(){
        bellEvent.call()
    }
    fun onYoung(){
        bellEvent.call()
    }
    fun onShare(){
        bellEvent.call()
    }
    fun onAbout(){
        bellEvent.call()
    }
    fun onLogout(){
        bellEvent.call()
    }
}