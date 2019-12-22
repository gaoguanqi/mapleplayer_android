package com.maple.player.view.fragment


import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.maple.player.R
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentVideoListBinding
import com.maple.player.viewmodel.VideoListViewModel
import com.maple.player.viewmodel.factory.VideoListModelFactory


class VideoListFragment : BaseFragment<FragmentVideoListBinding>() {

    companion object {
        fun getInstance(): VideoListFragment {
            return VideoListFragment()
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

    }


}
