package com.xiasuhuei321.gank_kotlin.datasource

import com.xiasuhuei321.gank_kotlin.datasource.bean.GankData
import com.xiasuhuei321.gank_kotlin.datasource.bean.Weather
import com.xiasuhuei321.gank_kotlin.datasource.local.LocalDataSource
import com.xiasuhuei321.gank_kotlin.datasource.local.LocalDataSourceImpl
import com.xiasuhuei321.gank_kotlin.datasource.remote.RemoteDataSource
import com.xiasuhuei321.gank_kotlin.datasource.remote.RemoteDataSourceImpl
import io.reactivex.Observable

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
        TODO("获取数据，进行网络请求,加载失败再从本地读取缓存")
    }

    override fun getRemoteData(type: String, pageIndex: Int, count: Int): Observable<List<GankData>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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