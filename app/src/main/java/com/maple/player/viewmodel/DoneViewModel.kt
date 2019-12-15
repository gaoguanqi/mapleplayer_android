package com.maple.player.viewmodel

import androidx.databinding.ObservableField
import com.blankj.utilcode.util.GsonUtils
import com.github.salomonbrys.kotson.fromJson
import com.google.gson.Gson
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.app.manager.SingleLiveEvent
import com.maple.player.base.BaseViewModel
import com.maple.player.db.AppDatabase
import com.maple.player.db.user.*
import com.maple.player.http.BaseResult
import com.maple.player.model.entity.UserInfoEntity
import com.maple.player.model.repository.AccountRepository
import com.maple.player.utils.LogUtils
import com.maple.player.utils.StringNullAdapter
import com.maple.player.utils.ToastUtil
import com.maple.player.utils.UIUtils
import org.jetbrains.anko.collections.forEachByIndex

class DoneViewModel(private val app:MyApplication):BaseViewModel(app) {

    private val repository by lazy { AccountRepository() }

    val backEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val doneEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val clearEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val resetEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    val homeEvent:SingleLiveEvent<Any> = SingleLiveEvent()

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
                val result:UserInfoEntity = repository.loginPhone(phone,password)
                if(result.code == 200){
                    AppDatabase.getInstance(app).userDao().insertUser(User().apply {
                        this.loginType = result.loginType
                        this.nickname = result.profile?.nickname
                    })
                    if(!AppDatabase.getInstance(app).userDao().getAllUser().isNullOrEmpty()){
                        homeEvent.call()
                    }
                }else{
                    defUI.toastEvent.postValue("${result.message}")
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