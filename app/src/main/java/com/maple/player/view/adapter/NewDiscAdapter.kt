package com.maple.player.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.databinding.ItemNewDiscBinding
import com.maple.player.extensions.layoutInflater
import com.maple.player.model.entity.Album
import com.maple.player.widget.imgloader.ImageLoader
import com.maple.player.widget.imgloader.TransType
import com.maple.player.widget.imgloader.glide.GlideImageConfig

class NewDiscAdapter : ListAdapter<Album, NewDiscAdapter.ViewHolder>(DiffCallback()) {

    private lateinit var binding: ItemNewDiscBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate<ItemNewDiscBinding>(
            parent.context.layoutInflater,
            R.layout.item_new_disc,
            parent,
            false
        )
        val holder: NewDiscAdapter.ViewHolder = ViewHolder(binding.root)
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(getItem(position))
    }


    class DiffCallback : DiffUtil.ItemCallback<Album>() {
        override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
            return oldItem == newItem
        }
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(item: Album?) {

            item?.name?.let {
                binding.tvTitle.text = it
            }

            item?.company?.let {
                binding.tvDesc.text = it
            }

            item?.picUrl?.let {
                ImageLoader.getInstance().loadImage(
                    MyApplication.instance,
                    GlideImageConfig(item.picUrl, binding.ivImg).also {
                        it.type = TransType.ROUND
                        it.valueRound = 6
                    })
            }
        }

    }


}