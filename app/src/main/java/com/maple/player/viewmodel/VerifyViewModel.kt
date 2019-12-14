package com.maple.player.viewmodel

import androidx.databinding.ObservableField
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.app.manager.SingleLiveEvent
import com.maple.player.base.BaseViewModel
import com.maple.player.model.entity.UserInfoEntity
import com.maple.player.model.entity.VerifyCodeEntity
import com.maple.player.model.repository.AccountRepository
import com.maple.player.utils.LogUtils
import com.maple.player.utils.UIUtils
import com.maple.player.widget.timer.MyCountDownTimer
import com.maple.player.widget.timer.MyCountDownTimerListener

class VerifyViewModel(private val app:MyApplication):BaseViewModel(app) {

    private val repository by lazy { AccountRepository() }

    val backEvent: SingleLiveEvent<Any> = SingleLiveEvent()
    var phone:String? = null
    private val timer:MyCountDownTimer

    val taskText: ObservableField<String> = ObservableField("重新发送")

    val taskTextEnable:ObservableField<Boolean> = ObservableField(true)

    init {
        defUI.title.set(UIUtils.getString(R.string.title_verify_phone))
        timer = MyCountDownTimer(60000,1000,object: MyCountDownTimerListener {
            override fun onStart() {
                taskTextEnable.set(false)
            }

            override fun onTick(millisUntilFinished: Long) {
                taskText.set("${millisUntilFinished} s")
            }

            override fun onFinish() {
                taskTextEnable.set(true)
                taskText.set("重新发送")
            }
        })
    }


    fun onBack() {
        backEvent.call()
    }

    fun sendVerifyCode(phone: String) {
        this.phone = phone
        launch(
            {
                val result: VerifyCodeEntity = repository.sendVerifyCode(phone).apply {
                    if(this.code == 200){
                        defUI.toastEvent.postValue("发送成功")
                    }else{
                        defUI.toastEvent.postValue("error:code ${code}")
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

    fun repeatSend() {
        phone?.apply {
            timer.start()
            launch(
                {
                    val result: VerifyCodeEntity = repository.sendVerifyCode(phone!!).apply {
                        if(this.code == 200){
                            defUI.toastEvent.postValue("发送成功")
                        }else{
                            defUI.toastEvent.postValue("error:code ${code}")
                        }
                    }
                },
                {
                    defUI.toastEvent.postValue("error:${it.code} -- ${it.errMsg}")
                },
                {
                    LogUtils.logGGQ("回调完成 complete")
                    timer.cancel()
                })
        }
    }

    //校验验证码
    fun checkVerifyCode(phone: String, content: String) {

    }
}