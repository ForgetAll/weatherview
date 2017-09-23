package com.xiasuhuei321.gank_kotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import com.xiasuhuei321.gank_kotlin.customview.weather.WeatherView
import com.xiasuhuei321.gank_kotlin.extension.LogUtil
import com.xiasuhuei321.gank_kotlin.extension.shortToast
import com.xiasuhuei321.weather.TestActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var weatherWv: WeatherView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        weatherIv.setOnClickListener {
            shortToast("weather icon be clicked")
        }
        startActivity(Intent(this, TestActivity::class.java))
        weatherWv = WeatherView(this)
    }

    override fun onResume() {
//        weatherWv.setZOrderOnTop(true)
//        weatherWv.setZOrderMediaOverlay(false)
//        weatherWv.canRun = true
//        try {
//            weatherWv.lock.notify()
//        }catch (e: Exception){}
        containerFl.addView(weatherWv)
        LogUtil.i("onResume")
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
        containerFl.removeAllViews()
//        weatherWv.setZOrderOnTop(false)
//        weatherWv.setZOrderMediaOverlay(true)
//        weatherWv.canRun = false
//        LogUtil.i("onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        weatherWv.onDestroy()
    }
}


