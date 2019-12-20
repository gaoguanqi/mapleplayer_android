package com.maple.player.view.fragment


import android.os.Bundle
import android.view.View
import com.maple.player.R
import com.maple.player.base.BaseFragment
import com.maple.player.databinding.FragmentNewMusicBinding


class NewMusicFragment : BaseFragment<FragmentNewMusicBinding>() {

    companion object {
        fun getInstance(): NewMusicFragment {
            return NewMusicFragment()
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_new_music

    override fun bindViewModel() {
    }

    override fun initData(view: View, savedInstanceState: Bundle?) {
    }


}
