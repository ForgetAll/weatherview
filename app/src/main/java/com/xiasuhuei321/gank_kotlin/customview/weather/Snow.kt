package com.xiasuhuei321.gank_kotlin.customview.weather

import android.graphics.Canvas
import android.graphics.PointF

/**
 * Created by xiasuhuei321 on 2017/9/5.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */
class Snow(start: PointF, end: PointF) : WeatherShape(start, end) {
    override fun getAcceleration(): Float {
        return 0f
    }

    override fun draw(canvas: Canvas) {
    }

    override fun randomPre(): Long {
        return 1
    }

    override fun initStyle() {
    }
}