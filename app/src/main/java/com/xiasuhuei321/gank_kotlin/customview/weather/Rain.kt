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

    var width = 5f
    // 用户可以设置
    var length = 20f
    var originLength = 20f
        set(value) {
            field = value
            length = value
        }

    var originX = 0f
    var translateX = 0f
    var timeSpace = 16

    var rainAlpha = 100
    private var lastTime = 0L // 从开始到现在下落所经过的时间
    var rainColor = Color.WHITE
    override var time: Long = 5000 // 总共下落时间

    var paint = Paint().apply {
        color = rainColor
        strokeWidth = width
        isAntiAlias = true
        alpha = rainAlpha
    }

    // 计算加速度
    override fun getAcceleration(): Float {
        val acc = context.getScreenHeight() / (time * time).toFloat()
//        LogUtil.i(TAG, "acc = " + acc)
        return 0f
    }


    override fun draw(canvas: Canvas) {
        // 计算公式： s = at^2
        if (!isInUse) {
            lastTime += randomDelay()
            initStyle()
            isInUse = true
        }
//        LogUtil.i(TAG, "lastTime=$lastTime")
        // 给上一个 px/ms的初速度
        val distance = (0.05 * lastTime).toFloat()
//        LogUtil.i(TAG, "distance=$distance")
        start.y += distance
        end.y += distance
        canvas.drawLine(start.x, start.y, end.x, end.y, paint)
        LogUtil.i(TAG, "start=$start end=$end")
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
        // 获取随机透明值
        rainAlpha = random.nextInt(55) + 100
        // 获得起点x偏移
        translateX = random.nextInt(10).toFloat() + 5
        // 获得长度
        length = random.nextInt(10).toFloat() + originLength
        // 获得宽度 5 ~ 8
        width = random.nextInt(3) + 5f
        start.x = translateX + originX
        end.x = translateX + originX
        start.y = -length
        end.y = 0f
        paint.apply {
            alpha = rainAlpha
            strokeWidth = width
            color = rainColor
            isAntiAlias = true
        }
    }

    // TODO 1.随机刷新雨点，直到雨点数量达到40 2.随机刷新速度 0.05 ~ 0.07

}