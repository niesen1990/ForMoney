package com.fuck.formoney.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.fuck.formoney.R;
import com.fuck.formoney.activity.login.model.VerifyCodeModel;
import com.fuck.formoney.base.BaseActivity;
import com.fuck.formoney.base.Constants;
import com.fuck.formoney.network.OkHttpClientManager;
import com.fuck.formoney.utils.log.Log;
import com.squareup.okhttp.Request;

public class AuthPhotoRegistryActivity extends BaseActivity {

    private AppCompatEditText mEtLoginPhone;
    private TextView mBtnLogin;

    private void assignViews() {
        mEtLoginPhone = (AppCompatEditText) findViewById(R.id.et_login_phone);
        mBtnLogin = (TextView) findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(this);
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        assignViews();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_auth_photo_registry;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_login:
                handleRegisterRequest();
                break;
        }
    }

    private void handleRegisterRequest() {
        final String phone = mEtLoginPhone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            showShortToast("电话号码不能为空");
            return;
        }
        OkHttpClientManager.Param[] params = new OkHttpClientManager.Param[]{
                new OkHttpClientManager.Param("userPhone", phone)};
        OkHttpClientManager.postAsyn(Constants.LoginAndRegister.GETREGISTSECURITYCODE, params, new OkHttpClientManager.ResultCallback<VerifyCodeModel>() {
            @Override
            public void onError(Request request, Exception e) {
                e.printStackTrace();
                showShortToast("请检查网络");
            }

            @Override
            public void onResponse(VerifyCodeModel us) {
                Log.e("TAG", us.toString());
                showShortToast(us.getResultMsg());
                if (us.getStatusCode() == 200) {
                    Intent intent = new Intent(AuthPhotoRegistryActivity.this, RegisterActivity.class);
                    intent.putExtra("phone", phone);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.menu_auth_photo_registry, menu);
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
