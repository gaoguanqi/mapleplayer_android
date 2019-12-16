package com.maple.player.base

import androidx.databinding.ObservableField
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maple.player.app.manager.SingleLiveEvent
import com.maple.player.http.ExceptionHandle
import com.maple.player.http.ResponseThrowable
import kotlinx.coroutines.*

open class BaseViewModel : ViewModel(), LifecycleObserver {
    val defUI: UIChange by lazy { UIChange() }

    /**
     * 所有网络请求都在 viewModelScope 域中启动，当页面销毁时会自动
     * 调用ViewModel的  #onCleared 方法取消所有协程
     */
    fun launchUI(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch { block() }
    }


    /**
     *  不过滤请求结果
     * @param block 请求体
     * @param error 失败回调
     * @param complete  完成回调（无论成功失败都会调用）
     * @param isShowDialog 是否显示加载框
     */
    fun launch(
        block: suspend CoroutineScope.() -> Unit,
        error: suspend CoroutineScope.(ResponseThrowable) -> Unit = {},
        complete: suspend CoroutineScope.() -> Unit = {},
        isShowDialog: Boolean = true
    ) {
        if (isShowDialog) defUI.showDialog.call()
        launchUI {
            handleException(
                withContext(Dispatchers.IO)
                { block },
                { error(it) },
                {
                    defUI.dismissDialog.call()
                    complete()
                },
                true
            )
        }
    }


    /**
     * 异常统一处理
     */
    private suspend fun handleException(
        block: suspend CoroutineScope.() -> Unit,
        error: suspend CoroutineScope.(ResponseThrowable) -> Unit,
        complete: suspend CoroutineScope.() -> Unit,
        isHandlerError: Boolean = false
    ) {
        coroutineScope {
            try {
                block()
            } catch (e: Throwable) {
                val err = ExceptionHandle.handleException(e)
                if (!isHandlerError) defUI.toastEvent.postValue("${err.code}:${err.errMsg}")
                else error(err)
            } finally {
                complete()
            }
        }
    }

    /**
     * UI事件
     */
    inner class UIChange {
        val showDialog by lazy { SingleLiveEvent<String>() }
        val dismissDialog by lazy { SingleLiveEvent<Any>() }
        val toastEvent by lazy { SingleLiveEvent<String>() }
        val title by lazy { ObservableField<String>() }

    }
}