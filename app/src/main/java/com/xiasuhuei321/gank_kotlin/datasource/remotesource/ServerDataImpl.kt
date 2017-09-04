package com.xiasuhuei321.gank_kotlin.datasource.remotesource

import com.xiasuhuei321.gank_kotlin.datasource.ApiStore
import com.xiasuhuei321.gank_kotlin.datasource.bean.TechBean
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by xiasuhuei321 on 2017/8/11.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */
class ServerDataImpl : ServerData {
    val TAG: String = "ServerDataImpl"

    override fun getRemoteTechBeanStaredList(type: String, count: Int, pageIndex: Int): Observable<TechBean> {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://gank.io/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        val newCount = count.toString()
        val newPageIndex = pageIndex.toString()
        return retrofit.create(ApiStore::class.java)
                .getData(type, newCount, newPageIndex)
    }
}