package com.xiasuhuei321.gank_kotlin.customview.weather

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.xiasuhuei321.gank_kotlin.context
import com.xiasuhuei321.gank_kotlin.extension.getScreenHeight
import com.xiasuhuei321.gank_kotlin.extension.getScreenWidth
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
    //    var originSpeed = speed
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
        // 恩，决定了，放弃加速，匀速走完
        return 0f
    }

    /**
     * 此函数用来绘制相对"固定"的雨滴
     */
    override fun draw(canvas: Canvas) {
        // 计算公式： s = at^2
        if (!isInUse) {
            lastTime += randomPre()
            initStyle()
            isInUse = true
        }
        val distance = speed * lastTime
        start.y += distance
        end.y += distance
        canvas.drawLine(start.x, start.y, end.x, end.y, paint)
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

    /**
     * @see WeatherShape
     */
    override fun randomPre(): Long {
        val random = Random()
        val pre = random.nextInt(1000).toLong()
//        LogUtil.i("asdf", "random = $delay ")
        return pre
    }

    // 通过该方法来获取一个随机的初始化样式
    override fun initStyle() {
        val random = Random()
        // 获取随机透明值
        rainAlpha = random.nextInt(155) + 50
        // 获得起点x偏移
        translateX = random.nextInt(10).toFloat() + 5
        // 获得长度
        length = random.nextInt(5).toFloat() + originLength
        // 获得宽度 5 ~ 8
        width = random.nextInt(3) + 5f
        if (!isRandom) {
            start.x = translateX + originX
            end.x = translateX + originX
        } else {
            // 如果是随机雨点，将x坐标随机范围扩大
            val randomWidth = random.nextInt(context.getScreenWidth())
            start.x = randomWidth + originX
            end.x = randomWidth + originX
        }
        // 获取随机速度 0.02 ~ 0.06
        var randomSpeed = random.nextFloat() / 10
        if (randomSpeed - 0.05f > 0.01f) {
            randomSpeed -= 0.05f
        } else if (randomSpeed < 0.02f) {
            randomSpeed = 0.02f
        }
        speed = randomSpeed
        start.y = -length
        end.y = 0f
        paint.apply {
            alpha = rainAlpha
            strokeWidth = width
            color = rainColor
            isAntiAlias = true
        }
    }


}