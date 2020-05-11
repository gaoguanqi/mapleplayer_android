package com.maple.player.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.maple.player.R
import com.maple.player.databinding.*
import com.maple.player.extensions.layoutInflater
import com.maple.player.model.entity.*
import com.maple.player.view.adapter.holder.BannerPagerViewHolder
import com.zhpan.bannerview.BannerViewPager

class HomeFindAdapter(val activity: FragmentActivity) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    companion object {
        //轮播图
        const val TYPE_BANNER: Int = 1
        //聚合
        const val TYPE_GATHER: Int = 2
        //推荐歌单
        const val TYPE_RECOMMEND: Int = 3
        //新碟 新歌
        const val TYPE_NEW: Int = 4
        //精选
        const val TYPE_GOOD: Int = 5
        //听听
        const val TYPE_LISTENER: Int = 6
        //广告
        const val TYPE_AD: Int = 7
        //列表
        const val TYPE_LIST: Int = 8
    }


    private var bannerList: List<Banner>? = null
    private var gatherList: List<GatherData>? = null
    private var recommendList: List<Result>? = null
    private var newPageList: List<Fragment>? = null
    private var listenerList: List<ComerList>? = null
    private var artistsList: List<Artists>? = null
    private var listener: OnClickListener? = null

    fun setBannerData(list: List<Banner>?) {
        this.bannerList = list
        notifyItemChanged(0)
    }


    fun setGatherData(list: List<GatherData>?) {
        this.gatherList = list
        notifyItemChanged(1)
    }

    fun setRecommendData(list: List<Result>?) {
        this.recommendList = list
        notifyItemChanged(2)
    }

    fun setNewPageList(list: List<Fragment>?) {
        this.newPageList = list
        notifyItemChanged(3)
    }

    fun setListenerData(list: List<ComerList>?) {
        this.listenerList = list
        notifyItemChanged(5)
    }

    fun setListData(list: List<Artists>?) {
        this.artistsList = list
        notifyItemChanged(6)
    }



    fun setListener(listener: OnClickListener?) {
        this.listener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when (viewType) {
            TYPE_BANNER -> {
                val bannerBinding = DataBindingUtil.inflate<ItemFindBannerBinding>(
                    parent.context.layoutInflater,
                    R.layout.item_find_banner,
                    parent,
                    false
                )
                val bannerHolder: BannerViewHolder = BannerViewHolder(bannerBinding.root)
                return bannerHolder
            }
            TYPE_GATHER -> {
                val gatherBinding = DataBindingUtil.inflate<ItemFindGatherBinding>(
                    parent.context.layoutInflater,
                    R.layout.item_find_gather,
                    parent,
                    false
                )
                val gatherHolder: GatherViewHolder = GatherViewHolder(gatherBinding.root)
                return gatherHolder
            }
            TYPE_RECOMMEND -> {
                val recommendBinding = DataBindingUtil.inflate<ItemFindRecommendBinding>(
                    parent.context.layoutInflater,
                    R.layout.item_find_recommend,
                    parent,
                    false
                )
                val recommendHolder: RecommendViewHolder =
                    RecommendViewHolder(recommendBinding.root)
                return recommendHolder
            }
            TYPE_NEW -> {
                val newBinding = DataBindingUtil.inflate<ItemFindNewBinding>(
                    parent.context.layoutInflater,
                    R.layout.item_find_new,
                    parent,
                    false
                )
                val newHolder: NewViewHolder = NewViewHolder(newBinding.root)
                return newHolder
            }
            TYPE_GOOD-> {
                val goodBinding = DataBindingUtil.inflate<ItemFindGoodBinding>(
                    parent.context.layoutInflater,
                    R.layout.item_find_good,
                    parent,
                    false
                )
                val goodHolder: GoodViewHolder = GoodViewHolder(goodBinding.root)
                return goodHolder
            }
            TYPE_LISTENER-> {
                val listenerBinding = DataBindingUtil.inflate<ItemFindListenerBinding>(
                    parent.context.layoutInflater,
                    R.layout.item_find_listener,
                    parent,
                    false
                )
                val listenerHolder: ListenerViewHolder = ListenerViewHolder(listenerBinding.root)
                return listenerHolder
            }
//            TYPE_AD-> {
//                return bannerHolder
//            }
            else -> {
                val listBinding = DataBindingUtil.inflate<ItemFindListBinding>(
                    parent.context.layoutInflater,
                    R.layout.item_find_list,
                    parent,
                    false
                )
                val listHolder: ListViewHolder = ListViewHolder(listBinding.root)
                return listHolder
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if ((holder is BannerViewHolder)) {
            holder.setData(position)
        } else if ((holder is GatherViewHolder)) {
            holder.setData(position)
        } else if ((holder is RecommendViewHolder)) {
            holder.setData(position)
        } else if ((holder is NewViewHolder)) {
            holder.setData(position)
        } else if ((holder is GoodViewHolder)) {
            holder.setData(position)
        } else if ((holder is ListenerViewHolder)) {
            holder.setData(position)
        } else if ((holder is ListViewHolder)){
            holder.setData(position)
        }

    }


    override fun getItemCount(): Int {
//        return list?.size ?: 0
        return 9
    }


    override fun getItemViewType(position: Int): Int {
        when (position) {
            0 -> return TYPE_BANNER
            1 -> return TYPE_GATHER
            2 -> return TYPE_RECOMMEND
            3 -> return TYPE_NEW
            4 -> return TYPE_GOOD
            5 -> return TYPE_LISTENER
            6 -> return TYPE_AD
            else -> return TYPE_LIST
        }
    }

    inner class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(position: Int) {
            val bannerViewPager: BannerViewPager<Banner, BannerPagerViewHolder> =
                itemView.findViewById(R.id.banner_view)
            bannerViewPager.setHolderCreator {
                BannerPagerViewHolder()
            }.create(bannerList)
        }
    }


    inner class GatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(position: Int) {
            val rvGather: RecyclerView = itemView.findViewById<RecyclerView>(R.id.rv_gather)
            rvGather.layoutManager = GridLayoutManager(itemView.context, 5)
            rvGather.adapter = FindGatherAdapter().also {
                it.submitList(gatherList)
            }
        }
    }


    inner class RecommendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(position: Int) {
            val rvRecommend: RecyclerView = itemView.findViewById<RecyclerView>(R.id.rv_recommend)
            rvRecommend.layoutManager = GridLayoutManager(itemView.context, 3)
            rvRecommend.adapter = FindRecommendAdapter().also {
                it.submitList(recommendList)
            }
        }

    }

    inner class NewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(position: Int) {
            val pager: ViewPager2 = itemView.findViewById<ViewPager2>(R.id.pager)
            pager.adapter = MyFragmentStateAdapter(activity, newPageList!!)
            val tabLayout: TabLayout = itemView.findViewById<TabLayout>(R.id.tab_layout)
            TabLayoutMediator(tabLayout, pager) { tab, position ->
               when(position){
                   0-> tab.text = "新碟"
                   1-> tab.text = "新歌"
               }
            }.attach()

        }

    }

    inner class GoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(position: Int) {

        }
    }


    inner class ListenerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(position: Int) {
            val rvListener: RecyclerView = itemView.findViewById<RecyclerView>(R.id.rv_listener)
            rvListener.layoutManager = LinearLayoutManager(itemView.context).also {
                it.orientation = LinearLayoutManager.HORIZONTAL
            }
            rvListener.adapter = FindListenerAdapter().also {
                it.submitList(listenerList)
            }
        }
    }


    inner class AdViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(position: Int) {
            val rvArtists: RecyclerView = itemView.findViewById<RecyclerView>(R.id.rv_artists)
            rvArtists.layoutManager = LinearLayoutManager(itemView.context)
            rvArtists.adapter = FindListAdapter().also {
                it.submitList(artistsList)
            }
        }
    }


    interface OnClickListener {
        fun onItemClick(pos: Int)
    }

}