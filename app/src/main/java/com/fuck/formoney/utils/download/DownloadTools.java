package com.fuck.formoney.utils.download;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.io.File;

/**
 * 项目名称：ForMoney
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：15/9/8 下午8:00
 */
public class DownloadTools {

    /**
     * 系统下载起
     *
     * @param context Context
     * @param url     下载连接
     * @return long 文件标识ID
     */
    public static long downloadApk(Context context, String url, String name) {
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setDestinationInExternalPublicDir("M+", name);
        request.setTitle("萌宝派");
        request.setDescription("上海至臻文欢传媒股份有限公司");
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI);
        return downloadManager.enqueue(request);
    }


    public static boolean install(Context context, String filePath) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        File file = new File(filePath);
        if (file != null && file.length() > 0 && file.exists() && file.isFile()) {
            i.setDataAndType(Uri.parse("file://" + filePath), "application/vnd.android.package-archive");
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
            return true;
        }
        return false;
    }

}
