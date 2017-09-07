package com.xiasuhuei321.gank_kotlin

import android.app.Application
import android.content.Context

/**
 * Created by xiasuhuei321 on 2017/9/6.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */
class GankApplication : Application() {
    companion object {
        var mContext: Context? = null
    }
    override fun onCreate() {
        super.onCreate()
        mContext = this
    }

}

val Any.context: Context
    get() = GankApplication.mContext!!

val Any.app
    get() = GankApplication.mContext!! as com.xiasuhuei321.gank_kotlin.GankApplication