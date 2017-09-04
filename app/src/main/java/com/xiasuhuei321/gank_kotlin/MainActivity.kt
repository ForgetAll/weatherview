package com.xiasuhuei321.gank_kotlin

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    var bmp: Bitmap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val iv_img = findViewById(R.id.iv_img) as ImageView
        bmp = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher_round)
        iv_img.setImageBitmap(bmp)
        Handler().postDelayed({
            iv_img.setImageBitmap(JNIEntry.blur(bmp))
        }, 4000)
    }

}
