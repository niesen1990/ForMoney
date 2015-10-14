package com.fuck.formoney.base;

import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fuck.formoney.R;
import com.fuck.formoney.utils.ExitBroadcast;
import com.fuck.formoney.utils.TDevice;
import com.fuck.formoney.utils.log.Log;
import com.fuck.formoney.widget.WaitDialog;
import com.umeng.analytics.MobclickAgent;
import com.umeng.message.PushAgent;

import java.lang.ref.WeakReference;


public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = BaseActivity.class.getSimpleName();
    private long lastToastTime;
    private String lastToast;
    protected ActionBar actionbar;
    protected boolean needActionBar = true; //是否需要actionbar
    protected boolean isVisiable;
    private WaitDialog dialog;
    private TextView tvTitle;
    protected PushAgent mPushAgent;
    private BroadcastReceiver existReceiver;// EXIT

    //处理主线程UI更新
    protected MessageHandler mHandler = new MessageHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(getLayoutId());
        // 存储屏幕宽 高
        TDevice.saveDisplaySize(this);
        if (needActionBar) {
            initActionBar();
        }
        mPushAgent = PushAgent.getInstance(this);
        mPushAgent.onAppStart();
        mPushAgent.setMergeNotificaiton(false);
        initExit();
        init(savedInstanceState);
    }

    /**
     * 初始化actionbar
     */
    private void initActionBar() {
        try {
            Toolbar v = (Toolbar) findViewById(R.id.toolbar);
            tvTitle = (TextView) v.findViewById(R.id.tv_main_toolbar);
            setSupportActionBar(v);
            actionbar = getSupportActionBar();
            actionbar.setDisplayHomeAsUpEnabled(true);
        } catch (NullPointerException e) {
            Log.i(TAG, "actionbar is null");
        }
    }

    protected void setTitle(String title) {
        tvTitle.setText(title);
    }


    protected abstract void init(Bundle savedInstanceState);

    protected abstract int getLayoutId();

    public boolean isVisiable() {
        return isVisiable;
    }

    @Override
    protected void onResume() {
        super.onResume();
        isVisiable = true;
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        isVisiable = false;
        MobclickAgent.onPause(this);
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * 程序退出
     */
    private void initExit() {
        existReceiver = new ExitBroadcast(this);
        IntentFilter filter = new IntentFilter(Constants.INTENT_ACTION_EXIT_APP);
        registerReceiver(existReceiver, filter);
    }


    protected void showToast(String tip) {
        showToast(tip, Toast.LENGTH_LONG);
    }

    protected void showShortToast(String tip) {
        showToast(tip, Toast.LENGTH_SHORT);
    }

    protected void showToast(String tip, int duration) {
        long time = System.currentTimeMillis();
        if (!TextUtils.isEmpty(tip)) {
            if (!tip.equalsIgnoreCase(lastToast) || (time - lastToastTime) > 2000) {
                Toast.makeText(this, tip, duration).show();
                lastToastTime = System.currentTimeMillis();
                lastToast = tip;
            }
        }
    }

    protected void showWaitDialog() {
        showWaitDialog(null);
    }

    protected void showWaitDialog(String tip) {
        if (dialog == null) {
            dialog = new WaitDialog(this);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    cancelRequest();
                }
            });
        }
        if (!TextUtils.isEmpty(tip)) {
            dialog.setMessage(tip);
        }
        dialog.show();
    }

    // 取消请求
    protected void cancelRequest() {
        Log.i("cancelRequest", "request cancle");
    }

    protected boolean isWaitShow() {
        if (dialog.isShowing()) {
            return true;
        } else {
            return false;
        }
    }

    protected void hideWaitDialog() {
        mHandler.sendEmptyMessage(Constants.CANCEL_WAIT_DIALOG);
    }

    private void closeWaitDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.hide();
        }
    }


    protected void recycleBitmap(ImageView view) {
        if (view == null)
            return;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) view.getDrawable();
        if (bitmapDrawable != null) {
            view.setImageBitmap(null);
            // 如果图片还未回收，先强制回收该图片
            if (bitmapDrawable.getBitmap() != null
                    && !bitmapDrawable.getBitmap().isRecycled()) {
                //                Log.i(TAG, "图片回收");
                bitmapDrawable.getBitmap().recycle();
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(existReceiver);
    }

    private static class MessageHandler extends Handler {
        private final WeakReference<BaseActivity> mActivity;

        public MessageHandler(BaseActivity activity) {
            mActivity = new WeakReference<BaseActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            BaseActivity activity = mActivity.get();
            switch (msg.what) {
                case Constants.CANCEL_WAIT_DIALOG:
                    activity.closeWaitDialog();
                    break;
            }
        }
    }
}
