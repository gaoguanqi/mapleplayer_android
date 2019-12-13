package com.maple.player.view.fragment


import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.blankj.utilcode.util.BarUtils
import com.maple.player.R
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentVerifyBinding
import com.maple.player.utils.UIUtils
import com.maple.player.viewmodel.VerifyViewModel
import com.maple.player.viewmodel.factory.VerifyModelFactory


class VerifyFragment : BaseFragment<FragmentVerifyBinding>() {
    private val viewModel: VerifyViewModel by lazy {
        ViewModelProvider(this, VerifyModelFactory())
            .get(VerifyViewModel::class.java)
    }

    override fun getLayoutId(): Int = R.layout.fragment_verify

    override fun bindViewModel() {
        binding.viewModel = viewModel
    }

    override fun initData(view: View, savedInstanceState: Bundle?) {
        BarUtils.addMarginTopEqualStatusBarHeight(view)
        BarUtils.setStatusBarColor(requireActivity(), UIUtils.getColor(R.color.color_background))
    }

}
