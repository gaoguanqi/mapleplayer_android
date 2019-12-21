package com.maple.player.model.entity
data class NewestEntity(
    val albums: List<Album>,
    val code: Int,
    val message:String = "error message!!!"
)

data class Album(
    val alias: List<Any>,
    val artist: Artist,
    val artists: List<ArtistX>,
    val blurPicUrl: String,
    val briefDesc: String,
    val commentThreadId: String,
    val company: String,
    val companyId: Int,
    val copyrightId: Int,
    val description: String,
    val id: Int,
    val name: String,
    val onSale: Boolean,
    val paid: Boolean,
    val pic: Long,
    val picId: Long,
    val picId_str: String,
    val picUrl: String,
    val publishTime: Long,
    val size: Int,
    val songs: Any,
    val status: Int,
    val tags: String,
    val type: String
)

data class Artist(
    val albumSize: Int,
    val alias: List<Any>,
    val briefDesc: String,
    val id: Int,
    val img1v1Id: Long,
    val img1v1Id_str: String,
    val img1v1Url: String,
    val musicSize: Int,
    val name: String,
    val picId: Long,
    val picId_str: String,
    val picUrl: String,
    val topicPerson: Int,
    val trans: String
)

data class ArtistX(
    val albumSize: Int,
    val alias: List<Any>,
    val briefDesc: String,
    val id: Int,
    val img1v1Id: Long,
    val img1v1Id_str: String,
    val img1v1Url: String,
    val musicSize: Int,
    val name: String,
    val picId: Int,
    val picUrl: String,
    val topicPerson: Int,
    val trans: String
)