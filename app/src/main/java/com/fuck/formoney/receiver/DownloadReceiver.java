package com.fuck.formoney.receiver;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.widget.Toast;

import com.fuck.formoney.utils.download.DownloadTools;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DownloadReceiver extends BroadcastReceiver {

    private static Map<Long, String> models = new HashMap<>();

    public DownloadReceiver() {
    }


    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals("com.fuck.formoney.download.id")) {
            models.put(intent.getLongExtra("id", -1), intent.getStringExtra("name"));
        }

        if (intent.getAction().equals(DownloadManager.ACTION_DOWNLOAD_COMPLETE)) {
            long downId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
            for (Map.Entry<Long, String> entry : models.entrySet()) {
                if ((long) entry.getKey() == downId) {
                    Toast.makeText(context, entry.getValue() + "下载成功", Toast.LENGTH_LONG).show();
                    String apkFilePath = new StringBuilder(Environment
                            .getExternalStorageDirectory().getAbsolutePath())
                            .append(File.separator)
                            .append("M+")
                            .append(File.separator).append(entry.getValue())
                            .toString();

                    DownloadTools.install(context, apkFilePath);
                }
            }

        }
    }
}
