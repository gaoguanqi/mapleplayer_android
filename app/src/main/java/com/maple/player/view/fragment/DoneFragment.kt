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
import com.blankj.utilcode.util.RegexUtils
import com.maple.player.R
import com.maple.player.app.global.Constants
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentDoneBinding
import com.maple.player.utils.ToastUtil
import com.maple.player.utils.UIUtils
import com.maple.player.view.activity.AccountActivity
import com.maple.player.viewmodel.DoneViewModel
import com.maple.player.viewmodel.factory.DoneModelFactory


class DoneFragment : BaseFragment<FragmentDoneBinding>() {

    private val viewModel: DoneViewModel by lazy {
        ViewModelProvider(this, DoneModelFactory())
            .get(DoneViewModel::class.java)
    }

    override fun getLayoutId(): Int = R.layout.fragment_done

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
        viewModel.resetEvent.observe(this, Observer {
            navController.navigate(R.id.action_doneFragment_to_resetFragment,arguments)
        })


        viewModel.doneEvent.observe(this, Observer {
            if(TextUtils.isEmpty(binding.etPassword.text)){
                showTopMessage("请输入密码")
            }else{
                val phone:String = requireArguments().getString(Constants.BundleKey.EXTRA_PHONE)!!
                val password:String = binding.etPassword.text.toString()
                viewModel.onPhoneLogin(phone,password)
            }
        })

        binding.etPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.hasDone.set(!s.isNullOrEmpty())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        viewModel.homeEvent.observe(this, Observer {
            (requireActivity() as AccountActivity).startHomeActivity()
        })

        KeyboardUtils.showSoftInput(binding.etPassword)
    }


}
