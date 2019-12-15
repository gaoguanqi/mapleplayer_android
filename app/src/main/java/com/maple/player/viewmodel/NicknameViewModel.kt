package com.maple.player.viewmodel

import androidx.databinding.ObservableField
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.app.manager.SingleLiveEvent
import com.maple.player.base.BaseViewModel
import com.maple.player.model.entity.ResultEntity
import com.maple.player.model.entity.UserInfoEntity
import com.maple.player.model.repository.AccountRepository
import com.maple.player.utils.LogUtils
import com.maple.player.utils.UIUtils

class NicknameViewModel(private val app: MyApplication) : BaseViewModel(app) {

    private val repository by lazy { AccountRepository() }

    val backEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val clearEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val submitEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val homeEvent:SingleLiveEvent<Any> = SingleLiveEvent()

    val hasClear: ObservableField<Boolean> = ObservableField(false)


    init {
        defUI.title.set(UIUtils.getString(R.string.title_nickname))
    }

    fun onBack() {
        backEvent.call()
    }

    fun onClear() {
        clearEvent.call()
    }

    fun onSubmit() {
        submitEvent.call()
    }

    fun onConfirmSubmit(phone:String,password:String,verifyCode:String,nickname:String){
        launch(
            {
                val result: UserInfoEntity = repository.registerPhone(phone,password,verifyCode,nickname).apply {
                    if(this.code == 200){
                        //save userinfo room

                        homeEvent.call()
                    }else{
                        defUI.toastEvent.postValue("${this.message}")
                    }
                }
            },
            {
                defUI.toastEvent.postValue("error:${it.code} -- ${it.errMsg}")
            },
            {
                LogUtils.logGGQ("回调完成 complete")
            })
    }

}