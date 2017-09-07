package com.xiasuhuei321.gank_kotlin

import android.graphics.Bitmap
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import android.widget.RelativeLayout
import com.xiasuhuei321.gank_kotlin.customview.weather.WeatherView
import com.xiasuhuei321.gank_kotlin.extension.LogUtil
import com.xiasuhuei321.gank_kotlin.extension.find

class MainActivity : AppCompatActivity() {
    var bmp: Bitmap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        val test = find<WeatherView>(R.id.wv_test)
        val rl_test = find<RelativeLayout>(R.id.rl_test)
        rl_test.setOnClickListener {
            LogUtil.i("test", "点击事件传到了")
        }
    }
}


