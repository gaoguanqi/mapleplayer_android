package com.maple.player.base

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

abstract class BaseViewActivity<VB : ViewDataBinding, VM : BaseViewModel> : BaseActivity(),
    CoroutineScope by MainScope() {

    protected val binding: VB by lazy { DataBindingUtil.setContentView(this, getLayoutId()) as VB }
    protected lateinit var viewModel: VM

    /** 获取 ViewModel */
    abstract fun providerViewModel(): Class<VM>

    abstract fun bindViewModel()


    override fun setContentLayout() {
        super.setContentLayout()
        this.binding.lifecycleOwner = this
        this.viewModel = ViewModelProviders.of(this).get(providerViewModel())
        this.bindViewModel()
    }


    override fun onDestroy() {
        super.onDestroy()
        cancel()
        this.binding.unbind()
    }

}