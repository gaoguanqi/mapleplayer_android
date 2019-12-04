package com.maple.player.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.maple.player.R
import com.maple.player.databinding.ItemLoginAutoBinding
import com.maple.player.extensions.layoutInflater
import com.maple.player.model.AutoEntity
import kotlinx.android.synthetic.main.item_login_auto.view.*

class LoginAutoAdapter : RecyclerView.Adapter<LoginAutoAdapter.ViewHolder>() {

    private var list: List<AutoEntity>? = null
    private var listener:OnClickListener? = null

    fun setData(list: List<AutoEntity>?) {
        this.list = list
        notifyDataSetChanged()
    }

    fun setListener(listener:OnClickListener?){
        this.listener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoginAutoAdapter.ViewHolder {
        val binding: ItemLoginAutoBinding = DataBindingUtil.inflate<ItemLoginAutoBinding>(
            parent.context.layoutInflater,
            R.layout.item_login_auto,
            parent,
            false
        )
        return ViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: LoginAutoAdapter.ViewHolder, position: Int) {
        holder.setData(position,list?.get(position))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(pos:Int,entity: AutoEntity?) {
            if (entity != null) {
                itemView.tv_auto_tag.visibility = if(entity.isTag) View.VISIBLE else View.INVISIBLE
                itemView.iv_icon.setBackgroundResource(entity.icon)
                itemView.item_root.setOnClickListener { listener?.onItemClick(pos) }
            }
        }
    }

    interface OnClickListener{
        fun onItemClick(pos:Int)
    }
}