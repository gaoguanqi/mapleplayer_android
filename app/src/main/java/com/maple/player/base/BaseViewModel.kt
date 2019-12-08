package com.maple.player.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.maple.player.app.MyApplication

open class BaseViewModel(app:MyApplication) : AndroidViewModel(app) {
    private lateinit var app:MyApplication

    init {
        this.app = app
    }
}