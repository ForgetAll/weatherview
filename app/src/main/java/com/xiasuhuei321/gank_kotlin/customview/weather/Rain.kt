package com.xiasuhuei321.gank_kotlin.customview.weather

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.PointF
import com.xiasuhuei321.gank_kotlin.context
import com.xiasuhuei321.gank_kotlin.extension.getScreenHeight
import java.util.*

/**
 * Created by xiasuhuei321 on 2017/9/5.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 *
 * desc:
 */
class Rain(start: PointF, end: PointF) : WeatherShape(start, end) {

    override var TAG = "Rain"

    // 用户可以设置
    var length = 20f
    var originLength = 20f
        set(value) {
            field = value
            length = value
        }

    var timeSpace = 16
    //    var originSpeed = speed
    var rainColor = Color.parseColor("#efefef")


    // 计算加速度
    override fun getAcceleration(): Float {
        return 0f
    }

    /**
     * 绘制过程在此完成
     */
    override fun drawWhenInUse(canvas: Canvas) {
        val distance = speed * lastTime
        start.y += distance
        end.y += distance
        canvas.drawLine(start.x, start.y, end.x, end.y, paint)
        // 很重要，持续时间增加
        lastTime += timeSpace
        // 如果已经超出屏幕，表示可以服用了，清空原先状态
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

    override fun wtc(random: Random) {
        length = random.nextInt(5).toFloat() + originLength
        paint.apply {
            color = rainColor
        }
    }


    override fun randomSpeed(random: Random): Float {
        // 获取随机速度 0.02 ~ 0.06
        var randomSpeed = random.nextFloat() / 10
        if (randomSpeed - 0.05f > 0.01f) {
            randomSpeed -= 0.05f
        } else if (randomSpeed < 0.02f) {
            randomSpeed = 0.02f
        }

        return randomSpeed
    }


}