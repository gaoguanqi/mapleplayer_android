package com.maple.player.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

abstract class BaseFragment<VB : ViewDataBinding> : Fragment(),
    CoroutineScope by MainScope(), IView {

    protected lateinit var binding: VB


    protected lateinit var navController: NavController


    abstract fun getLayoutId(): Int

    abstract fun bindViewModel()

    abstract fun initData(view:View,savedInstanceState: Bundle?): Unit

//    fun <T : ViewModel> getViewModel(clazz: Class<T>): T = ViewModelProviders.of(this).get(clazz)
//
//    fun <T : ViewModel> getSharedViewModel(clazz: Class<T>): T = ViewModelProviders.of(requireActivity()).get(clazz)


    private var isFirst:Boolean = true


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        this.navController = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.binding.lifecycleOwner = this
        this.bindViewModel()
        this.initData(view,savedInstanceState)
        this.onVisible()
    }


    override fun onResume() {
        super.onResume()
        this.onVisible()
    }

    private fun onVisible() {
        if (lifecycle.currentState == Lifecycle.State.STARTED && this.isFirst) {
            this.isFirst = false
            lazyLoadData()
        }
    }

    open fun lazyLoadData() {}




    override fun onDestroy() {
        super.onDestroy()
        cancel()
        this.binding.unbind()
    }

}