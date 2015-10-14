package com.fuck.formoney.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.fuck.formoney.MainActivity;
import com.fuck.formoney.R;
import com.fuck.formoney.activity.login.LoginActivity;
import com.fuck.formoney.base.BaseActivity;
import com.fuck.formoney.base.BaseApplication;
import com.fuck.formoney.base.Constants;
import com.fuck.formoney.utils.SPCache;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends BaseActivity {


    @Override
    protected void init(Bundle savedInstanceState) {
        initTask();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    private void initTask() {
        // 引导界面
        final boolean isFirstInto = SPCache.getBoolean(Constants.SharePreference.IS_FIRST_INTO, true);
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                /*if (isFirstInto) {
                    //startActivity(new Intent(SplashActivity.this, GuideActivity.class));
                    finish();
                } else {
                    if (TextUtils.isEmpty(BaseApplication.token)) {
                        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(intent);
                    } else {
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    }
                    finish();
                }*/

                if (TextUtils.isEmpty(BaseApplication.token)) {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                }
                finish();
            }
        };
        timer.schedule(timerTask, 1500);
    }
}
