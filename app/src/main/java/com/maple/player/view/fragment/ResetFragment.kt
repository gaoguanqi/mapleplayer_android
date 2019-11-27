package com.maple.player.view.fragment


import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.maple.player.R
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentResetBinding
import com.maple.player.viewmodel.ResetViewModel
import com.maple.player.viewmodel.factory.ResetModelFactory

class ResetFragment : BaseFragment<FragmentResetBinding>() {

    private val viewModel: ResetViewModel by lazy {
        ViewModelProvider(requireActivity(), ResetModelFactory())
            .get(ResetViewModel::class.java)
    }

    override fun getLayoutId(): Int = R.layout.fragment_reset


    override fun bindViewModel() {
        binding.viewModel = viewModel
    }

    override fun initData(view: View, savedInstanceState: Bundle?) {

    }


}
