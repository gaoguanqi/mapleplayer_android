package com.maple.player.view.fragment


import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.maple.player.R
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentAccountBinding
import com.maple.player.viewmodel.AccountViewModel
import com.maple.player.viewmodel.factory.AccountModelFactory


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

        binding.switchDark.setOnCheckedChangeListener(object :CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                viewModel.switchDarkValue.value = isChecked
            }
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
