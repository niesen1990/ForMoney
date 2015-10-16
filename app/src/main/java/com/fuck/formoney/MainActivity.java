package com.fuck.formoney;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.fuck.formoney.base.BaseActivity;
import com.fuck.formoney.base.Constants;
import com.fuck.formoney.fragment.main.MainExchangeFragment;
import com.fuck.formoney.fragment.main.MainMoneyFragment;
import com.fuck.formoney.fragment.main.MainPersonFragment;
import com.fuck.formoney.fragment.main.MainRankFragment;
import com.fuck.formoney.utils.log.Log;
import com.pgyersdk.update.PgyUpdateManager;
import com.umeng.message.ALIAS_TYPE;
import com.umeng.message.IUmengRegisterCallback;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends BaseActivity {

    private static Boolean isQuit = false;// 退出应用标识符
    private Timer timer = new Timer();// 程序退出定时器
    private FrameLayout mContainer;
    private CardView mLlBottom;
    private AppCompatTextView mBtnMoney;
    private AppCompatTextView mBtnRank;
    private AppCompatTextView mBtnExchange;
    private AppCompatTextView mBtnPerson;

    private MainMoneyFragment mMainMoneyFragment;
    private MainRankFragment mMainRankFragment;
    private MainExchangeFragment mMainExchangeFragment;
    private MainPersonFragment mMainPersonFragment;


    @Override
    protected void init(Bundle savedInstanceState) {
        // 检测更新蒲公英（内测版）
        PgyUpdateManager.register(this);
        assignViews();
        initData();
    }

    private void initData() {
        mMainMoneyFragment = new MainMoneyFragment();
        mMainRankFragment = new MainRankFragment();
        mMainExchangeFragment = new MainExchangeFragment();
        mMainPersonFragment = new MainPersonFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, mMainMoneyFragment).commit();
        mBtnMoney.setSelected(true);
    }

    private void assignViews() {
        mContainer = (FrameLayout) findViewById(R.id.container);
        mLlBottom = (CardView) findViewById(R.id.ll_bottom);
        mBtnMoney = (AppCompatTextView) findViewById(R.id.btn_money);
        mBtnMoney.setOnClickListener(this);
        mBtnRank = (AppCompatTextView) findViewById(R.id.btn_rank);
        mBtnRank.setOnClickListener(this);
        mBtnExchange = (AppCompatTextView) findViewById(R.id.btn_exchange);
        mBtnExchange.setOnClickListener(this);
        mBtnPerson = (AppCompatTextView) findViewById(R.id.btn_person);
        mBtnPerson.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_money:
                actionbar.setTitle(getResources().getString(R.string.app_name));
                mBtnMoney.setSelected(true);
                mBtnRank.setSelected(false);
                mBtnExchange.setSelected(false);
                mBtnPerson.setSelected(false);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, mMainMoneyFragment).commit();
                break;
            case R.id.btn_rank:
                actionbar.setTitle(getResources().getString(R.string.main_fragment_rank));
                mBtnMoney.setSelected(false);
                mBtnRank.setSelected(true);
                mBtnExchange.setSelected(false);
                mBtnPerson.setSelected(false);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, mMainRankFragment).commit();
                break;
            case R.id.btn_exchange:
                actionbar.setTitle(getResources().getString(R.string.main_fragment_exchange));
                mBtnMoney.setSelected(false);
                mBtnRank.setSelected(false);
                mBtnExchange.setSelected(true);
                mBtnPerson.setSelected(false);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, mMainExchangeFragment).commit();
                break;
            case R.id.btn_person:
                actionbar.setTitle(getResources().getString(R.string.main_fragment_person));
                mBtnMoney.setSelected(false);
                mBtnRank.setSelected(false);
                mBtnExchange.setSelected(false);
                mBtnPerson.setSelected(true);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, mMainPersonFragment).commit();
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (!isQuit) {
            isQuit = true;
            //showToastShort(R.string.back_more_quit);
            showShortToast("您确定不是手滑？");
            TimerTask task = null;
            task = new TimerTask() {
                @Override
                public void run() {
                    isQuit = false;
                }
            };
            timer.schedule(task, 2000);
        } else {
            Intent intent = new Intent(Constants.INTENT_ACTION_EXIT_APP);
            sendBroadcast(intent);
        }
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
