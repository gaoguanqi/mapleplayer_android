package com.maple.player.model.entity

data class CheckPhoneEntity(
    val code: Int,
    val exist: Int,
    val hasPassword: Boolean = false,
    val nickname: String = ""
)
