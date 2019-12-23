package com.maple.player.model.entity

data class VideoListEntity(
    val code: Int,
    val datas: List<VideoListDatas>,
    val hasmore: Boolean,
    val msg:String = "error message!!!",
    val rcmdLimit: Int
)

data class VideoListDatas(
    val alg: String? = "",
    val `data`: VideoListData,
    val displayed: Boolean,
    val extAlg: Any,
    val type: Int
)

data class VideoListData(
    val alg: String? = "",
    val commentCount: Int,
    val coverUrl: String? = "",
    val creator: Creator,
    val description: String? = "",
    val durationms: Int,
    val hasRelatedGameAd: Boolean,
    val height: Int,
    val markTypes: Any,
    val playTime: Int,
    val praised: Boolean,
    val praisedCount: Int,
    val previewDurationms: Int,
    val previewUrl: Any,
    val relateSong: List<Any>,
    val relatedInfo: Any,
    val resolutions: List<Resolution>,
    val scm: String? = "",
    val shareCount: Int,
    val subscribed: Boolean,
    val threadId: String? = "",
    val title: String? = "",
    val urlInfo: UrlInfo,
    val vid: String? = "",
    val videoGroup: List<VideoGroup>,
    val videoUserLiveInfo: Any,
    val width: Int
)

data class Creator(
    val accountStatus: Int,
    val authStatus: Int,
    val authority: Int,
    val avatarImgId: Long,
    val avatarImgIdStr: String? = "",
    val avatarImgId_str: String? = "",
    val avatarUrl: String? = "",
    val backgroundImgId: Long,
    val backgroundImgIdStr: String? = "",
    val backgroundUrl: String? = "",
    val birthday: Long,
    val city: Int,
    val defaultAvatar: Boolean,
    val description: String? = "",
    val detailDescription: String?= "",
    val djStatus: Int,
    val expertTags: Any,
    val experts: VideoListExperts,
    val followed: Boolean,
    val gender: Int,
    val mutual: Boolean,
    val nickname: String? = "",
    val province: Int,
    val remarkName: Any,
    val signature: String? = "",
    val userId: Int,
    val userType: Int,
    val vipType: Int
)

data class VideoListExperts(
    val `1`: String? = ""
)

data class Resolution(
    val resolution: Int,
    val size: Int
)

data class UrlInfo(
    val id: String? = "",
    val needPay: Boolean,
    val payInfo: Any,
    val r: Int,
    val size: Int,
    val url: String? = "",
    val validityTime: Int
)

data class VideoGroup(
    val alg: String? = "",
    val id: Int,
    val name: String? = ""
)