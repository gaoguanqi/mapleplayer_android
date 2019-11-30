package com.maple.player.widget.imgloader.glide

import android.widget.ImageView
import com.maple.player.R
import com.maple.player.widget.imgloader.ImageConfig
import com.maple.player.widget.imgloader.TransType
import com.maple.player.widget.imgloader.listener.ProgressListener

class GlideImageConfig:ImageConfig {
    var overWidth:Int = 0
    var overHeight:Int = 0

    var valueBlur:Int = 0
    var valueRound:Int = 0

    var progressListener:ProgressListener? = null
    var type: TransType = TransType.NORMAL

    constructor(any:Any, imageView: ImageView,progressListener: ProgressListener? = null, placeholder:Int = R.drawable.ic_default_placeholder, errorPic:Int = R.drawable.ic_default_errorpic){
        this.any = any
        this.imageView = imageView
        this.progressListener = progressListener
        this.placeholder = placeholder
        this.errorPic = errorPic
    }
}