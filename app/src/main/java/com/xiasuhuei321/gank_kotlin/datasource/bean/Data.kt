package com.xiasuhuei321.gank_kotlin.datasource.bean

/**
 * Created by Karl on 2017/9/7 0007.
 * desc:数据
 */

data class JsonResult<T>(val error: Boolean, val results: T)

data class GankData(val _id: String,
                    val createAt: String,
                    val desc: String,
                    val publishedAt: String,
                    val source: String,
                    val type: String,
                    val url: String,
                    val used: Boolean,
                    val who: String){
    fun create() = createAt.substring(0,10)
}


data class City(val cityName: String,
                val cityEn: String)

data class Town(var townName: String,
                var townID: String,
                var townEn: String)