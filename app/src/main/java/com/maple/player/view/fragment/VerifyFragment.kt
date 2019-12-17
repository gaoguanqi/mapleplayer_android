package com.maple.player.view.fragment


import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.blankj.utilcode.util.BarUtils
import com.blankj.utilcode.util.KeyboardUtils
import com.blankj.utilcode.util.SPUtils
import com.blankj.utilcode.util.StringUtils
import com.maple.player.R
import com.maple.player.app.global.Constants
import com.maple.player.app.global.Constants.BundleKey.EXTRA_PASSWORD
import com.maple.player.app.global.Constants.BundleKey.EXTRA_PHONE
import com.maple.player.app.global.Constants.BundleKey.EXTRA_VERIFY_CODE
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentVerifyBinding
import com.maple.player.utils.ToastUtil
import com.maple.player.utils.UIUtils
import com.maple.player.view.activity.AccountActivity
import com.maple.player.viewmodel.VerifyViewModel
import com.maple.player.viewmodel.factory.VerifyModelFactory
import com.maple.player.widget.view.VerifyCodeView


class VerifyFragment : BaseFragment<FragmentVerifyBinding>() {
    private val viewModel: VerifyViewModel by lazy {
        ViewModelProvider(this, VerifyModelFactory())
            .get(VerifyViewModel::class.java)
    }

    override fun getLayoutId(): Int = R.layout.fragment_verify

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

        viewModel.backEvent.observe(
            this,
            Observer { navController?.navigateUp() })


        val phone: String? = requireArguments().getString(Constants.BundleKey.EXTRA_PHONE)
        if (!TextUtils.isEmpty(phone)) {
            StringUtils.length(phone) > 8.apply {
                val sphone = "${phone!!.substring(0, 3)}****${phone.substring(7, phone.length)}"
                binding.tvPhone.text = "+86\t${sphone}"
            }
            viewModel.sendVerifyCode(phone!!)
        }

        binding.verifyCodeView.setListener(object : VerifyCodeView.InputCompleteListener {
            override fun inputComplete(content: String) {

                viewModel.checkVerifyCode(phone!!, content)
            }

            override fun invalidContent() {

            }
        })

        viewModel.nextEvent.observe(this, Observer {

            val accountActivity: AccountActivity = (requireActivity() as AccountActivity)
            val homeAction: Boolean? = accountActivity.homeAction.get()

            homeAction?.let {
                val bundle: Bundle = requireArguments()
                if (it) {
                    //直接登陆
                    ToastUtil.showTipToast("直接登录")
                    val password: String? = bundle.getString(EXTRA_PASSWORD)

                    viewModel.onPhoneLogin(phone!!, password!!)
                } else {
                    bundle.putString(EXTRA_VERIFY_CODE, viewModel.verifyCode.value?.verifyCode)
                    bundle.putString(EXTRA_PHONE, phone)
                    navController?.navigate(R.id.action_verifyFragment_to_passwordFragment, bundle)
                }
            }
        })

        viewModel.homeEvent.observe(this, Observer {
            SPUtils.getInstance().put(
                Constants.SaveInfoKey.KEY_LOGIN_TAG,
                Constants.SaveInfoKey.VALUE_LOGIN_TAG_LOGIN
            )
            val accountActivity: AccountActivity = (requireActivity() as AccountActivity)
            accountActivity.homeAction.set(false)
            accountActivity.startHomeActivity()
        })

        KeyboardUtils.showSoftInput(binding.verifyCodeView.getEditText())
    }

    override fun onStop() {
        super.onStop()
        binding.verifyCodeView.initContent()
    }
}
