package com.fuck.formoney.activity.setting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fuck.formoney.R;
import com.fuck.formoney.activity.login.LoginActivity;
import com.fuck.formoney.base.BaseActivity;
import com.fuck.formoney.base.BaseApplication;
import com.fuck.formoney.utils.SPCache;

public class SettingActivity extends BaseActivity {

    private TextView btnAccount;

    @Override
    protected void init(Bundle savedInstanceState) {
        initView();
    }

    private void initView() {
        btnAccount = (TextView) findViewById(R.id.btn_account);
        btnAccount.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_account:
                SPCache.clear();
                BaseApplication.token = "";
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
