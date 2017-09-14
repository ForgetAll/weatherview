package com.xiasuhuei321.gank_kotlin.extension;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by xiasuhuei321 on 2017/9/13.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */

@GlideModule
public class GlideAppModule extends AppGlideModule {
    // 缩略图最小像素
    private static final int MIN_THUMB_SIZE = 100;

    @GlideOption
    public static void miniThumb(RequestOptions options) {
        options.fitCenter().override(MIN_THUMB_SIZE);
    }


}
