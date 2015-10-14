package com.fuck.formoney.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class RegisterReceiver extends BroadcastReceiver {
    public RegisterReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "register", Toast.LENGTH_LONG).show();

    }
}
