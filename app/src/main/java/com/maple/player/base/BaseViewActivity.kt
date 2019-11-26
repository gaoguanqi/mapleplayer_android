package com.maple.player.base

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

abstract class BaseViewActivity<DB : ViewDataBinding, VM : BaseViewModel> : BaseActivity(),
    CoroutineScope by MainScope() {

    protected val binding: DB by lazy { DataBindingUtil.setContentView(this, getLayoutId()) as DB }
    protected lateinit var viewModel: VM


    abstract fun providerViewModel(): Class<VM>

    abstract fun bindViewModel()


    override fun setContentLayout() {
        super.setContentLayout()
        this.binding.lifecycleOwner = this
        this.viewModel = ViewModelProviders.of(this).get(providerViewModel())
    }


    override fun onDestroy() {
        super.onDestroy()
        cancel()
        this.binding.unbind()
    }

}