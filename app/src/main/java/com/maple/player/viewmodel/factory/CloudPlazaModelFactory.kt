package com.maple.player.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maple.player.viewmodel.AccountViewModel
import com.maple.player.viewmodel.CloudPlazaViewModel

class CloudPlazaModelFactory : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CloudPlazaViewModel() as T
    }
}