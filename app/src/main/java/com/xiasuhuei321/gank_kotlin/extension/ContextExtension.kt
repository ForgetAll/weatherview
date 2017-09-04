package com.xiasuhuei321.gank_kotlin.extension

import android.content.Context
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
