package com.fuck.formoney.activity.login;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.InputType;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.fuck.formoney.MainActivity;
import com.fuck.formoney.R;
import com.fuck.formoney.activity.login.model.RegisterModel;
import com.fuck.formoney.base.BaseActivity;
import com.fuck.formoney.base.BaseApplication;
import com.fuck.formoney.base.Constants;
import com.fuck.formoney.base.CustomListener;
import com.fuck.formoney.network.OkHttpClientManager;
import com.fuck.formoney.utils.CustomWatcher;
import com.fuck.formoney.utils.SPCache;
import com.fuck.formoney.utils.TDevice;
import com.fuck.formoney.utils.log.Log;
import com.fuck.formoney.utils.log.Tools;
import com.fuck.formoney.widget.CustomDialogBuilder;
import com.squareup.okhttp.Request;
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
                showBundlePhoneDialog(createPhoneView("请输入您的手机号码"));
                break;
            // weixin
            case R.id.btn_login_wx:
                showBundlePhoneDialog(createPhoneView("请输入您的手机号码"));
                break;
            // sina
            case R.id.btn_login_sina:
                showBundlePhoneDialog(createPhoneView("请输入您的手机号码"));
                break;
        }
    }


    private CustomDialogBuilder builder = null;

    private void showBundlePhoneDialog(View view) {
        int width = TDevice.getScreenWidth(this) * 3 / 4;
        builder = CustomDialogBuilder.getInstance(this).setDialogWindows(width, ViewGroup.LayoutParams.WRAP_CONTENT).isCancelableOnTouchOutside(false);

        builder.withTitle("绑定手机号码")
                .withMessageMiss(View.GONE)
                .withCustomContentView(view, this)
                .withCancelText("取消", new CustomListener.DialogListener() {
                    @Override
                    public void onClick(View v) {
                        builder.dismiss();
                    }
                }).withComfirmText("确定", new CustomListener.DialogListener() {
            @Override
            public void onClick(View v) {
                String phone = etPhone.getText().toString();
                String verify = etVerify.getText().toString();
                if (TextUtils.isEmpty(phone) || !Tools.isMobileNo(phone)) {
                    showShortToast("手机号码格式不正确");
                    return;
                }
                if (TextUtils.isEmpty(verify)) {
                    showShortToast("验证码不能为空");
                    return;
                }
                changePhoneRequest(phone, verify);
            }
        });
        builder.show();
    }

    /**
     * verify phone number
     * @param phone
     * @param verify
     */
    private void changePhoneRequest(String phone, String verify) {

    }

    private EditText etChange, etPhone, etVerify;
    private TextView tvVerify;
    /**
     * 修改手机号弹窗
     *
     * @param tip
     * @return
     */
    private View createPhoneView(String tip) {
        View view = getLayoutInflater().inflate(R.layout.view_modify_phone, null);
        etPhone = (EditText) view.findViewById(R.id.et_phone);
        ImageView ivClear = (ImageView) view.findViewById(R.id.iv_phone_clear);
        tvVerify = (TextView) view.findViewById(R.id.tv_verify);
        etVerify = (EditText) view.findViewById(R.id.et_verify);
        etPhone.setHint(tip);
        etPhone.setInputType(InputType.TYPE_CLASS_NUMBER);
        new CustomWatcher(etPhone, ivClear);
        tvVerify.setOnClickListener(this);
        return view;
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
        showWaitDialog("登陆中...");
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
                hideWaitDialog();
            }

            @Override
            public void onResponse(RegisterModel us) {
                hideWaitDialog();
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
