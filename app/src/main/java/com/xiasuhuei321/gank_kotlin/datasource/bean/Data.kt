package com.xiasuhuei321.gank_kotlin.datasource.bean

/**
 * Created by Karl on 2017/9/7 0007.
 * desc:数据
 */

data class JsonResult<T>(var error:Boolean, var results:T)

data class GankData(var _id:String,
                    var createAt:String,
                    var desc:String,
                    var publishedAt:String,
                    var source:String,
                    var type:String,
                    var url:String,
                    var used:Boolean,
                    var who:String)


