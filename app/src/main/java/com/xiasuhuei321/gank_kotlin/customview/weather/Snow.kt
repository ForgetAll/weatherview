package com.xiasuhuei321.gank_kotlin.customview.weather

import android.graphics.*
import com.xiasuhuei321.gank_kotlin.context
import com.xiasuhuei321.gank_kotlin.extension.getScreenHeight
import java.util.*

/**
 * Created by xiasuhuei321 on 2017/9/5.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */
class Snow(start: PointF, end: PointF) : WeatherShape(start, end) {
    override var TAG = "Snow"

    /**
     * 圆心，用户可以改变这个值
     */
    var center = PointF(0f, 0f)
    /**
     * 半径
     */
    var radius = 10f

    override fun getAcceleration(): Float {
        return 0f
    }

    override fun drawWhenInUse(canvas: Canvas) {
        // 通过圆心与半径确定圆的位置及大小
        val distance = speed * lastTime
        center.y += distance
        start.y += distance
        end.y += distance
        lastTime += 16
        canvas.drawCircle(center.x, center.y, radius, paint)
        if (end.y > context.getScreenHeight()) clear()
    }

    fun calcCenter() {
        center.x = (start.x + end.x) / 2f
        center.y = (start.y + end.y) / 2f
    }

    override fun randomSpeed(random: Random): Float {
        // 获取随机速度0.005 ~ 0.01
        return (random.nextInt(5) + 5) / 1000f
    }

    override fun wtc(random: Random) {
        // 设置颜色渐变
        val shader = RadialGradient(center.x, center.y, radius,
                Color.parseColor("#FFFFFF"), Color.parseColor("#D1D1D1"),
                Shader.TileMode.CLAMP)
        // 外部设置的起始点其实并不对，先计算出半径
        radius = random.nextInt(10) + 15f
        // 根据半径计算start end
        end.x = start.x + radius
        end.y = start.y + radius
        // 计算圆心
        calcCenter()

        paint.apply {
            setShader(shader)
        }
    }

    fun clear() {
        isInUse = false
        lastTime = 0
        start.y = -radius * 2
        end.y = 0f

        calcCenter()
    }
}