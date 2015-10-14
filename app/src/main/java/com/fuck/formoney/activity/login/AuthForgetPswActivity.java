package com.fuck.formoney.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.fuck.formoney.R;
import com.fuck.formoney.base.BaseActivity;

public class AuthForgetPswActivity extends BaseActivity {

    private AppCompatEditText mEtForgetPhone;
    private TextView mBtnForgetAuth;

    private void assignViews() {
        mEtForgetPhone = (AppCompatEditText) findViewById(R.id.et_forget_phone);
        mBtnForgetAuth = (TextView) findViewById(R.id.btn_forget_auth);
        mBtnForgetAuth.setOnClickListener(this);
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        assignViews();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_forget_auth:
                Intent intent = new Intent(this, ForgetActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_auth_forget_psw;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // getMenuInflater().inflate(R.menu.menu_auth_forget_psw, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
