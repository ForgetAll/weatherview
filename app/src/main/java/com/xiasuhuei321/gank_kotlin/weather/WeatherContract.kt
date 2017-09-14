package com.xiasuhuei321.gank_kotlin.weather

import com.xiasuhuei321.gank_kotlin.base.basemvp.BaseContract
import com.xiasuhuei321.gank_kotlin.datasource.bean.Weather

/**
 * Created by xiasuhuei321 on 2017/9/14.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */

interface WeatherContract{
    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter{
        fun getWeather(): Weather
    }
}