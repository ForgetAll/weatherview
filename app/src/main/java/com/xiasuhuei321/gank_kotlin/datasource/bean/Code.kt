package com.xiasuhuei321.gank_kotlin.datasource.bean

/**
 * Created by Karl on 2017/9/11 0011.
 * desc: 一些code集合
 */


/**
 * 请求API
 */
object API {

    const val BASE_PATH = "http://gank.io/api/"
    //搜索API
    const val SEARCH = "search/query/listview/category/"

    //获取历史数据
    const val HISTORY = "history/content/"

    //获取分类
    const val DATA = "data/"

    //每日数据
    const val DAY_DATA = "day/"

    //随机数据
    const val RANDOM_DATA = "random/data/"


}

/**
 * 请求类型
 */
object PostType {

    // 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all

    val WELFARE = "福利"
    val ANDROID = "Android"
    val IOS = "iOS"
    val FRONT = "前端"
    val ALL = "all"

    val VIDEO = "休息视频"
    val MORE = "拓展资源"
}

/**
 * 请求响应代码
 */
object ResponseCode {
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

object CacheValues{

    val SP_CONFIG_NAME = "GankKotlin"

    val FILE_NAME = "GankFile"
}
