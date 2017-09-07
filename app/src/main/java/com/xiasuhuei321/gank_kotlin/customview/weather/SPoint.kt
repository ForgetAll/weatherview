package com.xiasuhuei321.gank_kotlin.customview.weather

import android.graphics.Point

/**
 * Created by xiasuhuei321 on 2017/9/5.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 *
 * desc:带有状态标识的Point类
 */
class SPoint(x: Int, y: Int) : Point(x, y) {
    var canUse: Boolean = true

    /**
     * 不是回收内存，而是打上可复用标识
     */
    fun recycle() {
        this.canUse = true
    }
}