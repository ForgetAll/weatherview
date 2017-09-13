package com.xiasuhuei321.gank_kotlin.datasource.local

import com.xiasuhuei321.gank_kotlin.datasource.bean.GankData
import io.reactivex.Observable

/**
 * Created by coderfan on 2017/8/11.
 * desc:
 */
interface LocalDataSource {

    //本地缓存
    fun getRemoteData(type:String):Observable<List<GankData>>
}