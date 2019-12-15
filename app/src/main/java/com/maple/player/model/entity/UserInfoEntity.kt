package com.maple.player.model.entity

/**
 * {
"loginType": 1,
"code": 200,
"account": {
"id": 2076800743,
"userName": "1_18738159627",
"type": 1,
"status": 0,
"whitelistAuthority": 0,
"createTime": 1576392142877,
"salt": "[B@4b311d99",
"tokenVersion": 0,
"ban": 0,
"baoyueVersion": 0,
"donateVersion": 0,
"vipType": 0,
"viptypeVersion": 0,
"anonimousUser": false
},
"token": "0a3d349f8d50aa92e902e134f72877b00bd72986c271023c379acc0451b4d1f364ec689611ed33ee6b43571d83cc503a41049cea1c6bb9b6",
"profile": {
"avatarImgIdStr": "109951163250233892",
"backgroundImgIdStr": "109951162868128395",
"vipType": 0,
"gender": 0,
"accountStatus": 0,
"avatarImgId": 109951163250233890,
"nickname": "独家记忆Liveee",
"birthday": -2209017600000,
"city": 100,
"userType": 0,
"backgroundImgId": 109951162868128400,
"province": 0,
"defaultAvatar": true,
"avatarUrl": "https://p4.music.126.net/ma8NC_MpYqC-dK_L81FWXQ==/109951163250233892.jpg",
"djStatus": 0,
"experts": {},
"mutual": false,
"remarkName": null,
"expertTags": null,
"authStatus": 0,
"userId": 2076800743,
"detailDescription": "",
"followed": false,
"backgroundUrl": "https://p4.music.126.net/2zSNIqTcpHL2jIvU6hG0EA==/109951162868128395.jpg",
"description": "",
"signature": "",
"authority": 0,
"avatarImgId_str": "109951163250233892",
"followeds": 0,
"follows": 0,
"eventCount": 0,
"playlistCount": 0,
"playlistBeSubscribedCount": 0
},
"bindings": [{
"url": "",
"expired": false,
"refreshTime": 1576392142,
"tokenJsonStr": "{\"countrycode\":\"\",\"cellphone\":\"18738159627\",\"hasPassword\":true}",
"bindingTime": 1576392142878,
"expiresIn": 2147483647,
"userId": 2076800743,
"id": 7010154887,
"type": 1
}]
}
 */
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