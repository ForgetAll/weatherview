package com.xiasuhuei321.gank_kotlin.datasource.remote

import com.xiasuhuei321.gank_kotlin.datasource.bean.GankData
import com.xiasuhuei321.gank_kotlin.datasource.bean.JsonResult
import com.xiasuhuei321.gank_kotlin.datasource.net.Network
import io.reactivex.Observable


/**
 * Created by xiasuhuei321 on 2017/8/11.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */
class RemoteDataSourceImpl :RemoteDataSource {

    override fun getRemoteData(type: String, count: Int, pageIndex: Int):
            Observable<JsonResult<List<GankData>>> {

        return Network.service
                .getCategoricalData(type,count = count.toString(),pageIndex = pageIndex.toString())

    }

}