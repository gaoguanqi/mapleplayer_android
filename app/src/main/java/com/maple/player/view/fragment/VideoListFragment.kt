package com.maple.player.view.fragment


import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.maple.player.R
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentVideoListBinding
import com.maple.player.model.entity.VideoListDatas
import com.maple.player.utils.UIUtils
import com.maple.player.view.adapter.VideoListAdapter
import com.maple.player.viewmodel.VideoListViewModel
import com.maple.player.viewmodel.factory.VideoListModelFactory
import com.maple.player.widget.decoration.SimpleItemDecoration
import com.maple.playerlibrary.player.VideoPlayer
import com.shuyu.gsyvideoplayer.GSYVideoManager
import com.shuyu.gsyvideoplayer.utils.OrientationUtils


class VideoListFragment(val videoId: String) : BaseFragment<FragmentVideoListBinding>() {

    companion object {
        fun getInstance(videoId: String): VideoListFragment {
            return VideoListFragment(videoId)
        }
    }

    private var orientationUtils: OrientationUtils? = null


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
        binding.rvVideo.addItemDecoration(SimpleItemDecoration(requireActivity()))
        val adapter: VideoListAdapter = VideoListAdapter()
        adapter.setListener(object : VideoListAdapter.OnClickListener {
            override fun onItemClick(pos: Int, data: VideoListDatas, player: VideoPlayer) {

                    }

            override fun onItemFullscreenClick(
                pos: Int, data: VideoListDatas, player: VideoPlayer
            ) {
                orientationUtils = OrientationUtils(requireParentFragment().activity, player)
                //直接横屏
                orientationUtils?.resolveByClick();
            }
        })
        binding.rvVideo.adapter = adapter
        viewModel.getVideoList(videoId)
        binding.refreshVideo.setOnRefreshListener(object : SwipeRefreshLayout.OnRefreshListener {
            override fun onRefresh() {
                viewModel.refreshVideoList(videoId)
            }
        })

        viewModel.videoListData.observe(this, Observer {
            adapter.submitList(it)
        })

        viewModel.refreshListData.observe(this, Observer {
            adapter.updataList(it)
            binding.refreshVideo.isRefreshing = false
        })
    }

    private fun onBackPressed(): Boolean {
        return GSYVideoManager.backFromWindowFull(requireContext())
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == ActivityInfo.SCREEN_ORIENTATION_USER) {

        } else {

        }
    }

}
