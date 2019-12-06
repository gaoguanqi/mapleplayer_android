package com.maple.player.app.manager

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.blankj.utilcode.util.ResourceUtils
import com.maple.player.R
import com.maple.player.utils.LogUtils
import com.maple.player.widget.view.AudioWaveView

class TitleBarHelper : LifecycleObserver {

    private var view: View

    constructor(
        view: View,
        title: String,
        listener: TitleBarListener,
        audioState: Boolean = false,
        leftIcon: Drawable = ResourceUtils.getDrawable(R.drawable.icon_back_normal)
    ) {
        this.view = view
        this.view.findViewById<TextView>(R.id.tv_title).text = title
        this.view.findViewById<ImageView>(R.id.iv_left).background = leftIcon
        this.view.findViewById<AudioWaveView>(R.id.audio_right).setPlay(audioState)
        this.view.findViewById<LinearLayout>(R.id.ll_left)
            .setOnClickListener { listener.onLeftLayoutClick() }
        this.view.findViewById<LinearLayout>(R.id.ll_right)
            .setOnClickListener { listener.onAudioLayoutClick(view.findViewById<AudioWaveView>(R.id.audio_right).getPlyState()) }
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        view.onFinishTemporaryDetach()
        LogUtils.logGGQ("onDestroy")
    }

    interface TitleBarListener {
        fun onLeftLayoutClick()
        fun onAudioLayoutClick(state: Boolean){
            LogUtils.logGGQ("onAudioLayoutClick: $state")
        }
    }
}