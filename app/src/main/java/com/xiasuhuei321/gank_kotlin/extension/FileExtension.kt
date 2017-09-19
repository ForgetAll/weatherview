package com.xiasuhuei321.gank_kotlin.extension

import android.os.Environment
import com.xiasuhuei321.gank_kotlin.GankApplication
import com.xiasuhuei321.gank_kotlin.context
import com.xiasuhuei321.gank_kotlin.datasource.bean.CacheValues
import java.io.*

/**
 * Created by CoderFan on 2017/9/15.
 * desc:File 序列化读写
 */

/**
 * 序列化对象
 */

@Throws(IOException::class)
fun <T> serialize(t: T) {

}



/**
 * 外部存储路径检查
 */
fun checkDir():Boolean{
    return Environment.getExternalStorageDirectory().equals(Environment.MEDIA_MOUNTED)
}
