package com.maple.player.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maple.player.app.MyApplication
import com.maple.player.viewmodel.PasswordViewModel

class PasswordModelFactory : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PasswordViewModel(MyApplication.instance) as T
    }
}