package com.maple.player.model.entity

data class ArtistsListEntity(
    val artists: List<Artists>,
    val code: Int,
    val more: Boolean,
    val message:String = "error message!!!"
)

data class Artists(
    val id: String,
    val img1v1Url: String,
    val picUrl: String,
    val followed: Boolean,
    val musicSize: Int,
    val albumSize: String,
    val topicPerson: String,
    val name: String


)