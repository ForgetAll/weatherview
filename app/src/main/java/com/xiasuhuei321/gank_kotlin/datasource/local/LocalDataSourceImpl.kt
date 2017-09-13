package com.xiasuhuei321.gank_kotlin.datasource.local

import com.xiasuhuei321.gank_kotlin.datasource.bean.GankData
import io.reactivex.Observable

/**
 * Created by coderfan on 2017/8/11.
 * desc:
 */
class LocalDataSourceImpl : LocalDataSource {

    override fun getRemoteData(type: String): Observable<List<GankData>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}