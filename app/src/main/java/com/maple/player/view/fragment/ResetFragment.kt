package com.maple.player.view.fragment


import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.blankj.utilcode.util.BarUtils
import com.blankj.utilcode.util.KeyboardUtils
import com.maple.player.R
import com.maple.player.app.global.Constants
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentResetBinding
import com.maple.player.utils.ToastUtil
import com.maple.player.utils.UIUtils
import com.maple.player.viewmodel.ResetViewModel
import com.maple.player.viewmodel.factory.ResetModelFactory

class ResetFragment : BaseFragment<FragmentResetBinding>() {

    private val viewModel: ResetViewModel by lazy {
        ViewModelProvider(this, ResetModelFactory())
            .get(ResetViewModel::class.java)
    }

    override fun getLayoutId(): Int = R.layout.fragment_reset


    override fun bindViewModel() {
        binding.viewModel = viewModel
    }

    override fun hasNavController(): Boolean = true

    override fun initData(view: View, savedInstanceState: Bundle?) {
        BarUtils.addMarginTopEqualStatusBarHeight(view)
        BarUtils.setStatusBarColor(requireActivity(), UIUtils.getColor(R.color.white))

        viewModel.defUI.showDialog.observe(this, Observer {
            showLoading()
        })

        viewModel.defUI.dismissDialog.observe(this, Observer {
            dismissLoading()
        })

        viewModel.defUI.toastEvent.observe(this, Observer {
            ToastUtil.showToast(it)
        })

        val phone: String? = requireArguments().getString(Constants.BundleKey.EXTRA_PHONE)
        if (!TextUtils.isEmpty(phone)) {
            binding.etPhone.setText(phone)
        }
        viewModel.backEvent.observe(
            this,
            Observer { navController?.navigateUp() })

        viewModel.clearPhoneEvent.observe(this, Observer {
            binding.etPhone.text.clear()
        })
        viewModel.clearPasswordEvent.observe(this, Observer {
            binding.etPassword.text.clear()
        })

        binding.etPhone.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.hasPhone.set(!s.isNullOrEmpty())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        binding.etPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.hasPassword.set(!s.isNullOrEmpty())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        viewModel.nextEvent.observe(this, Observer {
            val bundle: Bundle = requireArguments()
            bundle.putString(Constants.BundleKey.EXTRA_PASSWORD, binding.etPassword.text.toString())
            navController?.navigate(R.id.action_resetFragment_to_verifyFragment, bundle)
        })

        KeyboardUtils.showSoftInput(binding.etPassword)
    }


}
