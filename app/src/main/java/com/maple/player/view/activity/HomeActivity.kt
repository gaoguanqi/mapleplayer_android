package com.maple.player.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import com.blankj.utilcode.util.BarUtils
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.base.BaseActivity
import com.maple.player.db.AppDatabase
import com.maple.player.db.user.Test
import com.maple.player.db.user.User
import com.maple.player.utils.ToastUtil
import com.maple.player.utils.UIUtils
import kotlinx.android.synthetic.main.activity_home.*
import okhttp3.internal.userAgent

class HomeActivity : BaseActivity() {


    private var lastBackPressedMillis:Long = 0


    override fun getLayoutId(): Int = R.layout.activity_home

    override fun initData(savedInstanceState: Bundle?) {
        BarUtils.addMarginTopEqualStatusBarHeight(toolbar)
        BarUtils.setStatusBarColor(this, UIUtils.getColor(R.color.white))




    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            if(lastBackPressedMillis + 2000 > System.currentTimeMillis()){
                //moveTaskToBack(true)
                this@HomeActivity.finish()
            }else{
                lastBackPressedMillis = System.currentTimeMillis()
                ToastUtil.showToast("再按一次退出程序")
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
