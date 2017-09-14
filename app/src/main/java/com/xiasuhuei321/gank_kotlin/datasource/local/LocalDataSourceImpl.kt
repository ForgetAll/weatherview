package com.xiasuhuei321.gank_kotlin.datasource.local

import com.xiasuhuei321.gank_kotlin.datasource.bean.GankData
import com.xiasuhuei321.gank_kotlin.datasource.bean.Town
import io.reactivex.Observable

/**
 * Created by coderfan on 2017/8/11.
 * desc:数据缓存管理类
 */
class LocalDataSourceImpl : LocalDataSource {

    override fun json2DB(): Map<String, List<Town>> {
        return null!!
    }

    override fun getLocalData(type: String): Observable<List<GankData>> {
        TODO("获取本地缓存的数据，检查缓存、sp/file/db（待定）,取数据需要先本地取数据，然后检查是否有符合的数据") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T> refreshLocalData(type: String, list: Collection<T>) {
        TODO("将数据存到本地,这里传入的list应该先装入Map，然后map转换成json再存入本地") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearLocalData(type: String) {
        TODO("清空本地指定缓存") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearAllData() {
        TODO("清空本地所有缓存") //To change body of created functions use File | Settings | File Templates.
    }
}