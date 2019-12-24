package com.maple.player.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.databinding.ItemVideoListBinding
import com.maple.player.extensions.layoutInflater
import com.maple.player.model.entity.VideoListDatas
import com.maple.player.widget.imgloader.ImageLoader
import com.maple.player.widget.imgloader.TransType
import com.maple.player.widget.imgloader.glide.GlideImageConfig
import java.io.IOException

class VideoListAdapter : ListAdapter<VideoListDatas, VideoListAdapter.ViewHolder>(DiffCallback()) {

    private lateinit var binding: ItemVideoListBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate<ItemVideoListBinding>(
            parent.context.layoutInflater,
            R.layout.item_video_list,
            parent,
            false
        )
        val holder: VideoListAdapter.ViewHolder = ViewHolder(binding.root)
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(getItem(position))
    }


    fun updataList(list: List<VideoListDatas>) {
        this.submitList(list)
        this.notifyDataSetChanged()
    }

    class DiffCallback : DiffUtil.ItemCallback<VideoListDatas>() {
        override fun areItemsTheSame(oldItem: VideoListDatas, newItem: VideoListDatas): Boolean {
            return oldItem.data.vid == newItem.data.vid
        }

        override fun areContentsTheSame(oldItem: VideoListDatas, newItem: VideoListDatas): Boolean {
            return oldItem == newItem
        }
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(item: VideoListDatas?) {
            item?.data?.let {

                it.title?.let {
                    binding.tvTitle.text = it
                }

                it.commentCount?.let {
                    binding.tvLike.text = it.toString()
                }

                it.shareCount?.let {
                    binding.tvMsg.text = it.toString()
                }

                it.creator?.nickname?.let {
                    binding.tvName.text = it
                }

                it.creator?.avatarUrl?.let {
                    ImageLoader.getInstance().loadImage(MyApplication.instance,
                        GlideImageConfig(it, binding.ivAvatar).also {
                            it.type = TransType.CIRCLE
                        }
                    )
                }

                it.urlInfo?.url?.let {
                    try {
//                        binding.player.load(it)
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }
        }

    }

}