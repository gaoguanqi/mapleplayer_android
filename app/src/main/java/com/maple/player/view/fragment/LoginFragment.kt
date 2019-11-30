package com.maple.player.view.fragment


import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.maple.player.R
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentLoginBinding
import com.maple.player.viewmodel.LoginViewModel
import com.maple.player.viewmodel.factory.LoginModelFactory


class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(requireActivity(), LoginModelFactory())
            .get(LoginViewModel::class.java)
    }

    override fun getLayoutId(): Int = R.layout.fragment_login

    override fun bindViewModel() {
        binding.viewModel = viewModel
    }

    override fun initData(view: View, savedInstanceState: Bundle?) {
        navController.navigate(R.id.action_loginFragment_to_phoneFragment)

    }



}
