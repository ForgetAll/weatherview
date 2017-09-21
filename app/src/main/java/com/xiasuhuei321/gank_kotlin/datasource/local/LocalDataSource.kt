package com.xiasuhuei321.gank_kotlin.datasource.local

import com.xiasuhuei321.gank_kotlin.datasource.bean.GankData
import com.xiasuhuei321.gank_kotlin.datasource.bean.Town
import io.reactivex.Observable

/**
 * Created by coderfan on 2017/8/11.
 * desc:
 */
interface LocalDataSource<T> {

    //本地缓存
    fun getLocalData(type: String): List<T>

    fun refreshLocalData(type: String,list: List<T>)

    fun clearLocalData(type: String)

    fun clearAllData()

    fun json2DB(): Map<String, List<Town>>
}