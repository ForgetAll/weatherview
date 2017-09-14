package com.xiasuhuei321.gank_kotlin.datasource.local

import com.xiasuhuei321.gank_kotlin.datasource.bean.GankData
import com.xiasuhuei321.gank_kotlin.datasource.bean.Town
import io.reactivex.Observable

/**
 * Created by coderfan on 2017/8/11.
 * desc:
 */
class LocalDataSourceImpl : LocalDataSource {
    override fun json2DB(): Map<String, List<Town>> {
        return null!!
    }

    override fun getLocalData(type: String): Observable<List<GankData>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}