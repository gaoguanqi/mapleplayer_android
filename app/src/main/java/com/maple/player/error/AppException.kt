package com.maple.player.error

import java.lang.RuntimeException

class AppException:RuntimeException {
    constructor():super()
    constructor(message:String):super(message)
}