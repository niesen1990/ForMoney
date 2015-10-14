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

public class ForgetActivity extends BaseActivity {

    private AppCompatEditText mEtForgetAuth;
    private AppCompatEditText mEtForgetPsw;
    private TextView mBtnForget;

    private void assignViews() {
        mEtForgetAuth = (AppCompatEditText) findViewById(R.id.et_forget_auth);
        mEtForgetPsw = (AppCompatEditText) findViewById(R.id.et_forget_psw);
        mBtnForget = (TextView) findViewById(R.id.btn_forget);
        mBtnForget.setOnClickListener(this);
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        assignViews();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_forget;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_forget:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.menu_forget, menu);
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
