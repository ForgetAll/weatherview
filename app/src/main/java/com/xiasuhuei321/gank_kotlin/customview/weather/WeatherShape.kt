package com.xiasuhuei321.gank_kotlin.customview.weather

import android.graphics.Canvas
import android.graphics.PointF

/**
 * Created by xiasuhuei321 on 2017/9/5.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */
abstract class WeatherShape(val start: PointF, val end: PointF) {
    open var TAG = "WeatherShape"

    var isInUse = false

    var isRandom = false

    var speed = 0.05f

    abstract var time: Long

    /**
     * 根据自己的规则计算加速度
     */
    abstract fun getAcceleration(): Float

    /**
     * 绘制自身，具体实现交给子类去实现（可以drawLine，drawBitmap等）
     */
    abstract fun draw(canvas: Canvas)

    abstract fun randomPre(): Long

    abstract fun initStyle()
}