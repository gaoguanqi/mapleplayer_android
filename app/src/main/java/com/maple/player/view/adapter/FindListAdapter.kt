package com.maple.player.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.databinding.ItemArtistsBinding
import com.maple.player.extensions.layoutInflater
import com.maple.player.model.entity.Artists
import com.maple.player.widget.imgloader.ImageLoader
import com.maple.player.widget.imgloader.TransType
import com.maple.player.widget.imgloader.glide.GlideImageConfig

class FindListAdapter : ListAdapter<Artists, FindListAdapter.ViewHolder>(DiffCallback()) {

    private lateinit var binding: ItemArtistsBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate<ItemArtistsBinding>(
            parent.context.layoutInflater,
            R.layout.item_artists,
            parent,
            false
        )
        val holder: FindListAdapter.ViewHolder = ViewHolder(binding.root)
        return holder
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(getItem(position))
    }


    class DiffCallback : DiffUtil.ItemCallback<Artists>(){
        override fun areItemsTheSame(oldItem: Artists, newItem: Artists): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Artists, newItem: Artists): Boolean {
            return oldItem == newItem
        }
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(item: Artists?) {
            binding.tvLike.text = item?.albumSize
            binding.tvRemark.text = item?.topicPerson
            binding.tvTitle.text = item?.name
            item?.picUrl?.let {
                ImageLoader.getInstance().loadImage(
                    MyApplication.instance,
                    GlideImageConfig(item.picUrl, binding.ivImg).also {
                        it.type = TransType.NORMAL
                    })
            }

            item?.img1v1Url?.let {
                ImageLoader.getInstance().loadImage(
                    MyApplication.instance,
                    GlideImageConfig(item.img1v1Url, binding.ivAvatar).also {
                        it.type = TransType.CIRCLE
                    })
            }
        }
    }

}