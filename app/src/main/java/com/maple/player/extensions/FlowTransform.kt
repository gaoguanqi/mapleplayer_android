package com.maple.player.extensions

import com.maple.player.http.BaseResult
import com.maple.player.http.ResponseThrowable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

@ExperimentalCoroutinesApi
fun <T> Flow<BaseResult<T>>.applyTransform(): Flow<T> {
    return this
        .flowOn(Dispatchers.IO)
        .map {
            if (it.isSuccessOK() && it.getData() != null) return@map it.getData()!!
            else throw ResponseThrowable(it.getCode(), it.getMessage())
        }
}