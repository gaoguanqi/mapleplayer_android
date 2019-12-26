package com.maple.player.view.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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
import com.maple.playerlibrary.player.VideoPlayer

class VideoListAdapter : ListAdapter<VideoListDatas, VideoListAdapter.ViewHolder>(DiffCallback()) {

    private lateinit var binding: ItemVideoListBinding


    private var listener: VideoListAdapter.OnClickListener? = null


    fun setListener(listener: VideoListAdapter.OnClickListener?) {
        this.listener = listener
    }

    init {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate<ItemVideoListBinding>(
            parent.context.layoutInflater,
            R.layout.item_video_list,
            parent,
            false
        )
        val holder: VideoListAdapter.ViewHolder = ViewHolder(binding.root)
        binding.player.setOnClickListener {
            listener?.onItemClick(
                holder.adapterPosition,
                currentList.get(holder.adapterPosition),
                binding.player
            )
        }

        binding.player.fullscreenButton.setOnClickListener {
            listener?.onItemFullscreenClick(
                holder.adapterPosition,
                currentList.get(holder.adapterPosition),
                binding.player
            )
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(getItem(position))
    }


    fun updataList(list: List<VideoListDatas>) {
        this.submitList(list)
        this.notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
//        return super.getItemViewType(position)
        return position
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
                    binding.player.apply {
                        this.setUp(it,true,item.data.title)
                        val coverImage:ImageView = ImageView(context).also {
                            it.scaleType = ImageView.ScaleType.CENTER_CROP
                        }
                        ImageLoader.getInstance().loadImage(MyApplication.instance,
                            GlideImageConfig(item.data.coverUrl!!, coverImage).also {
                                it.type = TransType.NORMAL
                            }
                        )
                        this.thumbImageView = coverImage
                        this.titleTextView.visibility = View.GONE
                        this.backButton.visibility = View.GONE
                        this.setIsTouchWiget(true)
                        this.setIsTouchWigetFull(true)
                        this.setShowFullAnimation(false)
                    }
                }
            }
        }
    }


    interface OnClickListener {
        fun onItemClick(pos: Int, data: VideoListDatas, player: VideoPlayer)
        fun onItemFullscreenClick(pos: Int, data: VideoListDatas, player: VideoPlayer)
    }
}