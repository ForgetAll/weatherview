package com.xiasuhuei321.gank_kotlin.datasource.remote

import com.xiasuhuei321.gank_kotlin.datasource.bean.GankData
import com.xiasuhuei321.gank_kotlin.datasource.bean.JsonResult
import com.xiasuhuei321.gank_kotlin.datasource.bean.TechBean
import io.reactivex.Observable


/**
 * Created by xiasuhuei321 on 2017/8/11.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */
interface RemoteDataSource {

    fun getRemoteTechBeanStaredList(type: String, count: Int, pageIndex: Int): Observable<TechBean>

    //获取分类数据
    fun getRemoteData(type:String, count: Int,pageIndex: Int):Observable<JsonResult<List<GankData>>>

}