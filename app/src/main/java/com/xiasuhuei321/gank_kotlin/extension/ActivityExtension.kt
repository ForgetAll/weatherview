package com.xiasuhuei321.gank_kotlin.extension

import android.app.Activity
import android.view.View

/**
 * Created by xiasuhuei321 on 2017/8/4.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */
inline fun <reified T : View> Activity.find(id: Int): T {
    return findViewById(id) as T
}