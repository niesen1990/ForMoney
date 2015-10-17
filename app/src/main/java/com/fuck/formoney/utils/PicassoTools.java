package com.fuck.formoney.utils;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * 项目名称：ForMoney
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：15/8/27 下午5:04
 */
public class PicassoTools {

    public static void loadImage(Context context, String url, ImageView view) {
        //路径问题
        if (url.contains("storage")) {
                Picasso.with(context).load(new File(url)).fit().into(view);
        } else {
                Picasso.with(context).load(url).fit().into(view);
        }
    }

}
