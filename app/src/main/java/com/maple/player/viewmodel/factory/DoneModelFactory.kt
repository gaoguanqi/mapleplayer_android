package com.maple.player.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maple.player.app.MyApplication
import com.maple.player.model.repository.AccountRepository
import com.maple.player.viewmodel.DoneViewModel

class DoneModelFactory : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DoneViewModel(MyApplication.instance, AccountRepository()) as T
    }
}