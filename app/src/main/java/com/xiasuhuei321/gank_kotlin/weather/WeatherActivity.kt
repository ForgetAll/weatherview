package com.xiasuhuei321.gank_kotlin.weather

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.xiasuhuei321.gank_kotlin.R
import com.xiasuhuei321.gank_kotlin.base.BaseActivity
import com.xiasuhuei321.gank_kotlin.base.basemvp.BaseContract

/**
 * Created by xiasuhuei321 on 2017/9/14.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */
class WeatherActivity : BaseActivity() {
    override fun getPresenter(): BaseContract.Presenter {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_weather)

    }
}