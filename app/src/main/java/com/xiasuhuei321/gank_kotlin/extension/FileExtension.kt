package com.xiasuhuei321.gank_kotlin.extension

import android.os.Environment
import com.xiasuhuei321.gank_kotlin.GankApplication
import com.xiasuhuei321.gank_kotlin.context
import com.xiasuhuei321.gank_kotlin.datasource.bean.CacheValues
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.ObjectOutputStream

/**
 * Created by CoderFan on 2017/9/15.
 * desc:File 序列化读写
 */

/**
 * 序列化对象
 */
@Throws(IOException::class)
fun <T> setSerializable(t: T) {
//    if (checkDir()){
//        val oos:ObjectOutputStream
//        try {
//            val file = File(Environment.getExternalStorageDirectory(),CacheValues.FILE_NAME)
//            if (!file.exists())file.createNewFile()
//            val fos = FileOutputStream(file)
//
//            oos.writeObject(t)
//        }catch (e:IOException){
//            e.printStackTrace()
//        }finally {
//            oos.close()
//        }
//    }
}

/**
 * 外部存储路径检查
 */
fun checkDir():Boolean{
    return Environment.getExternalStorageDirectory().equals(Environment.MEDIA_MOUNTED)
}
