package com.maple.player.model.entity

data class NewComerEntity(
    val code: Int,
    val data: ComerData,
    val msg:String = "error message!!!"
)

data class ComerData(
    val list: List<ComerList>,
    val total: Int,
    val updateTime: String
)

data class ComerList(
    val avatarUrl: String,
    val id: String,
    val lastRank: Int,
    val nickName: String,
    val rank: Int,
    val score: String,
    val userType: Int
)