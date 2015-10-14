package com.fuck.formoney.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class UseTimeReceiver extends BroadcastReceiver {
    public UseTimeReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "install", Toast.LENGTH_LONG).show();
    }
}
