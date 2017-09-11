package com.xiasuhuei321.gank_kotlin.datasource

import android.util.Log
import com.xiasuhuei321.gank_kotlin.datasource.bean.PostType
import com.xiasuhuei321.gank_kotlin.datasource.remote.RemoteDataImpl
import com.xiasuhuei321.gank_kotlin.datasource.remote.RemoteDataSource
import com.xiasuhuei321.gank_kotlin.extension.io_main

/**
 * Created by xiasuhuei321 on 2017/8/11.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */
 class DataSource {
    private val remote :RemoteDataSource

    init {
        remote = RemoteDataImpl()
    }

    fun getRemoteData(){
        remote
                .getRemoteData(PostType.ANDROID,10,1)
                .io_main()
                .subscribe({
                    jsonResult-> Log.w("okhttp","content--->${jsonResult}")
                },{
                    e-> e.printStackTrace()
                })

    }


}