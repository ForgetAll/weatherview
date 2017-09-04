package com.xiasuhuei321.gank_kotlin.datasource

import com.xiasuhuei321.gank_kotlin.datasource.bean.TechBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by xiasuhuei321 on 2017/8/11.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */
interface ApiStore {
    /**
     * http://gank.io/api/data/数据类型/请求个数/第几页
     */
    @GET("data/{type}/{count}/{pageIndex}")
    fun getData(@Path("type") type: String,
                @Path("count") count: String,
                @Path("pageIndex") pageIndex: String): Observable<TechBean>
}