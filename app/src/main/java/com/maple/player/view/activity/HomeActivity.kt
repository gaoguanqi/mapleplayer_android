package com.maple.player.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.blankj.utilcode.util.BarUtils
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.app.global.Constants
import com.maple.player.base.BaseViewActivity
import com.maple.player.databinding.ActivityHomeBinding
import com.maple.player.db.AppDatabase
import com.maple.player.utils.ToastUtil
import com.maple.player.utils.UIUtils
import com.maple.player.view.adapter.MyFragmentStateAdapter
import com.maple.player.view.fragment.*
import com.maple.player.viewmodel.HomeViewModel

class HomeActivity : BaseViewActivity<ActivityHomeBinding, HomeViewModel>() {


    private var lastBackPressedMillis: Long = 0


    override fun getLayoutId(): Int = R.layout.activity_home

    override fun providerViewModel(): Class<HomeViewModel> = HomeViewModel::class.java


    override fun bindViewModel() {
        binding.viewModel = viewModel
    }


    override fun initData(savedInstanceState: Bundle?) {
        BarUtils.addMarginTopEqualStatusBarHeight(binding.pager)
        BarUtils.setStatusBarColor(this, UIUtils.getColor(R.color.white))


        val list: List<Fragment> = listOf(
            FindFragment.getInstance(),
            VideoFragment.getInstance(),
            MineFragment.getInstance(),
            CloudFragment.getInstance(),
            AccountFragment.getInstance()
        )


        binding.pager.isUserInputEnabled = false
        val adapter: MyFragmentStateAdapter = MyFragmentStateAdapter(this, list)
        binding.pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.pager.adapter = adapter
        binding.pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.bnav.menu.getItem(position).isChecked = true
            }
        })
        binding.bnav.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId){
                    R.id.item_nav_find ->{
                        binding.pager.currentItem = 0
                    }
                    R.id.item_nav_video ->{
                        binding.pager.currentItem = 1
                    }
                    R.id.item_nav_mine ->{

                        AppDatabase.getInstance(MyApplication.instance).userDao().getAllUser().let {
                            if(it.isNullOrEmpty()){
                                startAccountActivity()
                            }else{
                                binding.pager.currentItem = 2
                            }
                        }
                    }
                    R.id.item_nav_cloud ->{
                        binding.pager.currentItem = 3
                    }
                    R.id.item_nav_account ->{
                        AppDatabase.getInstance(MyApplication.instance).userDao().getAllUser().let {
                            if(it.isNullOrEmpty()){
                                startAccountActivity()
                            }else{
                                binding.pager.currentItem = 4
                            }
                        }
                    }
                }
                return false
            }
        })
    }

    fun startAccountActivity(){
        startActivity(Intent(this@HomeActivity,AccountActivity::class.java).putExtra(Constants.BundleKey.EXTRA_TASTE,true))
        this@HomeActivity.finish()
    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (lastBackPressedMillis + 2000 > System.currentTimeMillis()) {
                //moveTaskToBack(true)
                this@HomeActivity.finish()
            } else {
                lastBackPressedMillis = System.currentTimeMillis()
                ToastUtil.showToast("再按一次退出程序")
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }


}
