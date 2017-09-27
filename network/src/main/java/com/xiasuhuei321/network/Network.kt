package com.xiasuhuei321.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient

/**
 * Created by xiasuhuei321 on 2017/9/25.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */
object Network {
    /**
     * get、post、设置url
     */

    private val okhttpClient: OkHttpClient

    init {
        val logging = Interceptor {
            chain ->
            val request = chain.request()

            chain.proceed(request)

        }
        okhttpClient = OkHttpClient.Builder().addInterceptor(logging).build()
    }

}