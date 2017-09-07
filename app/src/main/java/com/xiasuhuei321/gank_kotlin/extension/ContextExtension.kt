package com.xiasuhuei321.gank_kotlin.extension

import android.content.Context
import android.view.WindowManager
import android.widget.Toast

/**
 * Created by xiasuhuei321 on 2017/8/4.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */
fun Context.shortToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Context.longToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}

var width = 0

fun Context.getScreenWidth(): Int {
    if (width == 0) {
        val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        width = windowManager.defaultDisplay.width
    }
    return width
}

var height = 0

fun Context.getScreenHeight(): Int {
    if (height == 0) {
        val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        height = windowManager.defaultDisplay.height
    }
    return height
}