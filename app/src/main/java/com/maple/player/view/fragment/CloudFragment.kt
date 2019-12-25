package com.maple.player.view.fragment


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import com.maple.player.R
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentCloudBinding
import com.maple.player.view.adapter.MyFragmentStateAdapter
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
        val list: List<Fragment> = listOf(
            CloudPlazaFragment.getInstance(),
            CloudActionFragment.getInstance()
        )

        binding.pager.adapter = MyFragmentStateAdapter(requireActivity(), list)
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            when (position) {
                0 -> tab.text = "广场"
                1 -> tab.text = "动态"
            }
        }.attach()
    }


}
