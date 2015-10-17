package com.fuck.formoney.activity.user;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.cmbb.smartkids.mengbottomsheets.BottomSheet;
import com.cmbb.smartkids.photopicker.PhotoPickerActivity;
import com.cmbb.smartkids.photopicker.utils.PhotoPickerIntent;
import com.fuck.formoney.R;
import com.fuck.formoney.activity.login.model.RegisterModel;
import com.fuck.formoney.base.BaseActivity;
import com.fuck.formoney.base.BaseApplication;
import com.fuck.formoney.base.Constants;
import com.fuck.formoney.network.OkHttpClientManager;
import com.fuck.formoney.utils.PicassoTools;
import com.fuck.formoney.utils.SPCache;
import com.fuck.formoney.utils.log.Log;
import com.squareup.okhttp.Request;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class InfoEditActivity extends BaseActivity {


    private AppBarLayout mAppbar;
    private CollapsingToolbarLayout mCollapsingToolbar;
    private Toolbar mToolbar;
    private CardView mCv01;
    private AppCompatEditText mEtName;
    private CardView mCv02;
    private AppCompatTextView mBtnGender;
    private CardView mCv03;
    private AppCompatTextView mBtnBirthday;
    private CardView mCv04;
    private AppCompatEditText mEtJob;
    private ImageView ivHead;
    private TextView mBtnSubmit;

    private int g_sex = -1;

    private void assignViews() {
        mAppbar = (AppBarLayout) findViewById(R.id.appbar);
        mCollapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mCv01 = (CardView) findViewById(R.id.cv_01);
        mEtName = (AppCompatEditText) findViewById(R.id.et_name);
        mCv02 = (CardView) findViewById(R.id.cv_02);
        mBtnGender = (AppCompatTextView) findViewById(R.id.btn_gender);
        mBtnGender.setOnClickListener(this);
        mCv03 = (CardView) findViewById(R.id.cv_03);
        mBtnBirthday = (AppCompatTextView) findViewById(R.id.btn_birthday);
        mBtnBirthday.setOnClickListener(this);
        mCv04 = (CardView) findViewById(R.id.cv_04);
        mEtJob = (AppCompatEditText) findViewById(R.id.et_job);
        ivHead = (ImageView) findViewById(R.id.iv_head);
        ivHead.setOnClickListener(this);
        mBtnSubmit = (TextView) findViewById(R.id.btn_submit);
        mBtnSubmit.setOnClickListener(this);
    }


    @Override
    protected void init(Bundle savedInstanceState) {
        assignViews();
        initData();
    }

    String image;
    String nick;
    String sex;
    String birthday;
    String profession;

    private void initData() {
        image = SPCache.getString(Constants.SharePreference.USER_HEAD_IMAGE, "");
        nick = SPCache.getString(Constants.SharePreference.USER_NICK, "");
        sex = SPCache.getString(Constants.SharePreference.USER_SEX, "");
        birthday = SPCache.getString(Constants.SharePreference.USER_BIRTHDAY, "");
        profession = SPCache.getString(Constants.SharePreference.USER_PROFESSION, "");
        if (!TextUtils.isEmpty(image)) {
            PicassoTools.loadImage(this, image, ivHead);
        }
        if (!TextUtils.isEmpty(nick)) {
            mEtName.setText(nick);
        }
        if (!TextUtils.isEmpty(sex)) {
            mBtnGender.setText(sex);
        }
        if (!TextUtils.isEmpty(birthday)) {
            mBtnBirthday.setText(birthday);
        }
        if (!TextUtils.isEmpty(profession)) {
            mEtJob.setText(profession);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_info_edit;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_birthday:
                Calendar myCalendar = Calendar.getInstance(Locale.CHINA);
                new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        monthOfYear = monthOfYear + 1;
                        String monthOfYears;
                        if (monthOfYear < 10) {
                            monthOfYears = "0" + monthOfYear;
                        } else {
                            monthOfYears = monthOfYear + "";
                        }
                        mBtnBirthday.setText(year + "-" + monthOfYears + "-" + dayOfMonth);
                    }
                }, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                break;
            case R.id.btn_gender:
                BottomSheet bottomSheet = new BottomSheet.Builder(this).title("选择性别").sheet(R.menu.menu_gender).listener(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        switch (which) {
                            case R.id.action_boy:
                                mBtnGender.setText("男");
                                g_sex = 1;
                                break;
                            case R.id.action_girl:
                                mBtnGender.setText("女");
                                g_sex = 2;
                                break;
                        }
                    }
                }).build();
                bottomSheet.show();
                break;
            case R.id.iv_head:
                PhotoPickerIntent intent = new PhotoPickerIntent(InfoEditActivity.this);
                intent.setPhotoCount(1);
                startActivityForResult(intent, REQUEST_CODE);
                break;
            case R.id.btn_submit:
                handleInfoRequest();
                break;
        }
    }

    private void handleInfoRequest() {
        String nick = mEtName.getText().toString().trim();
        String bir = mBtnBirthday.getText().toString().trim();
        String pro = mEtJob.getText().toString().trim();
        Map<String, String> params = new HashMap<>();
        params.put("tokenId", BaseApplication.token);
        if (!TextUtils.isEmpty(nick)) {
            params.put("userNick", nick);
        }
        if (g_sex != -1) {
            params.put("userSex", g_sex + "");
        }
        if (!TextUtils.isEmpty(bir)) {
            params.put("userBirthday", bir);
        }
        if (!TextUtils.isEmpty(pro)) {
            params.put("userProfession", pro);
        }
        File file = null;
        if (imgs.size() > 0) {
            file = new File(imgs.get(0));
        }
        OkHttpClientManager.postAsyn(Constants.UserInfo.UPDATE_USER_BASIC, params, file, new OkHttpClientManager.ResultCallback<RegisterModel>() {
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
                    SPCache.putString(Constants.SharePreference.USER_TOKEN, us.getTokenId());
                    SPCache.putInt(Constants.SharePreference.USER_STATUS, us.getData().getUserStatus());
                    SPCache.putString(Constants.SharePreference.USER_HEAD_IMAGE, us.getData().getUserSmallHeadImgUrl());
                    SPCache.putString(Constants.SharePreference.USER_NICK, us.getData().getUserNick());
                    SPCache.putString(Constants.SharePreference.USER_PROFESSION, us.getData().getUserProfession());
                    SPCache.putString(Constants.SharePreference.USER_PHONE, us.getData().getUserPhone());
                    SPCache.putString(Constants.SharePreference.USER_SEX, us.getData().getUserSex());
                    SPCache.putString(Constants.SharePreference.USER_BIRTHDAY, us.getData().getUserBirthday());
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //        getMenuInflater().inflate(R.menu.menu_info_edit, menu);
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

    public final static int REQUEST_CODE = 1;
    private ArrayList<String> imgs = new ArrayList<>();

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data != null) {
                imgs = data.getStringArrayListExtra(PhotoPickerActivity.KEY_SELECTED_PHOTOS);
                Log.i("image", "image = " + imgs.get(0));
                if (imgs.size() == 0) return;
                PicassoTools.loadImage(this, imgs.get(0), ivHead);
            }
        }
    }
}
