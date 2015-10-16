package com.fuck.formoney.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.fuck.formoney.MainActivity;
import com.fuck.formoney.R;
import com.fuck.formoney.activity.login.model.RegisterModel;
import com.fuck.formoney.activity.login.model.VerifyCodeModel;
import com.fuck.formoney.base.BaseActivity;
import com.fuck.formoney.base.BaseApplication;
import com.fuck.formoney.base.Constants;
import com.fuck.formoney.network.OkHttpClientManager;
import com.fuck.formoney.utils.SPCache;
import com.fuck.formoney.utils.TDevice;
import com.fuck.formoney.utils.log.Log;
import com.squareup.okhttp.Request;

public class RegisterActivity extends BaseActivity {

    private AppCompatEditText mEtRegisterAuth;
    private AppCompatEditText mEtRegisterPsw;
    private AppCompatEditText mEtRegisterName;
    private TextView mBtnRegister;

    private void assignViews() {
        mEtRegisterAuth = (AppCompatEditText) findViewById(R.id.et_register_auth);
        mEtRegisterPsw = (AppCompatEditText) findViewById(R.id.et_register_psw);
        mEtRegisterName = (AppCompatEditText) findViewById(R.id.et_register_name);
        mBtnRegister = (TextView) findViewById(R.id.btn_register);
        mBtnRegister.setOnClickListener(this);
    }

    String phone = "";

    @Override
    protected void init(Bundle savedInstanceState) {
        phone = getIntent().getStringExtra("phone");
        assignViews();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_register:
                handleRegisterRequest();

                break;
        }
    }

    private void handleRegisterRequest() {
        final String auth = mEtRegisterAuth.getText().toString().trim();
        final String psw = mEtRegisterPsw.getText().toString().trim();
        final String nick = mEtRegisterName.getText().toString().trim();
        if (TextUtils.isEmpty(auth)) {
            showShortToast("验证码不能为空");
            return;
        }
        if (TextUtils.isEmpty(psw)) {
            showShortToast("密码不能为空");
            return;
        }
        if (TextUtils.isEmpty(nick)) {
            showShortToast("昵称不能为空");
            return;
        }
        OkHttpClientManager.Param[] params = new OkHttpClientManager.Param[]{
                new OkHttpClientManager.Param("userPhone", phone),
                new OkHttpClientManager.Param("smsCodeKey", auth),
                new OkHttpClientManager.Param("loginPassword", psw),
                new OkHttpClientManager.Param("device", "2"),
                new OkHttpClientManager.Param("deviceVersion", android.os.Build.VERSION.RELEASE),
                new OkHttpClientManager.Param("model", android.os.Build.MODEL),
                new OkHttpClientManager.Param("imei", TDevice.getDeviceId(this)),
                new OkHttpClientManager.Param("userNike", nick),
                new OkHttpClientManager.Param("applicationVersion", TDevice.getVersionName())};
        OkHttpClientManager.postAsyn(Constants.LoginAndRegister.REGISTER, params, new OkHttpClientManager.ResultCallback<RegisterModel>() {
            @Override
            public void onError(Request request, Exception e) {
                e.printStackTrace();
                showShortToast("请检查网络");
            }

            @Override
            public void onResponse(RegisterModel us) {
                Log.e("TAG", us.toString());
                showShortToast(us.getResultMsg());
                if (us.getStatusCode() == 200) {
                    // Sp数据保存
                    BaseApplication.token = us.getTokenId();

                    SPCache.putString(Constants.SharePreference.USER_TOKEN, us.getTokenId());
                    SPCache.putInt(Constants.SharePreference.USER_STATUS, us.getData().getUserStatus());
                    SPCache.putString(Constants.SharePreference.USER_HEAD_IMAGE, us.getData().getUserSmallHeadImgUrl());
                    SPCache.putString(Constants.SharePreference.USER_NICK, us.getData().getUserNick());
                    SPCache.putString(Constants.SharePreference.USER_PROFESSION, us.getData().getUserProfession());
                    SPCache.putString(Constants.SharePreference.USER_PHONE, us.getData().getUserPhone());
                    SPCache.putString(Constants.SharePreference.USER_SEX, us.getData().getUserSex());
                    SPCache.putString(Constants.SharePreference.USER_BIRTHDAY, us.getData().getUserBirthday());
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.menu_register, menu);
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
