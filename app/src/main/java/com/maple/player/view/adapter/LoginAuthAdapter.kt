package com.maple.player.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.maple.player.R
import com.maple.player.databinding.ItemLoginAuthBinding
import com.maple.player.extensions.layoutInflater
import com.maple.player.model.entity.AuthEntity
import kotlinx.android.synthetic.main.item_login_auth.view.*

class LoginAuthAdapter : RecyclerView.Adapter<LoginAuthAdapter.ViewHolder>() {

    private var list: List<AuthEntity>? = null
    private var listener:OnClickListener? = null

    fun setData(list: List<AuthEntity>?) {
        this.list = list
        notifyDataSetChanged()
    }

    fun setListener(listener:OnClickListener?){
        this.listener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoginAuthAdapter.ViewHolder {
        val binding: ItemLoginAuthBinding = DataBindingUtil.inflate<ItemLoginAuthBinding>(
            parent.context.layoutInflater,
           R.layout.item_login_auth,
            parent,
            false
        )
        val holder: ViewHolder = ViewHolder(binding.root)
        holder.itemView.item_root.setOnClickListener {
            listener?.onItemClick(holder.adapterPosition)
        }
        return holder
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: LoginAuthAdapter.ViewHolder, position: Int) {
        holder.setData(position,list?.get(position))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(pos:Int,entity: AuthEntity?) {
            if (entity != null) {
                itemView.tv_auth_tag.visibility = if(entity.isTag) View.VISIBLE else View.INVISIBLE
                itemView.iv_icon.setBackgroundResource(entity.icon)
            }
        }
    }

    interface OnClickListener{
        fun onItemClick(pos:Int)
    }
}