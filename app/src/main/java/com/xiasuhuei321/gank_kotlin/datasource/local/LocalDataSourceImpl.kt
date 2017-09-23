package com.xiasuhuei321.gank_kotlin.datasource.local

import com.xiasuhuei321.gank_kotlin.datasource.bean.GankData
import com.xiasuhuei321.gank_kotlin.datasource.bean.Town
import com.xiasuhuei321.gank_kotlin.extension.*
import io.reactivex.Observable

/**
 * Created by coderfan on 2017/8/11.
 * desc:数据缓存管理类
 */
class LocalDataSourceImpl<T> : LocalDataSource<T> {

    val map  = HashMap<String,List<T>>()

    override fun json2DB(): Map<String, List<Town>> {
        return null!!
    }

    override fun getLocalData(type: String): List<T>{
        if (map.containsKey(type)){
            return map.get(type)!!
        }else{
            TODO("I don't know how to cast result to list")
        }
    }

    override fun refreshLocalData(type: String, list: List<T>) {
        map.put(type,list)
        write2File(type, listToJson(list))
    }

    override fun clearLocalData(type: String) {
        if (map.containsKey(type))map.remove(type)
        deleteCacheFile(type)
    }

    override fun clearAllData() {
        map.clear()
        deleteAllCacheFile()
    }
}