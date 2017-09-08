package com.xiasuhuei321.gank_kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import com.xiasuhuei321.gank_kotlin.extension.shortToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        weatherIv.setOnClickListener {
            shortToast("weather icon be clicked")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        weatherWv.onDestroy()
    }
}


