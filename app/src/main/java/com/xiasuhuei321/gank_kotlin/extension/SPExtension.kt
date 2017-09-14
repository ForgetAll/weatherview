package com.xiasuhuei321.gank_kotlin.extension

import com.xiasuhuei321.gank_kotlin.GankApplication
import com.xiasuhuei321.gank_kotlin.context
import com.xiasuhuei321.gank_kotlin.datasource.bean.CacheValues

/**
 * Created by CoderFan on 2017/9/14.
 * desc:本地存储
 */

/**
 * 存入数据
 */
fun <T> putSPValue(key: String, value: T) {
    val sp = GankApplication.context.getSharedPreferences(CacheValues.SP_CONFIG_NAME, 0x0000)
    val edit = sp.edit()
    when (value) {
        is Boolean -> edit.putBoolean(key, value)
        is String -> edit.putString(key, value)
        is Long -> edit.putLong(key, value)
        is Float -> edit.putFloat(key, value)
        is Int -> edit.putInt(key, value)
        else -> throw IllegalArgumentException("u can'y use this type")
    }
    edit.apply()
}

/**
 * 取出数据
 */
fun getSPValues(key: String, default: Any): Any {
    val sp = GankApplication.context.getSharedPreferences(CacheValues.SP_CONFIG_NAME, 0x0000)
    return when (default) {
        is Boolean -> sp.getBoolean(key, default)
        is String -> sp.getString(key, default)
        is Long -> sp.getLong(key, default)
        is Float -> sp.getFloat(key, default)
        is Int -> sp.getInt(key, default)
        else -> throw IllegalArgumentException("u can't use this type")
    }
}

/**
 * 检查key是否存在
 */
fun checkSPKeys(key: String):Boolean{
    val sp = GankApplication.context
            .getSharedPreferences(CacheValues.SP_CONFIG_NAME, 0x0000)
    return sp.contains(key)
}

/**
 * 清除指定数据
 */
fun clearSPCache(key: String) {
    val sp = GankApplication.context
            .getSharedPreferences(CacheValues.SP_CONFIG_NAME, 0x0000)
    if (sp.contains(key)){
        sp.edit().remove(key).apply()
    }
}

/**
 * 清除所有数据
 */
fun clearSPCache() = GankApplication.context
        .getSharedPreferences(CacheValues.SP_CONFIG_NAME, 0x0000)
        .edit()
        .clear()
        .apply()


