package com.maple.player.viewmodel

import androidx.lifecycle.MutableLiveData
import com.maple.player.R
import com.maple.player.base.BaseViewModel
import com.maple.player.extensions.isResultSuccess
import com.maple.player.model.entity.*
import com.maple.player.model.repository.HomeRepository
import com.maple.player.utils.LogUtils
import com.maple.player.utils.UIUtils

class FindViewModel : BaseViewModel() {

    private val repository by lazy { HomeRepository() }

    val bannerData: MutableLiveData<List<Banner>> = MutableLiveData()
    val gatherData: MutableLiveData<List<GatherData>> = MutableLiveData()
    val recommendData: MutableLiveData<List<Result>> = MutableLiveData()

    fun getBannerData() {
        launch(
            {
                val type: String = "0"
                val result: BannerEntity = repository.getBanner(type)
                if (result.code.isResultSuccess()) {
                    bannerData.value = result.banners
                } else {
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

    fun getGatherData() {
        gatherData.value = listOf(
            GatherData(1, "每日推荐", UIUtils.getDrawable(R.drawable.icon_daily)),
            GatherData(2, "歌单", UIUtils.getDrawable(R.drawable.icon_playlist)),
            GatherData(3, "排行榜", UIUtils.getDrawable(R.drawable.icon_rank)),
            GatherData(4, "电台", UIUtils.getDrawable(R.drawable.icon_radio)),
            GatherData(4, "直播", UIUtils.getDrawable(R.drawable.icon_look))
        )
    }

    fun getRecommendData() {
        launch(
            {
                val limit: String = "6"
                val result: RecommendEntity = repository.getRecommend(limit)
                if (result.code.isResultSuccess()) {
                    recommendData.value = result.result
                } else {
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