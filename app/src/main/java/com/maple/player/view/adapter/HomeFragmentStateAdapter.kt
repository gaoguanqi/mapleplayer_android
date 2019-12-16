package com.maple.player.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class HomeFragmentStateAdapter(activity: FragmentActivity,val list:List<Fragment>) :
    FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
       return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return list.get(position)
    }

}