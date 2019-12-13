package com.maple.player.viewmodel

import androidx.databinding.ObservableField
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.app.manager.SingleLiveEvent
import com.maple.player.base.BaseViewModel
import com.maple.player.model.entity.CheckPhoneEntity
import com.maple.player.model.entity.UserInfoEntity
import com.maple.player.model.repository.AccountRepository
import com.maple.player.utils.LogUtils
import com.maple.player.utils.UIUtils

class PhoneViewModel(private val app:MyApplication) : BaseViewModel(app) {

    private val repository by lazy { AccountRepository() }

    val title: ObservableField<String> = ObservableField()
    val backEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val nextEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val clearEvent: SingleLiveEvent<Any> = SingleLiveEvent()

    val acceptEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val registEvent: SingleLiveEvent<Any> = SingleLiveEvent()

    val hasNext: ObservableField<Boolean> = ObservableField(false)


    init {
        defUI.title.set(UIUtils.getString(R.string.title_login_phone))
    }

    fun onBack() {
        backEvent.call()
    }


    fun onPhoneNext() {
        nextEvent.call()
    }

    fun onClear() {
        clearEvent.call()
    }

    fun onCheckPhone(phone: String) {
        //{"exist":-1,"nickname":null,"hasPassword":false,"code":200}
        //{"exist":1,"nickname":"说出来祢可能不信","hasPassword":true,"code":200}
        launch(
            {
                val result: CheckPhoneEntity = repository.checkPhone(phone).apply {
                    if(this.code == 200){
                        if(this.exist == 1){
                            acceptEvent.call()
                        }else{
                            registEvent.call()
                        }
                    }else{
                        defUI.toastEvent.postValue("error:未知")
                    }
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