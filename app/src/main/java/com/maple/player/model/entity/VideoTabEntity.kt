package com.maple.player.model.entity

data class VideoTabEntity(
    val code: Int,
    val `data`: List<VideoData>,
    val message: String? = ""
)

data class VideoData(
    val abExtInfo: Any,
    val id: Int,
    val name: String? = "",
    val relatedVideoType: Any,
    val selectTab: Boolean,
    val url: String? = ""
)