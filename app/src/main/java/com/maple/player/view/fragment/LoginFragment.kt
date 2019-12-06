package com.maple.player.view.fragment


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.BarUtils
import com.blankj.utilcode.util.ResourceUtils
import com.blankj.utilcode.util.SPUtils
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.app.global.Constants
import com.maple.player.app.global.Constants.SaveInfoKey.KEY_LOGIN_TAG
import com.maple.player.app.global.Constants.SaveInfoKey.VALUE_LOGIN_TAG_LOGIN
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentLoginBinding
import com.maple.player.model.AutoEntity
import com.maple.player.utils.UIUtils
import com.maple.player.view.activity.HomeActivity
import com.maple.player.view.adapter.LoginAutoAdapter
import com.maple.player.viewmodel.LoginViewModel
import com.maple.player.viewmodel.factory.LoginModelFactory


class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this, LoginModelFactory())
            .get(LoginViewModel::class.java)
    }

    override fun getLayoutId(): Int = R.layout.fragment_login

    override fun bindViewModel() {
        binding.viewModel = viewModel
    }

    override fun initData(view: View, savedInstanceState: Bundle?) {
        BarUtils.addMarginTopEqualStatusBarHeight(view)
        BarUtils.setStatusBarColor(activity!!, UIUtils.getColor(R.color.colorPrimary))

        binding.rvAuto.layoutManager = LinearLayoutManager(this.context).also { it.orientation = LinearLayoutManager.HORIZONTAL }

        binding.rvAuto.adapter = LoginAutoAdapter().also {
            it.setData(viewModel.autoList.get())
            it.setListener(object :LoginAutoAdapter.OnClickListener{
                override fun onItemClick(pos: Int) {
                    viewModel.onAuto(pos)
                }
            })
        }

        binding.cboxAgree.setOnCheckedChangeListener { _, isChecked ->
            viewModel.isAgree.set(
                isChecked
            )
        }

        viewModel.loginEvent.observe(
            this,
            Observer<Boolean> {
                navController.navigate(R.id.action_loginFragment_to_phoneFragment)
                SPUtils.getInstance().put(KEY_LOGIN_TAG,VALUE_LOGIN_TAG_LOGIN)
            })

        viewModel.tasteEvent.observe(
            this,
            Observer<Boolean> {
                startActivity(Intent(this.activity,HomeActivity::class.java))
                this.activity?.finish()
            })

        viewModel.shakeEvent.observe(
            this,
            Observer<Boolean> {
                val anim:Animation = AnimationUtils.loadAnimation(MyApplication.instance, R.anim.shake_anim)
                binding.llAgree.startAnimation(anim)
            })
    }
}
