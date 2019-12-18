package com.maple.player.view.fragment


import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.maple.player.R
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentAccountBinding
import com.maple.player.viewmodel.AccountViewModel
import com.maple.player.viewmodel.factory.AccountModelFactory


class AccountFragment : BaseFragment<FragmentAccountBinding>() {


    companion object {
        fun getInstance(): AccountFragment {
            return AccountFragment()
        }
    }

    private val viewModel: AccountViewModel by lazy {
        ViewModelProvider(this, AccountModelFactory())
            .get(AccountViewModel::class.java)
    }

    override fun getLayoutId(): Int = R.layout.fragment_account

    override fun bindViewModel() {
        binding.viewModel = viewModel
    }

    override fun initData(view: View, savedInstanceState: Bundle?) {

        viewModel.bellEvent.observe(this, Observer {
            showTopMessage("-----------")
        })
    }


}
