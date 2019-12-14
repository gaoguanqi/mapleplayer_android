package com.maple.player.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maple.player.app.MyApplication
import com.maple.player.viewmodel.NicknameViewModel
import com.maple.player.viewmodel.PasswordViewModel

class NicknameModelFactory : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NicknameViewModel(MyApplication.instance) as T
    }
}