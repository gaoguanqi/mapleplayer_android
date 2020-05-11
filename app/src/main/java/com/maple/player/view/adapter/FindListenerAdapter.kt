package com.maple.player.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.databinding.ItemGatherBinding
import com.maple.player.databinding.ItemNewComerBinding
import com.maple.player.extensions.layoutInflater
import com.maple.player.model.entity.ComerData
import com.maple.player.model.entity.ComerList
import com.maple.player.model.entity.GatherData
import com.maple.player.widget.imgloader.ImageLoader
import com.maple.player.widget.imgloader.TransType
import com.maple.player.widget.imgloader.glide.GlideImageConfig

class FindListenerAdapter: ListAdapter<ComerList, FindListenerAdapter.ViewHolder>(DiffCallback()) {

    private lateinit var binding: ItemNewComerBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate<ItemNewComerBinding>(
            parent.context.layoutInflater,
            R.layout.item_new_comer,
            parent,
            false
        )
        val holder: FindListenerAdapter.ViewHolder = ViewHolder(binding.root)
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(getItem(position))
    }


    class DiffCallback: DiffUtil.ItemCallback<ComerList>() {
        override fun areItemsTheSame(oldItem: ComerList, newItem: ComerList): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ComerList, newItem: ComerList): Boolean {
            return oldItem == newItem
        }

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(item: ComerList?) {
            binding.tvTitle.text = item?.nickName
            item?.avatarUrl?.let {
                ImageLoader.getInstance().loadImage(
                    MyApplication.instance,
                    GlideImageConfig(item.avatarUrl, binding.ivImg).also {
                        it.type = TransType.ROUND
                        it.valueRound = 6
                    })
            }
        }

    }
}