package com.fuck.formoney.utils;

import android.content.Context;
import android.widget.ImageView;

import com.fuck.formoney.widget.CircleTransform;
import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * 项目名称：ForMoney
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：15/8/27 下午5:04
 */
public class PicassoTools {

    public static void loadImage(Context context, String url, ImageView view, boolean circle) {
        //路径问题
        if (url.contains("storage")) {
            if (circle) {
                Picasso.with(context).load(new File(url)).transform(new CircleTransform()).placeholder(com.cmbb.smartkids.photopicker.R.drawable.ic_photo_black_48dp).fit()
                        .error(com.cmbb.smartkids.photopicker.R.drawable.ic_broken_image_black_48dp).into(view);
            } else {
                Picasso.with(context).load(new File(url)).placeholder(com.cmbb.smartkids.photopicker.R.drawable.ic_photo_black_48dp).fit()
                        .error(com.cmbb.smartkids.photopicker.R.drawable.ic_broken_image_black_48dp).into(view);
            }
        } else {
            if (circle) {
                Picasso.with(context).load(url).transform(new CircleTransform()).placeholder(com.cmbb.smartkids.photopicker.R.drawable.ic_photo_black_48dp).fit()
                        .error(com.cmbb.smartkids.photopicker.R.drawable.ic_broken_image_black_48dp).into(view);
            } else {
                Picasso.with(context).load(url).placeholder(com.cmbb.smartkids.photopicker.R.drawable.ic_photo_black_48dp).fit()
                        .error(com.cmbb.smartkids.photopicker.R.drawable.ic_broken_image_black_48dp).into(view);
            }
        }
    }

}
