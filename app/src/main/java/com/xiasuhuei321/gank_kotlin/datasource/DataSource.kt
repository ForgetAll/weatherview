package com.xiasuhuei321.gank_kotlin.datasource

import com.xiasuhuei321.gank_kotlin.datasource.bean.PostType
import com.xiasuhuei321.gank_kotlin.datasource.local.LocalDataImpl
import com.xiasuhuei321.gank_kotlin.datasource.remote.RemoteDataImpl
import com.xiasuhuei321.gank_kotlin.extension.LogUtil
import com.xiasuhuei321.gank_kotlin.extension.io_main

/**
 * Created by xiasuhuei321 on 2017/8/11.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */
 object DataSource {
    val TAG: String = "DataSource"
//    val server = RemoteDataImpl()
    val local = LocalDataImpl()

    fun getRemoteData(){
        RemoteDataImpl.INSTANCE
                .getRemoteData(PostType.ANDROID,10,1)
                .io_main()
                .subscribe({
                    jsonResult-> LogUtil.d(jsonResult.toString())
                },{
                    e-> e.printStackTrace()
                })

    }


}