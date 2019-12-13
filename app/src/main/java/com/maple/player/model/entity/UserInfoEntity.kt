package com.maple.player.model.entity

data class UserInfoEntity(
    val account: Account?,
    val bindings: List<Binding>?,
    val code: Int = 0,
    val loginType: Int = 0,
    val profile: Profile?,
    val token: String = "",
    val message:String = ""
)

data class Account(
    val anonimousUser: Boolean?,
    val ban: String = "",
    val baoyueVersion: String = "",
    val createTime: Long?,
    val donateVersion: String = "",
    val id: String = "",
    val salt: String = "",
    val status: String = "",
    val tokenVersion: String = "",
    val type: String = "",
    val userName: String ="",
    val vipType: String = "",
    val viptypeVersion: String = "",
    val whitelistAuthority: String = ""
)

data class Binding(
    val bindingTime: Long?,
    val expired: Boolean = false,
    val expiresIn: String = "",
    val id: String = "",
    val refreshTime: Long?,
    val tokenJsonStr: String = "",
    val type: String = "",
    val url: String = "",
    val userId: String = ""
)

data class Profile(
    val accountStatus: String = "",
    val authStatus: String = "",
    val authority: String = "",
    val avatarImgId: Long?,
    val avatarImgIdStr: String = "",
    val avatarImgId_str: String = "",
    val avatarUrl: String = "",
    val backgroundImgId: Long?,
    val backgroundImgIdStr: String = "",
    val backgroundUrl: String = "",
    val birthday: String = "",
    val city: String = "",
    val defaultAvatar: Boolean = false,
    val description: String = "",
    val detailDescription: String = "",
    val djStatus: String = "",
    val eventCount: String = "",
    val expertTags: Any?,
    val experts: Experts?,
    val followed: Boolean = false,
    val followeds: String = "",
    val follows: String = "",
    val gender: String = "",
    val mutual: Boolean = false,
    val nickname: String = "",
    val playlistBeSubscribedCount: String = "",
    val playlistCount: String = "",
    val province: String = "",
    val remarkName: Any?,
    val signature: String = "",
    val userId: String = "",
    val userType: String = "",
    val vipType: String = ""
)

class Experts(
)