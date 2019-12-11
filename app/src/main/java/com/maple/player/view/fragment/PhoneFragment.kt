package com.maple.player.view.fragment


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.TextureView
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.text.set
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.blankj.utilcode.util.BarUtils
import com.blankj.utilcode.util.KeyboardUtils
import com.blankj.utilcode.util.PhoneUtils
import com.blankj.utilcode.util.RegexUtils
import com.maple.player.R
import com.maple.player.app.global.Constants
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentPhoneBinding
import com.maple.player.utils.ToastUtil
import com.maple.player.utils.UIUtils
import com.maple.player.viewmodel.PhoneViewModel
import com.maple.player.viewmodel.factory.PhoneModelFactory

class PhoneFragment : BaseFragment<FragmentPhoneBinding>() {

    private val viewModel: PhoneViewModel by lazy {
        ViewModelProvider(this, PhoneModelFactory())
            .get(PhoneViewModel::class.java)
    }

    override fun getLayoutId(): Int = R.layout.fragment_phone


    override fun initData(view: View, savedInstanceState: Bundle?) {
        BarUtils.addMarginTopEqualStatusBarHeight(view)
        BarUtils.setStatusBarColor(activity!!, UIUtils.getColor(R.color.color_background))

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


        viewModel.clearEvent.observe(this, Observer { binding.etPhone.text.clear() })
        viewModel.nextEvent.observe(this, Observer {
            if(RegexUtils.isMobileSimple(binding.etPhone.text)){
                val bundle:Bundle = Bundle()
                bundle.putString(Constants.BundleKey.EXTRA_PHONE,binding.etPhone.text.toString())
                navController.navigate(R.id.action_phoneFragment_to_doneFragment,bundle)
            }else{
                showTopMessage("请输入正确的手机号")
            }
        })

        binding.etPhone.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                viewModel.hasNext.set(!s.isNullOrEmpty())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        KeyboardUtils.showSoftInput(binding.etPhone)
    }

    override fun bindViewModel() {
        binding.viewModel = viewModel
    }


    override fun onPause() {
        super.onPause()
        if(view != null){
            KeyboardUtils.hideSoftInput(view!!)
        }
    }

}
