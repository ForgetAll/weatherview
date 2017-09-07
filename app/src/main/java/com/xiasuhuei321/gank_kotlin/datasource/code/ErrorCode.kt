package com.xiasuhuei321.gank_kotlin.datasource.code

/**
 * Created by Karl on 2017/9/7 0007.
 * desc:网络请求错误代码
 */
object ErrorCode{

    /**
     * 加载成功
     */
    val SUCCESS = 100

    /**
     * 连接超时
     */
    val CONNECT_TIME_OUT = 200

    /**
     * 网络异常
     */
    val NET_ERROR = 300

    /**
     * 本地缓存数据
     */
    val LOCAL_CACHE = 400

    /**
     * 服务器异常
     */
    val SEVER_ERROR = 500
}