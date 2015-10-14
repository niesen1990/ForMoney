package com.fuck.formoney.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.fuck.formoney.R;
import com.fuck.formoney.activity.user.InfoEditActivity;
import com.fuck.formoney.base.BaseActivity;

public class NewCourseActivity extends BaseActivity {

    private CardView mCv01;
    private AppCompatTextView mBtnData;
    private CardView mCv02;
    private AppCompatTextView mBtnVideo;
    private CardView mCv03;
    private AppCompatTextView mBtnQuery;

    private void assignViews() {
        mCv01 = (CardView) findViewById(R.id.cv_01);
        mBtnData = (AppCompatTextView) findViewById(R.id.btn_data);
        mCv01.setOnClickListener(this);
        mCv02 = (CardView) findViewById(R.id.cv_02);
        mBtnVideo = (AppCompatTextView) findViewById(R.id.btn_video);
        mCv02.setOnClickListener(this);
        mCv03 = (CardView) findViewById(R.id.cv_03);
        mBtnQuery = (AppCompatTextView) findViewById(R.id.btn_query);
        mCv03.setOnClickListener(this);
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        assignViews();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_new_course;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        Intent intent;
        switch (v.getId()) {
            case R.id.cv_01:
                intent = new Intent(this, InfoEditActivity.class);
                startActivity(intent);
                break;
            case R.id.cv_02:
                intent = new Intent(this, NewCourseVideoActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.menu_new_course, menu);
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
