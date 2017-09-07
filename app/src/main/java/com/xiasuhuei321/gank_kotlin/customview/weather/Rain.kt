package com.xiasuhuei321.gank_kotlin.customview.weather

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.xiasuhuei321.gank_kotlin.context
import com.xiasuhuei321.gank_kotlin.extension.LogUtil
import com.xiasuhuei321.gank_kotlin.extension.getScreenHeight
import java.util.*

/**
 * Created by xiasuhuei321 on 2017/9/5.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */
class Rain(start: android.graphics.PointF, end: android.graphics.PointF) : WeatherShape(start, end) {

    override var TAG = "Rain"

    var width = 10f
    // 用户可以设置
    var length = 10f
    var timeSpace = 50

    var rainAlpha = 100
    private var lastTime = 0L // 从开始到现在下落所经过的时间
    var rainColor = Color.BLACK
    override var time: Long = 2000L // 总共下落时间

    var paint = Paint().apply {
        color = rainColor
        strokeWidth = width
        isAntiAlias = true
        alpha = rainAlpha

    }

    // 获取int类型的时间
    fun getIntTime(): Int = (time / 1000).toInt()


    // 计算加速度
    override fun getAcceleration(): Float {
        val acc = context.getScreenHeight() / (time * time).toFloat()
//        LogUtil.i(TAG, "acc = " + acc)
        return acc
    }


    override fun draw(canvas: Canvas) {
        // 计算公式： s = at^2
        if (!isInUse) {
            lastTime += randomDelay()
            isInUse = true
        }
        LogUtil.i(TAG, "lastTime=$lastTime")
        // 给上一个1px/s的初速度
        val distance = (getAcceleration() * lastTime * lastTime + 0.5 * lastTime).toFloat()
//        LogUtil.i(TAG, "distance=$distance")
        start.y += distance
        end.y += distance
        canvas.drawLine(start.x, start.y, end.x, end.y, paint)
//        LogUtil.i(TAG, "startrt=$start end=$end")
        lastTime += timeSpace
        // 可以复用了
        if (end.y >= context.getScreenHeight()) {
            clear()
        }
    }

    fun clear() {
        isInUse = false
        lastTime = 0
        start.y = -length
        end.y = 0f
    }

    override fun randomDelay(): Long {
        val random = Random()
        val delay = random.nextInt(100).toLong()
        LogUtil.i("asdf", "random = $delay ")
        return delay
    }

    // 通过该方法来获取一个随机的初始化样式
    override fun initStyle() {
        val random = Random()
//        val alpha =
    }


}