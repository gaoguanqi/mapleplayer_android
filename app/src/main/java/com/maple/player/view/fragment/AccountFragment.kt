package com.maple.player.view.fragment


import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.animation.AnimationUtils
import com.google.android.material.appbar.AppBarLayout
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentAccountBinding
import com.maple.player.db.AppDatabase
import com.maple.player.db.user.User
import com.maple.player.utils.LogUtils
import com.maple.player.utils.ToastUtil
import com.maple.player.utils.UIUtils
import com.maple.player.viewmodel.AccountViewModel
import com.maple.player.viewmodel.factory.AccountModelFactory
import com.maple.player.widget.imgloader.ImageLoader
import com.maple.player.widget.imgloader.TransType
import com.maple.player.widget.imgloader.glide.GlideImageConfig


class AccountFragment : BaseFragment<FragmentAccountBinding>() {


    companion object {
        fun getInstance(): AccountFragment {
            return AccountFragment()
        }
    }

    private val viewModel: AccountViewModel by lazy {
        ViewModelProvider(this, AccountModelFactory())
            .get(AccountViewModel::class.java)
    }

    override fun getLayoutId(): Int = R.layout.fragment_account

    override fun bindViewModel() {
        binding.viewModel = viewModel
    }

    override fun initData(view: View, savedInstanceState: Bundle?) {
        LogUtils.logGGQ("账号")


        viewModel.defUI.showDialog.observe(this, Observer {
            showLoading()
        })

        viewModel.defUI.dismissDialog.observe(this, Observer {
            dismissLoading()
        })

        viewModel.defUI.toastEvent.observe(this, Observer {
            ToastUtil.showToast(it)
        })

        viewModel.getUserDetail()
        viewModel.userDetail.observe(this, Observer {
            ImageLoader.getInstance().loadImage(
                MyApplication.instance,
                GlideImageConfig(it.profile?.avatarUrl!!, binding.ivAvatar).also { it.type = TransType.CIRCLE })
        })

        binding.appBarLayout.addOnOffsetChangedListener(object :
            AppBarLayout.OnOffsetChangedListener {
                override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
                if(verticalOffset == 0){ //展开
                    viewModel.defUI.title.set(UIUtils.getString(R.string.title_account))
                }else if(Math.abs(verticalOffset) >= binding.appBarLayout.totalScrollRange){ //折叠
                    viewModel.defUI.title.set(viewModel.userDetail.value?.profile?.nickname)
                }else{ //中间

                }
            }
        })

        binding.switchDark.setOnCheckedChangeListener(object :CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                viewModel.switchDarkValue.value = isChecked
            }
        })
        viewModel.messageEvent.observe(this, Observer {
            showTopMessage("消息")
        })
        viewModel.shopEvent.observe(this, Observer {
            showTopMessage("商城")
        })
        viewModel.showEvent.observe(this, Observer {
            showTopMessage("演出")
        })
        viewModel.theEvent.observe(this, Observer {
            showTopMessage("个性")
        })

        viewModel.bellEvent.observe(this, Observer {
            showTopMessage("1")
        })
        viewModel.orderEvent.observe(this, Observer {
            showTopMessage("2")
        })
        viewModel.createrEvent.observe(this, Observer {
            showTopMessage("3")
        })
        viewModel.settingEvent.observe(this, Observer {
            showTopMessage("4")
        })
        viewModel.timerOffEvent.observe(this, Observer {
            showTopMessage("5")
        })
        viewModel.timerClockEvent.observe(this, Observer {
            showTopMessage("6")
        })
        viewModel.freeLineEvent.observe(this, Observer {
            showTopMessage("7")
        })
        viewModel.voucherEvent.observe(this, Observer {
            showTopMessage("8")
        })
        viewModel.youngEvent.observe(this, Observer {
            showTopMessage("9")
        })
        viewModel.shareEvent.observe(this, Observer {
            showTopMessage("10")
        })
        viewModel.aboutEvent.observe(this, Observer {
            showTopMessage("11")
        })
        viewModel.logoutEvent.observe(this, Observer {
            showTopMessage("登录${viewModel.switchDarkValue.value}")
        })

    }


}
