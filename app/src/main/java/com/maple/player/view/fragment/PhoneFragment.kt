package com.maple.player.view.fragment


import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.blankj.utilcode.util.BarUtils
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.app.manager.TitleBarHelper
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentPhoneBinding
import com.maple.player.utils.LogUtils
import com.maple.player.view.activity.AccountActivity
import com.maple.player.viewmodel.PhoneViewModel
import com.maple.player.viewmodel.factory.PhoneModelFactory
import com.maple.player.widget.imgloader.ImageLoader
import com.maple.player.widget.imgloader.TransType
import com.maple.player.widget.imgloader.glide.GlideImageConfig
import com.maple.player.widget.imgloader.listener.ProgressDrawable
import com.maple.player.widget.imgloader.listener.ProgressListener

class PhoneFragment : BaseFragment<FragmentPhoneBinding>() {

    private val viewModel: PhoneViewModel by lazy {
        ViewModelProvider(this, PhoneModelFactory())
            .get(PhoneViewModel::class.java)
    }

    override fun getLayoutId(): Int = R.layout.fragment_phone


    override fun initData(view: View, savedInstanceState: Bundle?) {
        BarUtils.addMarginTopEqualStatusBarHeight(view)
        BarUtils.setStatusBarColor(activity!!, ContextCompat.getColor(context!!,R.color.color_background))

        lifecycle.addObserver(TitleBarHelper(binding.includeTitle,"手机号登录",object :TitleBarHelper.TitleBarListener{
            override fun onLeftLayoutClick() {
                LogUtils.logGGQ("navigateUp")
//                navController.navigateUp()
                navController.navigate(R.id.action_phoneFragment_to_loginFragment)
            }
        }))
    }

    override fun bindViewModel() {
        binding.viewModel = viewModel
    }

}
