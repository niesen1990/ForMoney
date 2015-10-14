package com.fuck.formoney.activity.main;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.fuck.formoney.R;
import com.fuck.formoney.base.BaseActivity;

public class NewCourseVideoActivity extends BaseActivity {

    private AppCompatTextView mTvTitle;
    private FrameLayout mFlMiddle;
    private VideoView mVideo;
    private ImageView mBtnPlay;
    private TextView mBtnShare;

    private void assignViews() {
        mTvTitle = (AppCompatTextView) findViewById(R.id.tv_title);
        mFlMiddle = (FrameLayout) findViewById(R.id.fl_middle);
        mVideo = (VideoView) findViewById(R.id.video);
        mBtnPlay = (ImageView) findViewById(R.id.btn_play);
        mBtnPlay.setOnClickListener(this);
        mBtnShare = (TextView) findViewById(R.id.btn_share);
    }


    @Override
    protected void init(Bundle savedInstanceState) {
        assignViews();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_new_course_video;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_play:
                mVideo.setVideoURI(Uri.parse(""));
                mVideo.requestFocus();
                mVideo.start();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.menu_new_course_video, menu);
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
