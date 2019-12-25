package com.maple.player.view.fragment


import android.os.Bundle
import android.view.View
import com.maple.player.R
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentCloudPlazaBinding


class CloudPlazaFragment : BaseFragment<FragmentCloudPlazaBinding>() {
    companion object {
        fun getInstance(): CloudPlazaFragment {
            return CloudPlazaFragment()
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_cloud_plaza

    override fun bindViewModel() {
    }

    override fun initData(view: View, savedInstanceState: Bundle?) {
    }


}
