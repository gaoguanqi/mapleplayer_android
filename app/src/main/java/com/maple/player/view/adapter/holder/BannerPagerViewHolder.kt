package com.maple.player.view.adapter.holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.model.entity.Banner
import com.maple.player.widget.imgloader.ImageLoader
import com.maple.player.widget.imgloader.TransType
import com.maple.player.widget.imgloader.glide.GlideImageConfig
import com.zhpan.bannerview.holder.ViewHolder

class BannerPagerViewHolder:ViewHolder<Banner> {
    override fun getLayoutId(): Int {
        return R.layout.item_banner
    }

    override fun onBind(itemView: View?, data: Banner?, position: Int, size: Int) {
       val imageView:ImageView? = itemView?.findViewById<ImageView>(R.id.banner_image)
       val tvType:TextView? = itemView?.findViewById<TextView>(R.id.tv_type)
        if(imageView != null && data != null && tvType != null){
            tvType.text = data.typeTitle
            ImageLoader.getInstance().loadImage(
                MyApplication.instance,
                GlideImageConfig(data.imageUrl, imageView).also { it.type = TransType.NORMAL })
        }

    }
}