package com.maple.player.viewmodel

import androidx.lifecycle.MutableLiveData
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.app.manager.SingleLiveEvent
import com.maple.player.base.BaseViewModel
import com.maple.player.db.AppDatabase
import com.maple.player.extensions.isResultSuccess
import com.maple.player.model.entity.UserInfoEntity
import com.maple.player.model.repository.HomeRepository
import com.maple.player.utils.LogUtils
import com.maple.player.utils.UIUtils

class AccountViewModel : BaseViewModel() {

    private val repository by lazy { HomeRepository() }

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

    val messageEvent:SingleLiveEvent<Any> = SingleLiveEvent()
    val shopEvent:SingleLiveEvent<Any> = SingleLiveEvent()
    val showEvent:SingleLiveEvent<Any> = SingleLiveEvent()
    val theEvent:SingleLiveEvent<Any> = SingleLiveEvent()

    val switchDarkValue:MutableLiveData<Boolean> = MutableLiveData(false)

    val userDetail:MutableLiveData<UserInfoEntity> = MutableLiveData()

    init {
        defUI.title.set(UIUtils.getString(R.string.title_account))
    }

    fun onMessageClick(){
        messageEvent.call()
    }
    fun onShopClick(){
        shopEvent.call()
    }
    fun onShowClick(){
        showEvent.call()
    }
    fun onTheClick(){
        theEvent.call()
    }


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

    fun getUserDetail() {
        launch(
            {
                val user = AppDatabase.getInstance(MyApplication.instance).userDao().getAllUser().last()
                LogUtils.logGGQ("user:${user.nickname}")

                val result: UserInfoEntity = repository.getUserDetail(user.uid!!)
                if (result.code.isResultSuccess()) {
                    userDetail.value = result
                } else {
                    defUI.toastEvent.postValue("${result.message}")
                }
            },
            {
                defUI.toastEvent.postValue("error:${it.code} -- ${it.errMsg}")
            },
            {
                LogUtils.logGGQ("回调完成 complete")
            },false)
    }
}