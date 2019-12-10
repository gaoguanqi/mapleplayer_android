package com.maple.player.view.fragment


import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.maple.player.R
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentCheckBinding
import com.maple.player.viewmodel.CheckViewModel
import com.maple.player.viewmodel.factory.CheckModelFactory


class CheckFragment : BaseFragment<FragmentCheckBinding>() {

    private val viewModel: CheckViewModel by lazy {
        ViewModelProvider(this, CheckModelFactory())
            .get(CheckViewModel::class.java)
    }

    override fun getLayoutId(): Int = R.layout.fragment_check

    override fun bindViewModel() {
        binding.viewModel = viewModel
    }

    override fun initData(view: View, savedInstanceState: Bundle?) {
    }


}
