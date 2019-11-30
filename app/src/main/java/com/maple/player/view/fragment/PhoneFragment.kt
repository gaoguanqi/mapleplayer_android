package com.maple.player.view.fragment


import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentPhoneBinding
import com.maple.player.utils.LogUtils
import com.maple.player.viewmodel.PhoneViewModel
import com.maple.player.viewmodel.factory.PhoneModelFactory
import com.maple.player.widget.imgloader.ImageLoader
import com.maple.player.widget.imgloader.TransType
import com.maple.player.widget.imgloader.glide.GlideImageConfig
import com.maple.player.widget.imgloader.listener.ProgressListener

class PhoneFragment : BaseFragment<FragmentPhoneBinding>() {

    private val viewModel: PhoneViewModel by lazy {
        ViewModelProvider(requireActivity(), PhoneModelFactory())
            .get(PhoneViewModel::class.java)
    }

    override fun getLayoutId(): Int = R.layout.fragment_phone


    override fun initData(view: View, savedInstanceState: Bundle?) {

        val url = "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3608155120,1630233151&fm=26&gp=0.jpg"
        ImageLoader.getInstance().loadImage(MyApplication.instance,
            GlideImageConfig(url,binding.image).also {
                it.type = TransType.NORMAL
                it.progressListener = object :ProgressListener{
                    override fun onLoadProgress(isDone: Boolean, progress: Int) {
                        LogUtils.logGGQ("onLoadProgress-->>> isDone:${isDone}--progress:${progress.toString()}")
                    }

                    override fun onLoadFailed() {
                        LogUtils.logGGQ("onLoadFailed")
                    }

                }
            })

    }

    override fun bindViewModel() {
        binding.viewModel = viewModel
    }


}
