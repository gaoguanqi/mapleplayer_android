package com.maple.player.view.fragment


import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.maple.player.R
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentMineBinding
import com.maple.player.viewmodel.MineViewModel
import com.maple.player.viewmodel.factory.MineModelFactory


class MineFragment : BaseFragment<FragmentMineBinding>() {


    companion object {
        fun getInstance(): MineFragment {
            return MineFragment()
        }
    }

    private val viewModel: MineViewModel by lazy {
        ViewModelProvider(this, MineModelFactory())
            .get(MineViewModel::class.java)
    }

    override fun getLayoutId(): Int = R.layout.fragment_mine

    override fun bindViewModel() {
        binding.viewModel = viewModel
    }

    override fun initData(view: View, savedInstanceState: Bundle?) {
    }


}
