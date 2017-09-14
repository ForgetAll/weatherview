package com.xiasuhuei321.gank_kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Window
import android.view.WindowManager
import com.xiasuhuei321.gank_kotlin.datasource.DataSource
import com.xiasuhuei321.gank_kotlin.datasource.DataSourceImpl
import com.xiasuhuei321.gank_kotlin.datasource.bean.PostType
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

    override fun onResume() {
        super.onResume()
        DataSourceImpl
                .getData(PostType.ANDROID)
                .subscribe(
                        {
                            list->Log.e("RPG","list ---> " + list)
                        },
                        {
                            e->e.printStackTrace()
                        }
                )
    }

    override fun onDestroy() {
        super.onDestroy()
        weatherWv.onDestroy()
    }
}


