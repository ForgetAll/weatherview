package com.xiasuhuei321.gank_kotlin.customview.weather

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.xiasuhuei321.gank_kotlin.extension.LogUtil
import com.xiasuhuei321.gank_kotlin.extension.getScreenWidth
import java.lang.Exception

/**
 * Created by xiasuhuei321 on 2017/9/5.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */
class WeatherView(context: Context, attributeSet: AttributeSet?, defaultStyle: Int) :
        SurfaceView(context, attributeSet, defaultStyle), SurfaceHolder.Callback {
    private val TAG = "WeatherView"

    var time = 0L
    val rainWidth = 5
    // 低级并发，Kotlin中支持的不是很好，所以用一下黑科技
    val lock = Object()
    var type = Weather.RAIN

    @Volatile var canRun = false
    @Volatile var threadQuit = false

    val rains = ArrayList<Rain>()

    constructor(context: Context, attributeSet: AttributeSet) : this(context, attributeSet, 0) {
        LogUtil.e(TAG, "构建方法2")
    }

    constructor(context: Context) : this(context, null, 0) {
        LogUtil.e(TAG, "构建方法1")
    }

    var thread = Thread {
        while (!threadQuit) {
            if (!canRun) {
                synchronized(lock) {
                    try {
                        LogUtil.i(TAG, "条件尚不充足，阻塞中...")
                        lock.wait()
                    } catch (e: Exception) {
                    }
                }
            }
            try {
                // 正式开始表演
                val canvas = holder.lockCanvas()
                if (canvas != null) {
                    canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR)
                    draw(canvas, type)
//                    LogUtil.i(TAG, "不为空")
                }
                holder.unlockCanvasAndPost(canvas)

                Thread.sleep(50)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }.apply { name = "WeatherThread" }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
        // surface发生了变化
    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        // 在这里释放资源
        canRun = false
        threadQuit = true
        LogUtil.i(TAG, "surfaceDestroyed")
    }

    override fun surfaceCreated(holder: SurfaceHolder?) {
        threadQuit = false
        canRun = true
//        val lockCanvas = holder!!.lockCanvas()
//        lockCanvas.drawLine(200f, 200f, 200f, 300f, paint)
//        holder.unlockCanvasAndPost(lockCanvas)
        try {
            // 如果没有执行wait的话，这里notify会抛异常
            synchronized(lock) {
                lock.notify()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    init {
        holder.addCallback(this)
        holder.setFormat(PixelFormat.RGBA_8888)
        initData()
        setZOrderOnTop(true)
//        setZOrderMediaOverlay(true)
        thread.start()
    }

    private fun initData() {
        val space = context.getScreenWidth() / 20
        var i = 0
        var currentSpace = 0f
        // 将其均匀的分布在屏幕x方向上
        while (i < 20) {
            val rain = Rain(PointF(currentSpace, -30f), PointF(currentSpace, 0f))
            rain.length = 30f
            rains.add(rain)
            currentSpace += space
            i++
        }
    }

    val paint by lazy {
        Paint().apply {
            isAntiAlias = true
            color = Color.BLACK
            strokeWidth = 10f
            style = Paint.Style.STROKE
        }
    }

    private fun draw(canvas: Canvas, type: Weather) {
        // type什么的先放一边，先实现一个
        for (rain in rains) {
            rain.draw(canvas)
        }
    }

    enum class Weather {
        RAIN,
        SNOW
    }
}