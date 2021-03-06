package com.maple.player.viewmodel

import androidx.lifecycle.MutableLiveData
import com.maple.player.base.BaseViewModel
import com.maple.player.extensions.isResultSuccess
import com.maple.player.model.entity.Album
import com.maple.player.model.entity.NewestEntity
import com.maple.player.model.repository.HomeRepository
import com.maple.player.utils.LogUtils

class NewMusicViewModel : BaseViewModel() {


    private val repository by lazy { HomeRepository() }

    val newMusicData: MutableLiveData<List<Album>> = MutableLiveData()

    fun getNewMusicData() {
        launch(
            {
                val result: NewestEntity = repository.getNewest()
                if (result.code.isResultSuccess()) {
                    //随机获取3条数据
                    newMusicData.value = result.albums.shuffled().take(3)
                    LogUtils.logGGQ("新歌->>getNewMusicData")
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