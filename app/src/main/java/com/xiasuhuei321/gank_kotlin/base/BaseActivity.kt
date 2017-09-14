package com.xiasuhuei321.gank_kotlin.base

import android.support.v7.app.AppCompatActivity
import com.xiasuhuei321.gank_kotlin.base.basemvp.BaseContract

/**
 * Created by xiasuhuei321 on 2017/9/14.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */
abstract class BaseActivity : AppCompatActivity(){
    abstract fun getPresenter(): BaseContract.Presenter

    override fun onDestroy() {
        val presenter = getPresenter()
        presenter.releaseView()
        super.onDestroy()
    }
}