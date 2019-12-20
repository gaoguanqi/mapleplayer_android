package com.maple.player.view.fragment


import android.os.Bundle
import android.view.View
import com.maple.player.R
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentNewDiscBinding

class NewDiscFragment : BaseFragment<FragmentNewDiscBinding>() {

    companion object {
        fun getInstance(): NewDiscFragment {
            return NewDiscFragment()
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_new_disc

    override fun bindViewModel() {
    }

    override fun initData(view: View, savedInstanceState: Bundle?) {
    }


}
