package com.maple.player.view.fragment


import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.maple.player.R
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentPhoneBinding
import com.maple.player.viewmodel.PhoneViewModel
import com.maple.player.viewmodel.factory.PhoneModelFactory

class PhoneFragment : BaseFragment<FragmentPhoneBinding>() {

    private val viewModel: PhoneViewModel by lazy {
        ViewModelProvider(requireActivity(), PhoneModelFactory())
            .get(PhoneViewModel::class.java)
    }

    override fun getLayoutId(): Int = R.layout.fragment_phone


    override fun initData(view: View, savedInstanceState: Bundle?) {

    }

    override fun bindViewModel() {
        binding.viewModel = viewModel
    }


}
