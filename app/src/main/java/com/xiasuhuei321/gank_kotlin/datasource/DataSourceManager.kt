package com.xiasuhuei321.gank_kotlin.datasource

import com.xiasuhuei321.gank_kotlin.datasource.bean.PostType
import com.xiasuhuei321.gank_kotlin.datasource.local.LocalDataImpl
import com.xiasuhuei321.gank_kotlin.datasource.remote.RemoteDataImpl
import com.xiasuhuei321.gank_kotlin.extension.io_main

/**
 * Created by xiasuhuei321 on 2017/8/11.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */
object DataSourceManager :DataSource {
    val TAG: String = "DataSource"
    val server = RemoteDataImpl()
    val local = LocalDataImpl()

    /**
     * 从网络获取数据，保存数据
     */
    fun initData() {
        server.getRemoteTechBeanStaredList(PostType.WELFARE, 100, 1)
                .io_main()
                .subscribe({

                }, {
                    e ->
                    e.printStackTrace()
                })
        server.getRemoteTechBeanStaredList(PostType.WELFARE, 100, 1)
                .io_main()
                .subscribe({

                }, {
                    e ->
                    e.printStackTrace()
                })
        server.getRemoteTechBeanStaredList(PostType.WELFARE, 100, 1)
                .io_main()
                .subscribe({

                }, {
                    e ->
                    e.printStackTrace()
                })
        server.getRemoteTechBeanStaredList(PostType.WELFARE, 100, 1)
                .io_main()
                .subscribe({

                }, {
                    e ->
                    e.printStackTrace()
                })
    }

}