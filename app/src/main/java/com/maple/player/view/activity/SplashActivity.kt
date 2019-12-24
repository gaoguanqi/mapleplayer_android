package com.maple.player.view.activity

import android.content.Intent
import android.os.Bundle
import com.blankj.utilcode.util.PermissionUtils
import com.maple.player.R
import com.maple.player.app.MyApplication
import com.maple.player.base.BaseActivity
import com.maple.player.db.AppDatabase
import com.maple.player.utils.LogUtils
import com.maple.player.utils.PermissionUtil
import com.maple.player.utils.RequestPermission
import com.maple.player.widget.dialog.PermissionDialog
import com.tbruyelle.rxpermissions2.RxPermissions

class SplashActivity : BaseActivity() {

    val permissionDialog: PermissionDialog by lazy {
        PermissionDialog(
            this,
            listener = object : PermissionDialog.OnClickListener {
                override fun onCancleClick() {
                    permissionDialog.cancel()
                    this@SplashActivity.finish()
                }

                override fun onConfirmClick() {
                    permissionDialog.cancel()
                    PermissionUtils.launchAppDetailsSettings();
                }
            })
    }

    override fun getLayoutId(): Int = R.layout.activity_splash

    override fun initData(savedInstanceState: Bundle?) {
        applyPermissions()
    }

    override fun onRestart() {
        super.onRestart()
        applyPermissions()
    }

    private fun applyPermissions() {
        PermissionUtil.applyPermissions(object : RequestPermission {
            override fun onRequestPermissionSuccess() {
                startTagetActivity()
            }

            override fun onRequestPermissionFailure(permissions: List<String>) {
                showPermissionSettingsDialog(permissions)
            }

            override fun onRequestPermissionFailureWithAskNeverAgain(permissions: List<String>) {
                showPermissionSettingsDialog(permissions)
            }
        }, RxPermissions(this))
    }


    private fun startTagetActivity() {
        val userList = AppDatabase.getInstance(MyApplication.instance).userDao().getAllUser()
        for (user in userList) {
            LogUtils.logGGQ("user:${user.nickname} --- ${userList.size}")
        }
        if (userList.isNullOrEmpty()) {
            startActivity(Intent(this@SplashActivity, AccountActivity::class.java))
            this@SplashActivity.finish()
        } else {
            startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
            this@SplashActivity.finish()
        }
    }

    private fun showPermissionSettingsDialog(permissions: List<String>) {
        permissionDialog.show()
    }
}
