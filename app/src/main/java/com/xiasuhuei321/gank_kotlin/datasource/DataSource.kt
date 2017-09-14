package com.xiasuhuei321.gank_kotlin.datasource

import com.xiasuhuei321.gank_kotlin.datasource.bean.GankData
import com.xiasuhuei321.gank_kotlin.datasource.bean.Weather
import io.reactivex.Observable


/**
 * Created by CoderFan on 2017/9/12.
 * desc:
 */
interface DataSource {

    // 获取Data
    fun getRemoteData(type: String): Observable<List<GankData>>

    //获取Data,默认请求数据为10
    fun getRemoteData(type: String,pageIndex: Int):Observable<List<GankData>>

    // 获取服务器数据，每页数据默认为10, 页码默认为1
    fun getRemoteData(type: String, count: Int,pageIndex: Int): Observable<List<GankData>>

    // 清除本地指定缓存
    fun clearData(type: String)

    // 清除本地所有缓存
    fun clearAllData()

    // 获取天气数据
    fun getWeatherData(): Weather
}
