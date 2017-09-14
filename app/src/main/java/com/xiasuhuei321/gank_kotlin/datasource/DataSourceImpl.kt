package com.xiasuhuei321.gank_kotlin.datasource

import android.util.Log
import com.xiasuhuei321.gank_kotlin.app
import com.xiasuhuei321.gank_kotlin.datasource.bean.GankData
import com.xiasuhuei321.gank_kotlin.datasource.bean.JsonResult
import com.xiasuhuei321.gank_kotlin.datasource.bean.Weather
import com.xiasuhuei321.gank_kotlin.datasource.local.LocalDataSource
import com.xiasuhuei321.gank_kotlin.datasource.local.LocalDataSourceImpl
import com.xiasuhuei321.gank_kotlin.datasource.remote.RemoteDataSource
import com.xiasuhuei321.gank_kotlin.datasource.remote.RemoteDataSourceImpl
import com.xiasuhuei321.gank_kotlin.extension.handleResult
import com.xiasuhuei321.gank_kotlin.extension.io_main
import io.reactivex.Observable
import io.reactivex.functions.Function

/**
 * Created by coderFan on 2017/8/11.
 * author:karl
 * e-mail:fgeekey2014@163.com
 */
object DataSourceImpl : DataSource {

    private val remote: RemoteDataSource

    private val local: LocalDataSource

    init {
        remote = RemoteDataSourceImpl()
        local = LocalDataSourceImpl()
    }

    /**
     * 初次打开app需要进行一些初始化操作
     */
    public fun firstInit() {

    }

    override fun getData(type: String): Observable<List<GankData>> {
        return getRemoteData(type,10,1)
    }

    override fun getRemoteData(type: String, count: Int, pageIndex: Int): Observable<List<GankData>> {
        return remote
                .getRemoteData(type,10,1)
                .compose(handleResult())
                .io_main()
    }

    /**
     * 清除本地指定缓存
     */
    override fun clearData(type: String) {
        TODO("清除本地指定缓存数据")
    }

    /**
     * 清除本地所有缓存
     */
    override fun clearAllData() {
//        TODO("清除本地所有缓存数据")
    }


    /**
     * 优先从本地获取数据
     */
    private fun getLocalData(type: String): Observable<List<GankData>> {
        TODO("获取本地的缓存数据")
    }

    /**
     * 刷新本地序列化存储数据
     */
    private fun refreshLocalData(type: String) {
//        TODO("序列化存储指定数据到本地")
    }

    /**
     * 获取天气，如果网络有问题，就从本地获取，本地也没有那就GG
     */
    override fun getWeatherData(): Weather {
        return Weather()
    }

}