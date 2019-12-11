package com.maple.player.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.maple.player.app.MyApplication
import com.maple.player.widget.imgloader.ImageLoader
import com.maple.player.widget.imgloader.TransType
import com.maple.player.widget.imgloader.glide.GlideImageConfig

object ImageAdapter {
    @BindingAdapter(value = ["url"], requireAll = false)
    @JvmStatic
    fun setImageUrl(imageView: ImageView, url: String) {
        ImageLoader.getInstance().loadImage(
            MyApplication.instance,
            GlideImageConfig(url, imageView).also { it.type = TransType.NORMAL })
    }
}