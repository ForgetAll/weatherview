package com.xiasuhuei321.gank_kotlin.extension

import com.xiasuhuei321.gank_kotlin.datasource.bean.JsonResult
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Karl on 2017/9/7 0007.
 * desc:公用扩展函数
 */

/**
 * RxJava 线程切换
 */
fun <T> Observable<T>.io_main(): Observable<T> {
    return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Flowable<T>.io_main(): Flowable<T> {
    return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun <T>  handleResult(): ObservableTransformer<JsonResult<T>, T> {
    return ObservableTransformer<JsonResult<T>, T>() { observable ->
        observable.flatMap { jsonResult ->
            when (jsonResult.error) {
                false -> Observable.just(jsonResult.results)
                true -> Observable.error(Exception("数据加载失败"))
            }
        }
    }
}


