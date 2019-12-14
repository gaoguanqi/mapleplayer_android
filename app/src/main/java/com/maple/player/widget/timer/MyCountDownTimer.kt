package com.maple.player.widget.timer

import android.os.CountDownTimer

class MyCountDownTimer(
    millisInFuture: Long,
    val countDownInterval: Long,
    val listener: MyCountDownTimerListener
) : CountDownTimer(millisInFuture, countDownInterval) {

    init {
        start()
        listener.onStart()
    }

    override fun onTick(millisUntilFinished: Long) {
        listener.onTick(millisUntilFinished/countDownInterval)
    }


    override fun onFinish() {
        listener.onFinish()
    }
}