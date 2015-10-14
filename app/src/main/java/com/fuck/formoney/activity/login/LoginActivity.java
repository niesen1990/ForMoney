package com.fuck.formoney.activity.login;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fuck.formoney.MainActivity;
import com.fuck.formoney.R;
import com.fuck.formoney.activity.login.model.RegisterModel;
import com.fuck.formoney.base.BaseActivity;
import com.fuck.formoney.base.BaseApplication;
import com.fuck.formoney.base.Constants;
import com.fuck.formoney.network.OkHttpClientManager;
import com.fuck.formoney.utils.SPCache;
import com.fuck.formoney.utils.TDevice;
import com.fuck.formoney.utils.log.Log;
import com.squareup.okhttp.Request;
import com.umeng.message.ALIAS_TYPE;
import com.umeng.message.IUmengRegisterCallback;

public class LoginActivity extends BaseActivity {


    private static final String TAG = LoginActivity.class.getSimpleName();
    private AppCompatEditText mEtLoginPhone;
    private AppCompatEditText mEtLoginPsw;
    private TextView mBtnLogin;
    private TextView mBtnGoRegister;
    private TextView mBtnForgetPassword;
    private ImageView mBtnLoginQq;
    private ImageView mBtnLoginWx;
    private ImageView mBtnLoginSina;

    private void assignViews() {
        mEtLoginPhone = (AppCompatEditText) findViewById(R.id.et_login_phone);
        mEtLoginPsw = (AppCompatEditText) findViewById(R.id.et_login_psw);
        mBtnLogin = (TextView) findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(this);
        mBtnGoRegister = (TextView) findViewById(R.id.btn_go_register);
        mBtnGoRegister.setOnClickListener(this);
        mBtnForgetPassword = (TextView) findViewById(R.id.btn_forget_password);
        mBtnForgetPassword.setOnClickListener(this);
        mBtnLoginQq = (ImageView) findViewById(R.id.btn_login_qq);
        mBtnLoginQq.setOnClickListener(this);
        mBtnLoginWx = (ImageView) findViewById(R.id.btn_login_wx);
        mBtnLoginWx.setOnClickListener(this);
        mBtnLoginSina = (ImageView) findViewById(R.id.btn_login_sina);
        mBtnLoginSina.setOnClickListener(this);
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        // 注册Push
        registerUmengMessage();
        assignViews();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        Intent intent;
        switch (v.getId()) {
            // 登陆
            case R.id.btn_login:
                handleLoginRequest();
                break;
            // 注册
            case R.id.btn_go_register:
                intent = new Intent(this, AuthPhotoRegistryActivity.class);
                startActivity(intent);
                break;
            // 忘记密码
            case R.id.btn_forget_password:
                intent = new Intent(this, AuthForgetPswActivity.class);
                startActivity(intent);
                break;
            // QQ
            case R.id.btn_login_qq:
                break;
            // weixin
            case R.id.btn_login_wx:
                break;
            // sina
            case R.id.btn_login_sina:
                break;
        }
    }

    private void handleLoginRequest() {
        final String phone = mEtLoginPhone.getText().toString().trim();
        final String psw = mEtLoginPsw.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            showShortToast("手机号码不能为空");
            return;
        }
        if (TextUtils.isEmpty(psw)) {
            showShortToast("密码不能为空");
            return;
        }
        OkHttpClientManager.Param[] params = new OkHttpClientManager.Param[]{
                new OkHttpClientManager.Param("userPhone", phone),
                new OkHttpClientManager.Param("loginPassword", psw),
                new OkHttpClientManager.Param("device", "2"),
                new OkHttpClientManager.Param("deviceVersion", android.os.Build.VERSION.RELEASE),
                new OkHttpClientManager.Param("modelModel", android.os.Build.MODEL),
                new OkHttpClientManager.Param("modelImei", TDevice.getDeviceId(this)),
                new OkHttpClientManager.Param("thirdAccountType", "0"),
                new OkHttpClientManager.Param("applicationVersion", TDevice.getVersionName())};
        OkHttpClientManager.postAsyn(Constants.LoginAndRegister.LOGIN, params, new OkHttpClientManager.ResultCallback<RegisterModel>() {
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
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.menu_login, menu);
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

    /**
     * 注册Push
     */


            /*{4
                "resultMsg": "注册成功！",
                    "statusCode": 200,
                    "tokenId": "C53E0240E9C441AEBE5E50213E351521",
                    "appPushToken": "97f61883-221d-476e-b8fe-e3e2514e627e"
            }*/

            /*{2
                "resultMsg": "注册成功！",
                    "statusCode": 200,
                    "tokenId": "AED8AC6D8FBB42EBB49D92BC1E8F8D2D",
                    "appPushToken": "86804150-8f90-42f2-bd53-52a49d703788"
            }*/
    private void registerUmengMessage() {
        mPushAgent.enable(mRegisterCallback);

    }


    // 友盟推送注册器
    private IUmengRegisterCallback mRegisterCallback = new IUmengRegisterCallback() {

        @Override
        public void onRegistered(String registrationId) {
            // Umeng Push Token
            Log.e("mRegisterCallback", "token:" + mPushAgent.getRegistrationId());
            // 注册Alias
            new AddAliasTask("97f61883221d476eb8fee3e2514e627", "MEIZU").execute();
        }
    };

    class AddAliasTask extends AsyncTask<Void, Void, Boolean> {

        String alias;
        String aliasType;

        public AddAliasTask(String aliasString, String aliasTypeString) {
            this.alias = aliasString;
            this.aliasType = aliasTypeString;
        }

        protected Boolean doInBackground(Void... params) {
            try {
                /*&& mPushAgent.addExclusiveAlias(alias, aliasType)*/
                return mPushAgent.addAlias(alias, aliasType) && mPushAgent.addExclusiveAlias(alias, aliasType);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (Boolean.TRUE.equals(result))
                Log.i(TAG, "alias was set successfully.");
        }

    }
}
