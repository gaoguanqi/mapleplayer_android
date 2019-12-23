package com.maple.player.viewmodel

import androidx.lifecycle.MutableLiveData
import com.maple.player.base.BaseViewModel
import com.maple.player.extensions.isResultSuccess
import com.maple.player.model.entity.Banner
import com.maple.player.model.entity.VideoData
import com.maple.player.model.entity.VideoTabEntity
import com.maple.player.model.repository.HomeRepository
import com.maple.player.utils.LogUtils

class VideoViewModel : BaseViewModel() {

    private val repository by lazy { HomeRepository() }


    val videoTabData: MutableLiveData<List<VideoData>> = MutableLiveData()

    fun getVideoGroup() {
        launch(
            {
                val result: VideoTabEntity = repository.getVideoGroup()
                if (result.code.isResultSuccess()) {
                    videoTabData.value = result.data
                } else {
                    defUI.toastEvent.postValue("${result.message}")
                }
            },
            {
                defUI.toastEvent.postValue("error:${it.code} -- ${it.errMsg}")
            },
            {
                LogUtils.logGGQ("回调完成 complete")
            }, false
        )
    }

}