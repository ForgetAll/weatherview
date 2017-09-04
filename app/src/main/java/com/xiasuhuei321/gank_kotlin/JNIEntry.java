package com.xiasuhuei321.gank_kotlin;

import android.graphics.Bitmap;

/**
 * Created by xiasuhuei321 on 2017/9/4.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */

public class JNIEntry {

    static {
        System.loadLibrary("image-lib");
    }

    public static Bitmap blur(Bitmap bmp) {
        int width = bmp.getWidth();
        int height = bmp.getHeight();
        int[] pixels = new int[width * height];
        bmp.getPixels(pixels, 0, width, 0, 0, width, height);
        blur(pixels, width, height, 10);
//        bmp.setPixels(pixels, 0, width, 0, 0, width, height);
        bmp.recycle();
        bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bmp.setPixels(pixels, 0, width, 0, 0, width, height);
        return bmp;
    }

    public static native void blur(int[] img, int width, int height, int radius);
}
