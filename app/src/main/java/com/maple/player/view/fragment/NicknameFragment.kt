package com.maple.player.view.fragment


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.blankj.utilcode.util.BarUtils
import com.blankj.utilcode.util.KeyboardUtils

import com.maple.player.R
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentNicknameBinding
import com.maple.player.utils.ToastUtil
import com.maple.player.utils.UIUtils
import com.maple.player.viewmodel.NicknameViewModel
import com.maple.player.viewmodel.PasswordViewModel
import com.maple.player.viewmodel.factory.NicknameModelFactory
import com.maple.player.viewmodel.factory.PasswordModelFactory


class NicknameFragment : BaseFragment<FragmentNicknameBinding>() {

    private val viewModel: NicknameViewModel by lazy {
        ViewModelProvider(this, NicknameModelFactory())
            .get(NicknameViewModel::class.java)
    }

    override fun getLayoutId(): Int = R.layout.fragment_nickname

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

        viewModel.clearEvent.observe(this, Observer { binding.etNickname.text.clear() })

        binding.etNickname.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.hasClear.set(!s.isNullOrEmpty())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        viewModel.submitEvent.observe(this, Observer {
            showTopMessage("11111")
        })

        KeyboardUtils.showSoftInput(binding.etNickname)
    }


}
