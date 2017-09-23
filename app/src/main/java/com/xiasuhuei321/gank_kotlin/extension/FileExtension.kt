package com.xiasuhuei321.gank_kotlin.extension

import com.xiasuhuei321.gank_kotlin.GankApplication
import com.xiasuhuei321.gank_kotlin.context
import com.xiasuhuei321.gank_kotlin.datasource.bean.CacheValues
import java.io.*

/**
 * Created by CoderFan on 2017/9/15.
 * desc:File 序列化读写
 */

/**
 * write cache file
 */
fun write2File(content:Any){
    write2File(CacheValues.DEFAULT_FILE_NAME,content)
}

/**
 * write cache file with key
 */

@Throws(IOException::class)
fun  write2File(fileName:String, content: Any) {
    val fos = FileOutputStream(File(GankApplication.context.filesDir , fileName))
    val oos = ObjectOutputStream(fos)
    oos.writeObject(content)
    write2FileCount(fileName)
    oos.close()
}

/**
 * read cache
 */
fun readCacheFile():Any?{
    return readCacheFile(CacheValues.DEFAULT_FILE_NAME)
}

/**
 * read cache with key
 *
 */
@Throws(IOException::class)
fun readCacheFile(fileName: String): Any? {
    val file = File(GankApplication.context.filesDir,fileName)
    if (!file.exists()){
        file.createNewFile()
    }
    if (file.length() == 0L){
        return null
    }
    val fis = FileInputStream(file)
    val ois = ObjectInputStream(fis)
    val result = ois.readObject()
    ois.close()
    return result
}

/**
 * delete default cache
 */
fun deleteCacheFile() : Boolean{
    return deleteCacheFile(CacheValues.DEFAULT_FILE_NAME)
}

/**
 * delete all cache
 */
fun deleteAllCacheFile(){
    val list = readFileCount()
    for(name in list){
        deleteFile(name)
    }
}

/**
 * delete cache with key
 */
fun deleteCacheFile(fileName: String):Boolean{
    return when(deleteFile(fileName)){
        true -> {
            deleteFileCount(fileName)
            true
        }
        false -> {
            false
        }
    }

}

/**
 * delete cache count
 */
private fun deleteFileCount(fileName: String){
    deleteFile(fileName)
}

/**
 * delete cache
 */
private fun deleteFile(fileName: String):Boolean{
    val file = File(GankApplication.context.filesDir,fileName)
    return file.exists() && file.delete()
}

/**
 * write count to cache
 */
private fun write2FileCount(fileName: String){
    val local = readCacheFile(CacheValues.DEFAULT_FILE_COUNT)
    if (local==null){
        write2File(CacheValues.DEFAULT_FILE_COUNT,fileName)
    }else{
        val contents = readCacheFile(CacheValues.DEFAULT_FILE_COUNT).toString()
        write2File(CacheValues.DEFAULT_FILE_COUNT,contents+","+fileName)
    }
}

/**
 * read count
 */
private fun readFileCount():List<String>{
    return readCacheFile(CacheValues.DEFAULT_FILE_COUNT).toString().split(",")
}

