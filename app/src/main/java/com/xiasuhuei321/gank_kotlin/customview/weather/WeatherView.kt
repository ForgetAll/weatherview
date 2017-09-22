package com.xiasuhuei321.gank_kotlin.customview.weather

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.PixelFormat
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.xiasuhuei321.gank_kotlin.extension.LogUtil
import java.lang.Exception

/**
 * Created by xiasuhuei321 on 2017/9/5.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */
class WeatherView(context: Context, attributeSet: AttributeSet?, defaultStyle: Int) :
        SurfaceView(context, attributeSet, defaultStyle), SurfaceHolder.Callback {
    private val TAG = "WeatherView"

    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)

    constructor(context: Context) : this(context, null, 0)

    // 低级并发，Kotlin中支持的不是很好，所以用一下黑科技
    val lock = Object()
    var type = Weather.RAIN
    var weatherShapePool = WeatherShapePool()

    @Volatile var canRun = false
    @Volatile var threadQuit = false

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
            val startTime = System.currentTimeMillis()
            try {
                // 正式开始表演
                val canvas = holder.lockCanvas()
                if (canvas != null) {
                    canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR)
                    draw(canvas, type)
                }
                holder.unlockCanvasAndPost(canvas)
                val drawTime = System.currentTimeMillis() - startTime
                // 平均16ms一帧才能有顺畅的感觉
                if (drawTime < 16) {
                    Thread.sleep(16 - drawTime)
                }
            } catch (e: Exception) {
//                e.printStackTrace()
            }
        }
    }.apply { name = "WeatherThread" }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
        // surface发生了变化
//        canRun = true

    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        // 在这里释放资源
        canRun = false
        LogUtil.i(TAG, "surfaceDestroyed")
    }

    override fun surfaceCreated(holder: SurfaceHolder?) {
        threadQuit = false
        canRun = true
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
        LogUtil.i(TAG, "init开始")
        holder.addCallback(this)
        holder.setFormat(PixelFormat.RGBA_8888)
//        initData()
        setZOrderOnTop(true)
//        setZOrderMediaOverlay(true)
        thread.start()
    }

    private fun draw(canvas: Canvas, type: Weather) {
        when (type) {
            Weather.RAIN -> {
                weatherShapePool.drawRain(canvas)
            }
            Weather.SNOW -> {
                weatherShapePool.drawSnow(canvas)
            }
        }
    }

    enum class Weather {
        RAIN,
        SNOW
    }

    fun onDestroy() {
        threadQuit = true
        canRun = true
        try {
            synchronized(lock) {
                lock.notify()
            }
        } catch (e: Exception) {
        }
    }
}