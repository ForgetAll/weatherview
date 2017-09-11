package com.xiasuhuei321.gank_kotlin.customview.weather

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF
import com.xiasuhuei321.gank_kotlin.context
import com.xiasuhuei321.gank_kotlin.extension.getScreenWidth
import java.util.*

/**
 * Created by xiasuhuei321 on 2017/9/5.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 *
 * desc: All shape's parent class.It describes a shape will have
 * what feature.It's draw flows are:
 * 1.Outside the class init some value such as the start and the
 * end point.
 * 2.Invoke draw(Canvas) method, in this method, there are still
 * two flows:
 * 1) Get random value to init paint, this will affect the shape
 * draw style.
 * 2) When the shape is not used, invoke init method, and when it
 * is not used invoke drawWhenInUse(Canvas) method. It should be
 * override by user and to implement draw itself.
 *
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
     * shape的宽度
     */
    var width = 5f

    var shapeAlpha = 100

    var paint = Paint().apply {
        strokeWidth = width
        isAntiAlias = true
        alpha = alpha
    }

    // 总共下落的时间
    var lastTime = 0L
    // 原始x坐标位置
    var originX = 0f

    /**
     * 根据自己的规则计算加速度，如果是匀速直接 return 0
     */
    abstract fun getAcceleration(): Float

    /**
     * 绘制自身，这里在Shape是非使用的时候进行一些初始化操作
     */
    open fun draw(canvas: Canvas) {
        if (!isInUse) {
            lastTime += randomPre()
            initStyle()
            isInUse = true
        } else {
            drawWhenInUse(canvas)
        }
    }

    /**
     * Shape在使用的时候调用此方法
     */
    abstract fun drawWhenInUse(canvas: Canvas)

    /**
     * 初始化Shape风格
     */
    open fun initStyle() {
        val random = Random()
        // 获取随机透明度
        shapeAlpha = random.nextInt(155) + 50
        // 获得起点x偏移
        val translateX = random.nextInt(10).toFloat() + 5
        if (!isRandom) {
            start.x = translateX + originX
            end.x = translateX + originX
        } else {
            // 如果是随机Shape，将x坐标随机范围扩大到整个屏幕的宽度
            val randomWidth = random.nextInt(context.getScreenWidth())
            start.x = randomWidth.toFloat()
            end.x = randomWidth.toFloat()
        }
        speed = randomSpeed(random)
        // 初始化length的工作留给之后对应的子类去实现
        // 初始化color也留给子类去实现
        paint.apply {
            alpha = shapeAlpha
            strokeWidth = width
            isAntiAlias = true
        }
        // 如果有什么想要做的，刚好可以在追加上完成，就使用这个函数
        wtc()
    }

    /**
     * 空实现的函数，将会在initStyle中调用。如果现有的
     * initStyle函数能满足你的需求，但是你还需要追加一些
     * 东西，你可以通过复写此函数实现
     * empty body, this will be invoke in initStyle
     * method.If current initStyle method can // 满足不会。。。
     * but you still add something, by override this method
     * can be a good idea.
     */
    open fun wtc(): Unit {

    }

    abstract fun randomSpeed(random: Random): Float

    /**
     * 获取一个随机的提前量，让shape在竖屏上有一个初始的偏移
     */
    open fun randomPre(): Long {
        val random = Random()
        val pre = random.nextInt(1000).toLong()
        return pre
    }
}
// TODO 待验证重构之后的代码的正确性