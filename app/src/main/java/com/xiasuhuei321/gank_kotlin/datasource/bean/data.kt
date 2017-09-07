package com.xiasuhuei321.gank_kotlin.datasource.bean

/**
 * Created by Karl on 2017/9/7 0007.
 * desc:数据
 */

data class JsonResult<T>(val error:Boolean, val results:T)
