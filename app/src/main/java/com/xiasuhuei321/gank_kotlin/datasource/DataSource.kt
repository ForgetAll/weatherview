package com.xiasuhuei321.gank_kotlin.datasource

import com.xiasuhuei321.gank_kotlin.datasource.localsource.LocalDataImpl
import com.xiasuhuei321.gank_kotlin.datasource.remotesource.ServerDataImpl
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