package com.xiasuhuei321.gank_kotlin.base.basemvp

/**
 * Created by xiasuhuei321 on 2017/9/14.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */
interface BaseContract {
    interface Presenter {
        var v: View?
        fun initView(v: View){
            this.v = v
        }

        fun releaseView(){
            v = null
        }
    }

    interface View {
        var p: Presenter?
        fun initPresenter(p: Presenter){
            this.p = p
        }

        fun releasePresenter(){
            p = null
        }
    }
}