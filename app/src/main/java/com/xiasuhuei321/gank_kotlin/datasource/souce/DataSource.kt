package com.xiasuhuei321.gank_kotlin.datasource.souce

import com.xiasuhuei321.gank_kotlin.datasource.code.Type
import com.xiasuhuei321.gank_kotlin.datasource.local.LocalDataImpl
import com.xiasuhuei321.gank_kotlin.datasource.remote.ServerDataImpl
import com.xiasuhuei321.gank_kotlin.extension.io_main
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by xiasuhuei321 on 2017/8/11.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */
object DataSource {
    val TAG: String = "DataSource"
    val server = ServerDataImpl()
    val local = LocalDataImpl()

    /**
     * 从网络获取数据，保存数据
     */
    fun initData() {
        server.getRemoteTechBeanStaredList(Type.WELFARE, 100, 1)
                .io_main()
                .subscribe({

                }, {
                    e ->
                    e.printStackTrace()
                })
        server.getRemoteTechBeanStaredList(Type.WELFARE, 100, 1)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                }, {
                    e ->
                    e.printStackTrace()
                })
        server.getRemoteTechBeanStaredList(Type.WELFARE, 100, 1)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                }, {
                    e ->
                    e.printStackTrace()
                })
        server.getRemoteTechBeanStaredList(Type.WELFARE, 100, 1)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                }, {
                    e ->
                    e.printStackTrace()
                })
    }

}