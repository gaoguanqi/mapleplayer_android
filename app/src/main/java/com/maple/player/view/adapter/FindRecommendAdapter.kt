package com.maple.player.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.databinding.ItemRecommendBinding
import com.maple.player.extensions.layoutInflater
import com.maple.player.model.entity.Result
import com.maple.player.widget.imgloader.ImageLoader
import com.maple.player.widget.imgloader.TransType
import com.maple.player.widget.imgloader.glide.GlideImageConfig

class FindRecommendAdapter : ListAdapter<Result, FindRecommendAdapter.ViewHolder>(DiffCallback()) {

    private lateinit var binding: ItemRecommendBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate<ItemRecommendBinding>(
            parent.context.layoutInflater,
            R.layout.item_recommend,
            parent,
            false
        )
        val holder: FindRecommendAdapter.ViewHolder = ViewHolder(binding.root)
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(getItem(position))
    }


    class DiffCallback : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(item: Result?) {
            binding.tvName.text = item?.name
            binding.tvCount.text = "${item?.trackCount}万"
            item?.picUrl?.let {
                ImageLoader.getInstance().loadImage(
                    MyApplication.instance,
                    GlideImageConfig(item.picUrl, binding.ivPic).also {
                        it.type = TransType.ROUND
                        it.valueRound = 6
                    })
            }
        }

    }

}