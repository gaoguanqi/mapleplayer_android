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
import com.maple.player.databinding.FragmentNicknameBinding
import com.maple.player.utils.ToastUtil
import com.maple.player.utils.UIUtils
import com.maple.player.view.activity.AccountActivity
import com.maple.player.viewmodel.NicknameViewModel
import com.maple.player.viewmodel.factory.NicknameModelFactory


class NicknameFragment : BaseFragment<FragmentNicknameBinding>() {

    private val viewModel: NicknameViewModel by lazy {
        ViewModelProvider(this, NicknameModelFactory())
            .get(NicknameViewModel::class.java)
    }

    override fun getLayoutId(): Int = R.layout.fragment_nickname

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

        viewModel.clearEvent.observe(this, Observer { binding.etNickname.text.clear() })

        binding.etNickname.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.hasClear.set(!s.isNullOrEmpty())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        viewModel.submitEvent.observe(this, Observer {
            val bundle: Bundle = requireArguments()
            val phone: String? = bundle.getString(Constants.BundleKey.EXTRA_PHONE)
            val password: String? = bundle.getString(Constants.BundleKey.EXTRA_PASSWORD)
            val verifyCode: String? = bundle.getString(Constants.BundleKey.EXTRA_VERIFY_CODE)
            if (TextUtils.isEmpty(phone) && TextUtils.isEmpty(password) && TextUtils.isEmpty(
                    verifyCode
                )
            ) {
                showTopMessage("error")
                return@Observer
            }

            val nicename: String = binding.etNickname.text.toString()
            if (TextUtils.isEmpty(nicename)) {
                showTopMessage("请输入昵称")
            } else {
                viewModel.onConfirmSubmit(phone!!, password!!, verifyCode!!, nicename)
            }
        })

        viewModel.homeEvent.observe(this, Observer {
            (requireActivity() as AccountActivity).startHomeActivity()
        })

        KeyboardUtils.showSoftInput(binding.etNickname)
    }


}
