package com.maple.player.viewmodel

import androidx.lifecycle.MutableLiveData
import com.maple.player.base.BaseViewModel
import com.maple.player.extensions.isResultSuccess
import com.maple.player.model.entity.VideoListDatas
import com.maple.player.model.entity.VideoListEntity
import com.maple.player.model.repository.HomeRepository
import com.maple.player.utils.LogUtils

class VideoListViewModel : BaseViewModel() {

    private val repository by lazy { HomeRepository() }

    val videoListData: MutableLiveData<List<VideoListDatas>> = MutableLiveData()
    val refreshListData: MutableLiveData<List<VideoListDatas>> = MutableLiveData()


    fun getVideoList(videoId: String) {
        launch(
            {
                val result: VideoListEntity = repository.getVideoList(videoId)
                if (result.code.isResultSuccess()) {
                    videoListData.value = result.datas
                } else {
                    defUI.toastEvent.postValue("${result.msg}")
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


    fun refreshVideoList(videoId: String) {
        launch(
            {
                val result: VideoListEntity = repository.getVideoList(videoId)
                if (result.code.isResultSuccess()) {
                    refreshListData.value = result.datas
                } else {
                    defUI.toastEvent.postValue("${result.msg}")
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