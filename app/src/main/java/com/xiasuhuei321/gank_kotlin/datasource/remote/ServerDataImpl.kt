package com.xiasuhuei321.gank_kotlin.datasource.remote

import com.xiasuhuei321.gank_kotlin.datasource.ApiStore
import com.xiasuhuei321.gank_kotlin.datasource.bean.TechBean
import com.xiasuhuei321.gank_kotlin.datasource.net.RetrofitHelper
import io.reactivex.Observable


/**
 * Created by xiasuhuei321 on 2017/8/11.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */
class ServerDataImpl : ServerData {

    val TAG: String = "ServerDataImpl"

    var apiStore: ApiStore? = null

    init {
        val retrofit = RetrofitHelper.getInstance()
        apiStore = retrofit.create(ApiStore::class.java)
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