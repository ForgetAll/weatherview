package com.xiasuhuei321.gank_kotlin.datasource

import com.xiasuhuei321.gank_kotlin.datasource.bean.GankData
import com.xiasuhuei321.gank_kotlin.datasource.bean.Weather
import com.xiasuhuei321.gank_kotlin.datasource.local.LocalDataSource
import com.xiasuhuei321.gank_kotlin.datasource.local.LocalDataSourceImpl
import com.xiasuhuei321.gank_kotlin.datasource.remote.RemoteDataSource
import com.xiasuhuei321.gank_kotlin.datasource.remote.RemoteDataSourceImpl
import com.xiasuhuei321.gank_kotlin.extension.handleResult
import com.xiasuhuei321.gank_kotlin.extension.io_main
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

    override fun getRemoteData(type: String): Observable<List<GankData>> {
        return getRemoteData(type, 10, 1)
    }

    override fun getRemoteData(type: String, pageIndex: Int): Observable<List<GankData>> {
        return getRemoteData(type, 10, pageIndex)
    }

    override fun getRemoteData(type: String, count: Int, pageIndex: Int): Observable<List<GankData>> {
        return remote
                .getRemoteData(type, 10, 1)
                .compose(handleResult())
                .doOnNext({ list ->
                            if (pageIndex == 1) refreshLocalData(type, list)//只有当加载第一页数据的时候才缓存
                        }
                )
                .io_main()
    }

    /**
     * 清除本地指定缓存
     */
    override fun clearData(type: String) {
        local.clearLocalData(type)
    }

    /**
     * 清除本地所有缓存
     */
    override fun clearAllData() {
        local.clearAllData()
    }


    /**
     * 优先从本地获取数据
     */
    private fun getLocalData(type: String): Observable<List<GankData>> {
        return local.getLocalData(type)
    }

    /**
     * 刷新本地序列化存储数据
     */
    private fun <T> refreshLocalData(type: String, list: Collection<T>) {
        local.refreshLocalData(type,list)
    }

    /**
     * 获取天气，如果网络有问题，就从本地获取，本地也没有那就GG
     */
    override fun getWeatherData(): Weather {
        return Weather()
    }

}