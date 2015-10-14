package com.fuck.formoney.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.fuck.formoney.utils.log.Log;

public class InstallReceiver extends BroadcastReceiver {
    public InstallReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "install", Toast.LENGTH_LONG).show();
        if (intent == null) {
            return;
        }

        if (intent.getAction().equals(Intent.ACTION_PACKAGE_ADDED)) {
            String data = intent.getDataString();

            Toast.makeText(context, "install = " + data, Toast.LENGTH_LONG).show();
            Log.i("install", "install = " + data);

        }
    }
}
