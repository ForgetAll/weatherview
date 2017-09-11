package com.xiasuhuei321.gank_kotlin.customview.weather

import android.graphics.Canvas
import android.graphics.PointF
import java.util.*

/**
 * Created by xiasuhuei321 on 2017/9/5.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */
class Snow(start: PointF, end: PointF) : WeatherShape(start, end) {

    /**
     * 圆心，用户可以改变这个值
     */
    var center = calcCenter()

    /**
     * 半径
     */
    var radius = 10f

    override fun getAcceleration(): Float {
        return 0f
    }

    override fun drawWhenInUse(canvas: Canvas) {
        // 通过圆心与半径确定圆的位置及大小
        canvas.drawCircle(center.x, center.y, radius, paint)
    }

    fun calcCenter(): PointF {
        val center = PointF(0f, 0f)
        center.x = (start.x + end.x) / 2f
        center.y = (start.y + end.y) / 2f
        return center
    }

    override fun randomSpeed(random: Random): Float {
        return 0f
    }
}