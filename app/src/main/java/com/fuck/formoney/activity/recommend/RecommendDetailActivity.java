package com.fuck.formoney.activity.recommend;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fuck.formoney.R;
import com.fuck.formoney.base.BaseActivity;
import com.fuck.formoney.base.Constants;
import com.fuck.formoney.network.OkHttpClientManager;
import com.fuck.formoney.utils.log.Log;
import com.fuck.formoney.widget.autoscroll.AutoScrollViewPager;
import com.fuck.formoney.widget.indication.CirclePageIndicator;
import com.squareup.okhttp.Request;

import java.util.ArrayList;

public class RecommendDetailActivity extends BaseActivity {

    private AutoScrollViewPager autoscrollviewpager;
    private CirclePageIndicator circlepageindicator;
    private AutoScrollAdapter adapter;
    private ArrayList<BannerModel> banners = new ArrayList<>();

    private TextView tv_download, tv_share;
    private String id;

    @Override
    protected void init(Bundle savedInstanceState) {
        id = getIntent().getStringExtra("id");
        banners.add(new BannerModel("http://smart.image.alimmdn.com/app/test/2015-10-16/image_9c630c26657d453f89ca63f6ab4ec9ba", "01"));
        banners.add(new BannerModel("http://smart.image.alimmdn.com/app/test/2015-10-16/image_9c630c26657d453f89ca63f6ab4ec9ba", "02"));
        banners.add(new BannerModel("http://moneyhome.image.alimmdn.com/app/image/test/test4", "03"));
        initView();
        attemptDetailRequest(id);
    }

    private void attemptDetailRequest(String id) {
        showWaitDialog();
        OkHttpClientManager.Param[] params = new OkHttpClientManager.Param[]{
                new OkHttpClientManager.Param("id", id)};
        OkHttpClientManager.postAsyn(Constants.Recommend.RECOMMEND_GETDETAIL, params, new OkHttpClientManager.ResultCallback<DetailModel>() {
            @Override
            public void onError(Request request, Exception e) {
                e.printStackTrace();
                showShortToast("请检查网络");
                hideWaitDialog();
            }

            @Override
            public void onResponse(DetailModel detailModel) {
                hideWaitDialog();
                Log.e("TAG", detailModel.toString());
                if (detailModel.getStatusCode() == 200) {

                }
            }
        });
    }

    private void initView() {
        autoscrollviewpager = (AutoScrollViewPager) findViewById(R.id.autoscrollviewpager);
        circlepageindicator = (CirclePageIndicator) findViewById(R.id.circlepageindicator);
        adapter = new AutoScrollAdapter(this, banners);
        autoscrollviewpager.setAdapter(adapter);
        autoscrollviewpager.setOffscreenPageLimit(6);
        autoscrollviewpager.setScrollFactgor(5);
        autoscrollviewpager.startAutoScroll(3000);
        circlepageindicator.setViewPager(autoscrollviewpager);
        circlepageindicator.setSnap(true);
        tv_download = (TextView) findViewById(R.id.tv_download);
        tv_share = (TextView) findViewById(R.id.tv_share);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_download:
                break;
            case R.id.tv_share:
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_recommend_detail;
    }
}
