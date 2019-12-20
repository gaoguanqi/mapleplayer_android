package com.maple.player.extensions

import com.maple.player.app.config.Config


internal inline fun Int.isResultSuccess():Boolean{
    return Config.SUCCESS_CODE == this
}
