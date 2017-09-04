package com.xiasuhuei321.gank_kotlin.datasource.remotesource

import com.xiasuhuei321.gank_kotlin.datasource.bean.TechBean
import io.reactivex.Observable


/**
 * Created by xiasuhuei321 on 2017/8/11.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */
interface ServerData {
    fun getRemoteTechBeanStaredList(type: String, count: Int, pageIndex: Int): Observable<TechBean>
}