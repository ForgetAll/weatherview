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

    /**
     * 是否是正在被使用的状态
     */
    var isInUse = false

    /**
     * 是否是随机刷新的Shape
     */
    var isRandom = false

    /**
     * 下落的速度，特指垂直方向，子类可以实现自己水平方向的速度
     */
    var speed = 0.05f

    /**
     * 总时间
     */
    //    abstract var time: Long

    /**
     * 根据自己的规则计算加速度，如果是匀速直接 return 0
     */
    abstract fun getAcceleration(): Float

    /**
     * 绘制自身，具体实现交给子类去实现（可以drawLine，drawBitmap等）
     */
    abstract fun draw(canvas: Canvas)

    /**
     * 随机的提前量，让Shape错开
     */
    abstract fun randomPre(): Long

    /**
     * 初始化Shape风格
     */
    abstract fun initStyle()
}