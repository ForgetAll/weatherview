package com.xiasuhuei321.gank_kotlin;

/**
 * Created by xiasuhuei321 on 2017/9/5.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */

public class Test {
    public static void i(Object s) {
        System.out.println("调用了单个参数的方法");
    }

    public static void i(String tag,Object... contents){
        System.out.println("调用了两个参数的方法");
    }

}
