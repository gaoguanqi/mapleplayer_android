package com.maple.player.view.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.maple.player.R
import com.maple.player.databinding.ItemFindGatherBinding
import com.maple.player.databinding.ItemGatherBinding
import com.maple.player.databinding.ItemNewDiscBinding
import com.maple.player.extensions.layoutInflater
import com.maple.player.model.entity.GatherData

class FindGatherAdapter : ListAdapter<GatherData, FindGatherAdapter.ViewHolder>(DiffCallback()) {

    private lateinit var binding: ItemGatherBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         binding = DataBindingUtil.inflate<ItemGatherBinding>(
            parent.context.layoutInflater,
            R.layout.item_gather,
            parent,
            false
        )
        val holder:ViewHolder = ViewHolder(binding.root)
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(getItem(position))
    }

     class DiffCallback : DiffUtil.ItemCallback<GatherData>() {
        override fun areItemsTheSame(oldItem: GatherData, newItem: GatherData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GatherData, newItem: GatherData): Boolean {
            return oldItem == newItem
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(item: GatherData?) {
            binding.tvText.text = item?.text
            binding.ivIcon.background = item?.icon
        }
    }
}


