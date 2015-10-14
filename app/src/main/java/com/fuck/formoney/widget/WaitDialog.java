package com.fuck.formoney.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.fuck.formoney.R;


/**
 * Created by javon on 2015/8/7.
 */
public class WaitDialog extends Dialog {
    private TextView tvMessage;


    public WaitDialog(Context context) {
        super(context);
        init();
    }

    private void init() {
        setCancelable(true);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        View root = getLayoutInflater().inflate(R.layout.custom_progress_bar, null);
        tvMessage = (TextView) root.findViewById(R.id.tv_wait_message);
        setContentView(root);
    }

    public void setMessage(String message) {
        if (this != null) {
            tvMessage.setText(message);
        }
    }

}
