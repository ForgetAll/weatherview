package com.xiasuhuei321.gank_kotlin.datasource.remote

import com.xiasuhuei321.gank_kotlin.datasource.net.ApiStore
import com.xiasuhuei321.gank_kotlin.datasource.bean.GankData
import com.xiasuhuei321.gank_kotlin.datasource.bean.JsonResult
import com.xiasuhuei321.gank_kotlin.datasource.bean.TechBean
import com.xiasuhuei321.gank_kotlin.datasource.net.ReHelper
import com.xiasuhuei321.gank_kotlin.extension.io_main
import io.reactivex.Observable


/**
 * Created by xiasuhuei321 on 2017/8/11.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */
class RemoteDataImpl : RemoteDataSource {

    private var apiStore: ApiStore? = null

    init {
        if (apiStore==null) ReHelper.getInstance().create(ApiStore::class.java)
    }

    companion object {
       val INSTANCE: RemoteDataImpl by lazy { this.INSTANCE }
    }

    override fun getRemoteData(type: String, count: Int, pageIndex: Int): Observable<JsonResult<List<GankData>>> {
        return apiStore!!.getCategoricalData(type,count.toString(),pageIndex.toString()).io_main()
    }

    override fun getRemoteTechBeanStaredList(type: String, count: Int, pageIndex: Int): Observable<TechBean> {
//        val retrofit = Retrofit.Builder()
//                .baseUrl("http://gank.io/api/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build()
        val newCount = count.toString()
        val newPageIndex = pageIndex.toString()
        return apiStore!!.getData(type, newCount, newPageIndex)
    }

}