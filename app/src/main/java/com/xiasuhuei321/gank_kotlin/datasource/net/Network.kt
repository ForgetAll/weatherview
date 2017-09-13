package com.xiasuhuei321.gank_kotlin.datasource.net

import android.util.Log
import com.xiasuhuei321.gank_kotlin.datasource.bean.API
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Karl on 2017/9/7 0007.
 * Retrofit Client
 */

object Network {

    private val retrofit:Retrofit
    private val okHttpClient:OkHttpClient

    init {
        val logging = Interceptor{chain ->
            val request = chain.request()
            Log.w("okhttp","okhttp--->"+request.url().toString())
            chain.proceed(request)
        }

        okHttpClient =
                OkHttpClient.Builder().addInterceptor(logging).build()

        retrofit =
                Retrofit.Builder()
                        .baseUrl(API.BASE_PATH)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(okHttpClient)
                        .build()


    }

    val service:ApiService by lazy { retrofit.create(ApiService::class.java) }

}

