package com.maple.player.viewmodel

import androidx.databinding.ObservableField
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.app.manager.SingleLiveEvent
import com.maple.player.base.BaseViewModel
import com.maple.player.db.AppDatabase
import com.maple.player.db.user.*
import com.maple.player.model.entity.ResultEntity
import com.maple.player.model.entity.UserInfoEntity
import com.maple.player.model.repository.AccountRepository
import com.maple.player.utils.LogUtils
import com.maple.player.utils.UIUtils
import org.jetbrains.anko.collections.forEachByIndex

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
//                val result: UserInfoEntity = repository.registerPhone(phone,password,verifyCode,nickname).apply {
//                    if(this.code == 200){
//                        //save userinfo room
//                        val user: User = User()
//                        user.loginType = this.loginType
//                        user.nickname = this.profile?.nickname
//
//                        user.account = Account(
//                            this.account?.anonimousUser,
//                            this.account?.ban,
//                            this.account?.baoyueVersion,
//                            this.account?.createTime,
//                            this.account?.donateVersion,
//                            this.account?.id,
//                            this.account?.salt,
//                            this.account?.status,
//                            this.account?.tokenVersion,
//                            this.account?.type,
//                            this.account?.userName,
//                            this.account?.vipType,
//                            this.account?.viptypeVersion,
//                            this.account?.whitelistAuthority
//                        )
//                        user.profile = Profile(
//                            this.profile?.accountStatus,
//                            this.profile?.authStatus,
//                            this.profile?.authority,
//                            this.profile?.avatarImgId,
//                            this.profile?.avatarImgIdStr,
//                            this.profile?.avatarImgId_str,
//                            this.profile?.avatarUrl,
//                            this.profile?.backgroundImgId,
//                            this.profile?.backgroundImgIdStr,
//                            this.profile?.backgroundUrl,
//                            this.profile?.birthday,
//                            this.profile?.city,
//                            this.profile?.defaultAvatar,
//                            this.profile?.description,
//                            this.profile?.detailDescription,
//                            this.profile?.djStatus,
//                            this.profile?.eventCount,
//                            this.profile?.expertTags,
//                            Experts(),
//                            this.profile?.followed,
//                            this.profile?.followeds,
//                            this.profile?.follows,
//                            this.profile?.gender,
//                            this.profile?.mutual,
//                            this.profile?.nickname,
//                            this.profile?.playlistBeSubscribedCount,
//                            this.profile?.playlistCount,
//                            this.profile?.province,
//                            this.profile?.remarkName,
//                            this.profile?.signature,
//                            this.profile?.userId,
//                            this.profile?.userType,
//                            this.profile?.vipType
//                        )
//
//                        user.bindings = mutableListOf<Binding>()
//                        this.bindings?.forEachByIndex {
//                            val binding: Binding = Binding(
//                                it.bindingTime,
//                                it.expired,
//                                it.expiresIn,
//                                it.id,
//                                it.refreshTime,
//                                it.tokenJsonStr,
//                                it.type,
//                                it.url,
//                                it.userId
//                            )
//                            user.bindings?.add(binding)
//                        }
//
//                        user.loginType = this.loginType
//                        user.token = this.token
//                    }else{
//                        defUI.toastEvent.postValue("${this.message}")
//                    }
//                }

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