package com.maple.player.view.fragment


import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.maple.player.R
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentFindBinding
import com.maple.player.viewmodel.FindViewModel
import com.maple.player.viewmodel.factory.FindModelFactory

class FindFragment : BaseFragment<FragmentFindBinding>() {

    companion object {
        fun getInstance(): FindFragment {
            return FindFragment()
        }
    }

    private val viewModel: FindViewModel by lazy {
        ViewModelProvider(this, FindModelFactory())
            .get(FindViewModel::class.java)
    }


    override fun getLayoutId(): Int = R.layout.fragment_find

    override fun bindViewModel() {
        binding.viewModel = viewModel
    }

    override fun initData(view: View, savedInstanceState: Bundle?) {
    }


}
