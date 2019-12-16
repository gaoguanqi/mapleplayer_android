package com.maple.player.view.fragment


import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.maple.player.R
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentVideoBinding
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
    }


}
