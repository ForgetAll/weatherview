package com.xiasuhuei321.gank_kotlin.customview.weather

import android.graphics.Canvas
import android.graphics.PointF
import com.xiasuhuei321.gank_kotlin.context
import com.xiasuhuei321.gank_kotlin.extension.getScreenWidth

/**
 * Created by xiasuhuei321 on 2017/9/7.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */
class WeatherShapePool {
    val constantRain = ArrayList<Rain>()
    val randomRain = ArrayList<Rain>()

    val constantSnow = ArrayList<Snow>()
    val randomSnow = ArrayList<Snow>()

    init {
        // 初始化
        initData()
        initSnow()
    }

    private fun initData() {
        val space = context.getScreenWidth() / 20
        var currentSpace = 0f
        // 将其均匀的分布在屏幕x方向上
        for (i in 0..19) {
            val rain = Rain(PointF(currentSpace, 0f), PointF(currentSpace, 0f))
            rain.originLength = 20f
            rain.originX = currentSpace
            constantRain.add(rain)
            currentSpace += space
        }

        for (j in 0..9) {
            val rain = Rain(PointF(0f, 0f), PointF(0f, 0f))
            rain.isRandom = true
            rain.originLength = 20f
            randomRain.add(rain)
        }
    }

    fun drawRain(canvas: Canvas) {
        for (r in constantRain) {
            r.draw(canvas)
        }
        for (r in randomRain) {
            r.draw(canvas)
        }
    }

    private fun initSnow(){
        val space = context.getScreenWidth() / 20
        var currentSpace = 0f
        // 将其均匀的分布在屏幕x方向上
        for (i in 0..19) {
            val snow = Snow(PointF(currentSpace, 0f), PointF(currentSpace, 0f))
            snow.originX = currentSpace
            snow.radius = 20f
            constantSnow.add(snow)
            currentSpace += space
        }

        for (j in 0..19) {
            val snow = Snow(PointF(0f, 0f), PointF(0f, 0f))
            snow.isRandom = true
            snow.radius = 20f
            randomSnow.add(snow)
        }
    }

    fun drawSnow(canvas: Canvas){
        for(r in constantSnow){
            r.draw(canvas)
        }

        for (r in randomSnow){
            r.draw(canvas)
        }
    }
}