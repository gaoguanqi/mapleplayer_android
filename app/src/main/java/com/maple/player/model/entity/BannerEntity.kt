package com.maple.player.model.entity
 data class BannerEntity(
    val banners: List<Banner>,
    val code: Int,
    val message:String = "error message!!!"
 )

data class Banner(
    val adDispatchJson: Any,
    val adLocation: Any,
    val adSource: Any,
    val adid: Any,
    val encodeId: String = "",
    val event: Any,
    val exclusive: Boolean,
    val extMonitor: Any,
    val extMonitorInfo: Any,
    val imageUrl: String = "",
    val monitorBlackList: Any,
    val monitorClick: Any,
    val monitorClickList: Any,
    val monitorImpress: Any,
    val monitorImpressList: Any,
    val monitorType: Any,
    val program: Any,
    val scm: String = "",
    val song: Any,
    val targetId: String = "",
    val targetType: String = "",
    val titleColor: String = "",
    val typeTitle: String = "",
    val url: String = "",
    val video: Any
)