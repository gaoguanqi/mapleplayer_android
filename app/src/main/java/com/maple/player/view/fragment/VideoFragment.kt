package com.maple.player.view.fragment


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import com.maple.player.R
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentVideoBinding
import com.maple.player.utils.ToastUtil
import com.maple.player.view.adapter.MyFragmentStateAdapter
import com.maple.player.viewmodel.VideoViewModel
import com.maple.player.viewmodel.factory.VideoModelFactory

class VideoFragment : BaseFragment<FragmentVideoBinding>() {


    companion object {
        fun getInstance(): VideoFragment {
            return VideoFragment()
        }
    }

    private val viewModel: VideoViewModel by lazy {
        ViewModelProvider(this, VideoModelFactory())
            .get(VideoViewModel::class.java)
    }

    override fun getLayoutId(): Int = R.layout.fragment_video

    override fun bindViewModel() {
        binding.viewModel = viewModel
    }

    override fun initData(view: View, savedInstanceState: Bundle?) {

        viewModel.defUI.showDialog.observe(this, Observer {
            showLoading()
        })

        viewModel.defUI.dismissDialog.observe(this, Observer {
            dismissLoading()
        })

        viewModel.defUI.toastEvent.observe(this, Observer {
            ToastUtil.showToast(it)
        })

        viewModel.getVideoGroupData()
        viewModel.videoTabData.observe(this, Observer {

            val listFragment: MutableList<Fragment> = mutableListOf()
            val listTab: MutableList<String> = mutableListOf()
            it.forEach {
                listTab.add(it.name!!)
                listFragment.add(VideoListFragment.getInstance())
            }

            binding.pager.adapter = MyFragmentStateAdapter(requireActivity(), listFragment)
            TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
                tab.text = listTab.get(position)
            }.attach()

        })
    }


}
