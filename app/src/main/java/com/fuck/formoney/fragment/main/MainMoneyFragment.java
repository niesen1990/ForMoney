package com.fuck.formoney.fragment.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.fuck.formoney.MainActivity;
import com.fuck.formoney.R;
import com.fuck.formoney.activity.login.model.RegisterModel;
import com.fuck.formoney.activity.main.LinkShareActivity;
import com.fuck.formoney.activity.main.LotteryActivity;
import com.fuck.formoney.activity.main.NewCourseActivity;
import com.fuck.formoney.base.BaseApplication;
import com.fuck.formoney.base.BaseFragment;
import com.fuck.formoney.base.Constants;
import com.fuck.formoney.network.OkHttpClientManager;
import com.fuck.formoney.utils.SPCache;
import com.fuck.formoney.utils.TDevice;
import com.fuck.formoney.utils.download.DownloadTools;
import com.fuck.formoney.utils.log.Log;
import com.squareup.okhttp.Request;

public class MainMoneyFragment extends BaseFragment {

    private RelativeLayout mRl01;
    private ImageView mIvHead;
    private AppCompatTextView mTvId;
    private RelativeLayout mRl03;
    private AppCompatTextView mTvTodayLeft;
    private AppCompatTextView mTvTodayMoney;
    private AppCompatTextView mBtnDetail;
    private CardView mBtnLimitTime;
    private CardView mBtnForward;
    private CardView mBtnCourse;
    private CardView mBtnRaffle;
    // test
    private CardView btnTest;


    public MainMoneyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_money, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        handleProfitRequest();
    }

    private void handleProfitRequest() {
        OkHttpClientManager.Param[] params = new OkHttpClientManager.Param[]{
                new OkHttpClientManager.Param("tokenId", BaseApplication.token)};
        OkHttpClientManager.postAsyn(Constants.UserInfo.USER_PROFIT, params, new OkHttpClientManager.ResultCallback<RegisterModel>() {
            @Override
            public void onError(Request request, Exception e) {
                e.printStackTrace();
                showShortToast("请检查网络");
            }

            @Override
            public void onResponse(RegisterModel us) {

            }
        });

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRl01 = (RelativeLayout) view.findViewById(R.id.rl_01);
        mIvHead = (ImageView) view.findViewById(R.id.iv_head);
        mTvId = (AppCompatTextView) view.findViewById(R.id.tv_id);
        mRl03 = (RelativeLayout) view.findViewById(R.id.rl_03);
        mTvTodayLeft = (AppCompatTextView) view.findViewById(R.id.tv_today_left);
        mTvTodayMoney = (AppCompatTextView) view.findViewById(R.id.tv_today_money);
        mBtnDetail = (AppCompatTextView) view.findViewById(R.id.btn_detail);
        mBtnLimitTime = (CardView) view.findViewById(R.id.btn_limit_time);
        mBtnLimitTime.setOnClickListener(this);
        mBtnForward = (CardView) view.findViewById(R.id.btn_forward);
        mBtnForward.setOnClickListener(this);
        mBtnCourse = (CardView) view.findViewById(R.id.btn_course);
        mBtnCourse.setOnClickListener(this);
        mBtnRaffle = (CardView) view.findViewById(R.id.btn_raffle);
        mBtnRaffle.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_limit_time:
                intent = new Intent(getActivity(), LinkShareActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_forward:
                break;
            case R.id.btn_course:
                intent = new Intent(getActivity(), NewCourseActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_raffle:
                intent = new Intent(getActivity(), LotteryActivity.class);
                startActivity(intent);
                break;

            /*case R.id.btn_test:
                String url = "http://192.168.100.181:8080/mb/app-Umeng-release.apk";
                long id = DownloadTools.downloadApk(getActivity(), url, "萌宝派.apk");
                Intent downloadId = new Intent("com.fuck.formoney.download.id");
                downloadId.putExtra("id", id);
                downloadId.putExtra("name", "萌宝派.apk");
                getActivity().sendBroadcast(downloadId);
                break;*/
        }
    }
}
