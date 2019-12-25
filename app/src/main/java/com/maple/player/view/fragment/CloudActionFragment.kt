package com.maple.player.view.fragment


import android.os.Bundle
import android.view.View
import com.maple.player.R
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentCloudActionBinding


class CloudActionFragment : BaseFragment<FragmentCloudActionBinding>() {
    companion object {
        fun getInstance(): CloudActionFragment {
            return CloudActionFragment()
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_cloud_action

    override fun bindViewModel() {
    }

    override fun initData(view: View, savedInstanceState: Bundle?) {
    }


}
