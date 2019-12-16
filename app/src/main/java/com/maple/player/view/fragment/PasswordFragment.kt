package com.maple.player.view.fragment


import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.blankj.utilcode.util.BarUtils
import com.maple.player.R
import com.maple.player.app.global.Constants
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

    override fun hasNavController(): Boolean = true

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
            Observer { navController?.navigateUp() })

        viewModel.clearEvent.observe(this, Observer { binding.etPassword.text.clear() })

        binding.etPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.hasNext.set(!s.isNullOrEmpty())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })


        viewModel.nextEvent.observe(this, Observer {
            val password: String = binding.etPassword.text.toString()
            if (TextUtils.isEmpty(password)) {
                showTopMessage("请输入密码")
            } else {
                val bundle: Bundle = requireArguments()
                bundle.putString(Constants.BundleKey.EXTRA_PASSWORD, password)
                navController?.navigate(R.id.action_passwordFragment_to_nicknameFragment, bundle)
            }
        })
    }


}
