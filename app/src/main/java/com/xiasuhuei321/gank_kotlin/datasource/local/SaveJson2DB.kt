package com.xiasuhuei321.gank_kotlin.datasource.local

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteCursorDriver
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteQuery
import com.xiasuhuei321.gank_kotlin.context
import com.xiasuhuei321.gank_kotlin.datasource.bean.Town
import com.xiasuhuei321.gank_kotlin.extension.io_main
import io.reactivex.Flowable
import io.reactivex.FlowableSubscriber
import org.json.JSONArray
import org.reactivestreams.Publisher
import java.util.HashMap
import kotlin.collections.ArrayList

/**
 * Created by xiasuhuei321 on 2017/9/14.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */

fun LocalDataSource.saveCity(dbName: String, jsonStr: String, observer: FlowableSubscriber<HashMap<String, List<Town>>>) {
    val cityArray = JSONArray(jsonStr)
    val dbHelper = WeatherDBHelper(context, dbName, null, 1)
    val db = dbHelper.writableDatabase
    // 暂时是空实现，意图是读一遍，将之写入数据库，然后在这个过程中，也存入内存
    // 这里考虑稳定性用强引用，后续使用可以用 WeakReference
    var map = readTownList()
    var townList: ArrayList<Town> = ArrayList()
    Flowable.just(cityArray)
            .concatMap {
                i ->
                Publisher<HashMap<String, List<Town>>> {
                    j ->
                    (0..(i.length() - 1)).map { i.getJSONObject(it) }.forEach {
                        // 这里存在重复插入的问题
                        val cityName = it.optString(WeatherDBHelper.cityName)
                        if (map[cityName] == null) {
                            // 说明还不存在
                            dbHelper.insertIntoCity(cityName,
                                    it.optString(WeatherDBHelper.cityEN), db)
                            townList = ArrayList<Town>()
                            map.put(cityName, townList)
                        }
                        val townName = it.optString(WeatherDBHelper.townName)
                        val townID = it.optString(WeatherDBHelper.townID)
                        val townEN = it.optString(WeatherDBHelper.townEN)
                        val town = Town(townName, townID, townEN)
                        dbHelper.insertIntoTown(cityName,
                                town.townName,
                                town.townID,
                                town.townEn, db)
                        townList.add(town)
                    }
                    j.onNext(map)
                    j.onComplete()
                }
            }.io_main()
            .subscribe(observer)
}

fun LocalDataSource.readTownList(): HashMap<String, List<Town>> {
    var map = HashMap<String, List<Town>>()
    return map
}

class WeatherDBHelper(context: Context?, name: String?, factory: ((db: SQLiteDatabase, masterQuery: SQLiteCursorDriver, editTable: String, query: SQLiteQuery) -> Cursor)?, version: Int)
    : SQLiteOpenHelper(context, name, factory, version) {
    private val CREATE_TABLE_CITY = "CREATE TABLE `city`(`cityName` text primary key,`cityEn` text not null);"
    private val CREATE_TABLE_TOWER = "CREATE TABLE `town`(`townID` text primary key,`townEn` text not null,`townName` text not null," +
            "`cityName` text not null);"

    companion object {
        val ID = "ID"
        val cityName = "cityName"
        val cityEN = "cityEN"
        val townID = "townID"
        val townName = "townName"
        val townEN = "townEN"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(CREATE_TABLE_CITY)
        db.execSQL(CREATE_TABLE_TOWER)
    }

    fun insertIntoCity(city: String, cityen: String, db: SQLiteDatabase): Long {
        val values = ContentValues()
        values.put(cityName, city)
        values.put(cityEN, cityen)
        return db.insert("city", null, values)
    }

    fun insertIntoTown(city: String, town: String, townId: String, townen: String, db: SQLiteDatabase): Long {
        val values = ContentValues()
        values.put(townID, townId)
        values.put(townEN, townen)
        values.put(cityName, city)
        values.put(townName, town)
        return db.insert("town", null, values)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}