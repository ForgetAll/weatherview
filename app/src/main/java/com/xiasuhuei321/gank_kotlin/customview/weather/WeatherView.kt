package com.xiasuhuei321.gank_kotlin.customview.weather

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.PixelFormat
import android.graphics.PorterDuff
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.xiasuhuei321.gank_kotlin.customview.weather.WeatherView.SkyBackground.RAIN_D
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
    private val skyBackgroud = GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, RAIN_D)

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
                    // 这种方式绘制比较卡，换一种
//                    canvas.drawColor(context.resources.getColor(R.color.sky_blue), PorterDuff.Mode.DST_OVER)
//                     感谢 mixiaoxiao 大神的实现思路
                    skyBackgroud.setBounds(0, 0, measuredWidth, measuredHeight)
                    skyBackgroud.draw(canvas)
                    draw(canvas, type)
                }
                holder.unlockCanvasAndPost(canvas)
                val drawTime = System.currentTimeMillis() - startTime
                // 平均16ms一帧才能有顺畅的感觉
                if (drawTime < 16) {
                    Thread.sleep(16 - drawTime)
                } else {
                    LogUtil
                }
            } catch (e: Exception) {
//                e.printStackTrace()
            }
        }
    }.apply { name = "WeatherThread" }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
        // surface发生了变化
        canRun = true

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
        holder.setFormat(PixelFormat.TRANSLUCENT)
//        initData()
//        setZOrderOnTop(true)
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

    object SkyBackground {
        val BLACK = intArrayOf(0xff000000.toInt(), 0xff000000.toInt())
        //		public static final int[] CLEAR_D = new int[] { 0xff3d99c2, 0xff4f9ec5 };
        //		public static final int[] CLEAR_N = new int[] { 0xff0d1229, 0xff262c42 };

        val CLEAR_D = intArrayOf(0xff3d99c2.toInt(), 0xff4f9ec5.toInt())
        val CLEAR_N = intArrayOf(0xff0b0f25.toInt(), 0xff252b42.toInt())
        // ////////////
        val OVERCAST_D = intArrayOf(0xff33425f.toInt(), 0xff617688.toInt())//0xff748798, 0xff617688
        val OVERCAST_N = intArrayOf(0xff262921.toInt(), 0xff23293e.toInt())//0xff1b2229, 0xff262921
        // ////////////
        val RAIN_D = intArrayOf(0xff4f80a0.toInt(), 0xff4d748e.toInt())
        val RAIN_N = intArrayOf(0xff0d0d15.toInt(), 0xff22242f.toInt())
        // ////////////
        val FOG_D = intArrayOf(0xff688597.toInt(), 0xff44515b.toInt())
        val FOG_N = intArrayOf(0xff2f3c47.toInt(), 0xff24313b.toInt())

        // ////////////
        val SNOW_D = intArrayOf(0xff4f80a0.toInt(), 0xff4d748e.toInt())//临时用RAIN_D凑数的
        val SNOW_N = intArrayOf(0xff1e2029.toInt(), 0xff212630.toInt())
        // ////////////
        val CLOUDY_D = intArrayOf(0xff4f80a0.toInt(), 0xff4d748e.toInt())//临时用RAIN_D凑数的
        val CLOUDY_N = intArrayOf(0xff071527.toInt(), 0xff252b42.toInt())// 0xff193353 };//{ 0xff0e1623, 0xff222830 }
        // ////////////
        val HAZE_D = intArrayOf(0xff616e70.toInt(), 0xff474644.toInt())// 0xff999b95, 0xff818e90
        val HAZE_N = intArrayOf(0xff373634.toInt(), 0xff25221d.toInt())

        // ////////////
        val SAND_D = intArrayOf(0xffb5a066.toInt(), 0xffd5c086.toInt())//0xffa59056
        val SAND_N = intArrayOf(0xff312820.toInt(), 0xff514840.toInt())
    }
}