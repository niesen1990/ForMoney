package com.fuck.formoney.base;

import android.view.View;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/11 15:32
 */
public class CustomListener {
    public interface DialogListener {
        void onClick(View v);
    }

    public interface NetWorkListener {

        /**
         * 网络请求失败
         *
         * @param request
         * @param e
         */
        void onFailuerListener(Request request, IOException e);

        /**
         * 网络请求成功
         *
         * @param response
         */
        void onSuccessListener(Response response);

    }
}
