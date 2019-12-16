package com.maple.player.view.fragment


import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.maple.player.R
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentCloudBinding
import com.maple.player.viewmodel.CloudViewModel
import com.maple.player.viewmodel.factory.CloudModelFactory


class CloudFragment : BaseFragment<FragmentCloudBinding>() {


    companion object {
        fun getInstance(): CloudFragment {
            return CloudFragment()
        }
    }

    private val viewModel: CloudViewModel by lazy {
        ViewModelProvider(
            this,
            CloudModelFactory()
        )
            .get(CloudViewModel::class.java)
    }

    override fun getLayoutId(): Int = R.layout.fragment_cloud

    override fun bindViewModel() {
        binding.viewModel = viewModel
    }

    override fun initData(view: View, savedInstanceState: Bundle?) {
    }


}
