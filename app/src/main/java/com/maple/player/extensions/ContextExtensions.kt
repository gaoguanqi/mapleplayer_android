package com.maple.player.extensions

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater

internal inline val Context.layoutInflater: LayoutInflater get() = LayoutInflater.from(this)