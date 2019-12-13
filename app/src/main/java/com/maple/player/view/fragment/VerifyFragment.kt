package com.maple.player.view.fragment


import android.os.Bundle
import android.view.View
import androidx.core.view.get
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.blankj.utilcode.util.BarUtils
import com.blankj.utilcode.util.KeyboardUtils
import com.maple.player.R
import com.maple.player.app.global.Constants
import com.maple.player.app.global.Constants.BundleKey.EXTRA_VERIFY_CODE
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentVerifyBinding
import com.maple.player.utils.ToastUtil
import com.maple.player.utils.UIUtils
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


        binding.verifyCodeView.setListener(object :VerifyCodeView.InputCompleteListener{
            override fun inputComplete(content: String) {
                val bundle:Bundle = requireArguments()
                bundle.putString(EXTRA_VERIFY_CODE,content)
                navController.navigate(R.id.action_verifyFragment_to_passwordFragment,bundle)
            }

            override fun invalidContent() {

            }
        })

        KeyboardUtils.showSoftInput(binding.verifyCodeView.getEditText())
    }
}
