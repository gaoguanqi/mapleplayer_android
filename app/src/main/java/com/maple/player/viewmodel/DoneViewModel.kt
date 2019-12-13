package com.maple.player.viewmodel

import androidx.databinding.ObservableField
import com.blankj.utilcode.util.GsonUtils
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.app.manager.SingleLiveEvent
import com.maple.player.base.BaseViewModel
import com.maple.player.http.BaseResult
import com.maple.player.model.entity.UserInfoEntity
import com.maple.player.model.repository.AccountRepository
import com.maple.player.utils.LogUtils
import com.maple.player.utils.UIUtils

class DoneViewModel(private val app:MyApplication):BaseViewModel(app) {

    private val repository by lazy { AccountRepository() }

    val backEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val doneEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val clearEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val resetEvent: SingleLiveEvent<Any> = SingleLiveEvent()

    val hasDone: ObservableField<Boolean> = ObservableField(false)


    init {
        defUI.title.set(UIUtils.getString(R.string.title_login_phone))
    }

    fun onBack() {
        backEvent.call()
    }

    fun onClear() {
        clearEvent.call()
    }

    fun onDone() {
        doneEvent.call()
    }

    fun onReset(){
        resetEvent.call()
    }

     fun onPhoneLogin(phone:String, password:String){

        launch(
            {
                val result:BaseResult<UserInfoEntity> = repository.loginPhone(phone,password)
                LogUtils.logGGQ("结果：$result")
                val entity:UserInfoEntity = GsonUtils.fromJson<UserInfoEntity>(result.toString(),UserInfoEntity::class.java)
                LogUtils.logGGQ("登录成功${entity.code}")
            },
            {
                LogUtils.logGGQ("异常${it.errMsg}")
            },
            {
                LogUtils.logGGQ("回调完成 complete $")
            })
    }
}