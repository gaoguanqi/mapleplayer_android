package com.maple.player.view.fragment


import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.maple.player.R
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentNewMusicBinding
import com.maple.player.utils.LogUtils
import com.maple.player.view.adapter.NewMusicAdapter
import com.maple.player.viewmodel.NewMusicViewModel
import com.maple.player.viewmodel.factory.NewMusicModelFactory


class NewMusicFragment : BaseFragment<FragmentNewMusicBinding>() {

    companion object {
        fun getInstance(): NewMusicFragment {
            return NewMusicFragment()
        }
    }

    private val viewModel: NewMusicViewModel by lazy {
        ViewModelProvider(this, NewMusicModelFactory())
            .get(NewMusicViewModel::class.java)
    }


    override fun getLayoutId(): Int = R.layout.fragment_new_music

    override fun bindViewModel() {
        binding.viewModel = viewModel
    }

    override fun initData(view: View, savedInstanceState: Bundle?) {

        LogUtils.logGGQ("new — 新歌")

        binding.rvList.layoutManager = GridLayoutManager(requireContext(), 3)
        val adapter: NewMusicAdapter = NewMusicAdapter()
        binding.rvList.adapter = adapter

        viewModel.getNewMusicData()
        viewModel.newMusicData.observe(this, Observer {
            adapter.submitList(it)
        })
    }


}
