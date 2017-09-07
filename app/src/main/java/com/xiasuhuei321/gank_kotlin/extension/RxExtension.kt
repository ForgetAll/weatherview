package com.xiasuhuei321.gank_kotlin.extension

import com.xiasuhuei321.gank_kotlin.datasource.bean.JsonResult
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.function.Function

/**
 * Created by Karl on 2017/9/7 0007.
 * desc:公用扩展函数
 */

/**
 * RxJava 线程切换
 */
fun <T> Observable<T>.io_main():Observable<T>{
    return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}
//
//fun <T>Observable<T>.handleResult():ObservableTransformer<JsonResult<T>,T>{
//    return ObservableTransformer<JsonResult<T>,T>{
//        apply {
//
//        }
//    }
//}
