package com.maple.player.model.entity

data class UserDetailEntity(
    val adValid: Boolean,
    val bindings: List<UserBinding>,
    val code: Int,
    val createDays: String = "",
    val createTime: Long,
    val level: String = "",
    val listenSongs: String = "",
    val mobileSign: Boolean,
    val pcSign: Boolean,
    val peopleCanSeeMyPlayRecord: Boolean,
    val profile: UserProfile,
    val userPoint: UserPoint,
    val message:String = "error message!!!"
)

data class UserBinding(
    val bindingTime: Long,
    val expired: Boolean,
    val expiresIn: String = "",
    val id: Long,
    val refreshTime: Long,
    val tokenJsonStr: Any,
    val type: Int,
    val url: String = "",
    val userId: String = ""
)

data class UserProfile(
    val accountStatus: Int,
    val allSubscribedCount: Int,
    val artistIdentity: List<Any>,
    val authStatus: Int,
    val authority: Int,
    val avatarImgId: Long,
    val avatarImgIdStr: String = "",
    val avatarImgId_str: String = "",
    val avatarUrl: String = "",
    val backgroundImgId: Long,
    val backgroundImgIdStr: String = "",
    val backgroundUrl: String = "",
    val birthday: Long,
    val blacklist: Boolean,
    val cCount: Int,
    val city: Int,
    val createTime: Long,
    val defaultAvatar: Boolean,
    val description: String = "",
    val detailDescription: String = "",
    val djStatus: Int,
    val eventCount: Int,
    val expertTags: Any,
    val experts: UserExperts,
    val followMe: Boolean,
    val followTime: Any,
    val followed: Boolean,
    val followeds: Int,
    val follows: Int,
    val gender: Int,
    val mutual: Boolean,
    val newFollows: Int,
    val nickname: String = "",
    val playlistBeSubscribedCount: Int,
    val playlistCount: Int,
    val province: Int,
    val remarkName: Any,
    val sCount: Int,
    val sDJPCount: Int,
    val signature: String = "",
    val userId: Int,
    val userType: Int,
    val vipType: Int
)

class UserExperts(
)

data class UserPoint(
    val balance: Int,
    val blockBalance: Int,
    val status: Int,
    val updateTime: Long,
    val userId: Int,
    val version: Int
)