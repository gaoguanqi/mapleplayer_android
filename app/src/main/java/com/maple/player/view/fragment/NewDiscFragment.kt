package com.maple.player.view.fragment


import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.maple.player.R
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentNewDiscBinding
import com.maple.player.utils.LogUtils
import com.maple.player.view.adapter.NewDiscAdapter
import com.maple.player.viewmodel.NewDiscViewModel
import com.maple.player.viewmodel.factory.NewDiscModelFactory

class NewDiscFragment : BaseFragment<FragmentNewDiscBinding>() {

    companion object {
        fun getInstance(): NewDiscFragment {
            return NewDiscFragment()
        }
    }

    private val viewModel: NewDiscViewModel by lazy {
        ViewModelProvider(this, NewDiscModelFactory())
            .get(NewDiscViewModel::class.java)
    }

    override fun getLayoutId(): Int = R.layout.fragment_new_disc

    override fun bindViewModel() {
        binding.viewModel = viewModel
    }

    override fun initData(view: View, savedInstanceState: Bundle?) {

        LogUtils.logGGQ("新碟")

        binding.rvList.layoutManager = GridLayoutManager(requireContext(),3)
        val adapter: NewDiscAdapter = NewDiscAdapter()
        binding.rvList.adapter = adapter

        viewModel.getNewDiscData()

        viewModel.newDiscData.observe(this, Observer {
            adapter.submitList(it)
        })
    }


}
