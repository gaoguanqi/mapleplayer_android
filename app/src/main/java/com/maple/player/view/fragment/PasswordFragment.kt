package com.maple.player.view.fragment


import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.blankj.utilcode.util.BarUtils
import com.maple.player.R
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentPasswordBinding
import com.maple.player.utils.ToastUtil
import com.maple.player.utils.UIUtils
import com.maple.player.viewmodel.PasswordViewModel
import com.maple.player.viewmodel.factory.PasswordModelFactory


class PasswordFragment : BaseFragment<FragmentPasswordBinding>() {

    private val viewModel: PasswordViewModel by lazy {
        ViewModelProvider(this, PasswordModelFactory())
            .get(PasswordViewModel::class.java)
    }

    override fun getLayoutId(): Int = R.layout.fragment_password

    override fun bindViewModel() {
        binding.viewModel = viewModel
    }

    override fun initData(view: View, savedInstanceState: Bundle?) {
        BarUtils.addMarginTopEqualStatusBarHeight(view)
        BarUtils.setStatusBarColor(requireActivity(), UIUtils.getColor(R.color.color_background))

        viewModel.defUI.showDialog.observe(this, Observer {
            showLoading()
        })

        viewModel.defUI.dismissDialog.observe(this, Observer {
            dismissLoading()
        })

        viewModel.defUI.toastEvent.observe(this, Observer {
            ToastUtil.showToast(it)
        })

        viewModel.backEvent.observe(
            this,
            Observer { navController.navigateUp() })

        viewModel.clearEvent.observe(this, Observer { binding.etPassword.text.clear() })
    }


}
