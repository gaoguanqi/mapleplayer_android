package com.maple.player.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.maple.player.app.MyApplication

abstract class BaseViewModel(app:MyApplication) : AndroidViewModel(app) {

}