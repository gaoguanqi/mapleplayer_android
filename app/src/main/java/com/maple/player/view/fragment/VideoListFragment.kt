package com.maple.player.view.fragment


import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.maple.player.R
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentVideoListBinding
import com.maple.player.utils.UIUtils
import com.maple.player.view.adapter.VideoListAdapter
import com.maple.player.viewmodel.VideoListViewModel
import com.maple.player.viewmodel.factory.VideoListModelFactory


class VideoListFragment(val videoId: String) : BaseFragment<FragmentVideoListBinding>() {

    companion object {
        fun getInstance(videoId: String): VideoListFragment {
            return VideoListFragment(videoId)
        }
    }


    private val viewModel: VideoListViewModel by lazy {
        ViewModelProvider(this, VideoListModelFactory())
            .get(VideoListViewModel::class.java)
    }

    override fun getLayoutId(): Int = R.layout.fragment_video_list

    override fun bindViewModel() {
        binding.viewModel = viewModel
    }

    override fun initData(view: View, savedInstanceState: Bundle?) {

        binding.refreshVideo.setColorSchemeColors(UIUtils.getColor(R.color.colorPrimary))
        binding.rvVideo.layoutManager = LinearLayoutManager(requireContext())

        val adapter: VideoListAdapter = VideoListAdapter()
        binding.rvVideo.adapter = adapter

        viewModel.getVideoList(videoId)
        viewModel.videoListData.observe(this, Observer {
            adapter.submitList(it)
        })
    }


}
