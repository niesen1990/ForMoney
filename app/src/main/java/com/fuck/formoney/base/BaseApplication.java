package com.fuck.formoney.base;

import android.app.Application;
import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.facebook.stetho.Stetho;
import com.fuck.formoney.R;
import com.fuck.formoney.utils.SPCache;
import com.fuck.formoney.utils.log.Log;
import com.fuck.formoney.utils.log.LogWrapper;
import com.pgyersdk.crash.PgyCrashManager;
import com.umeng.analytics.MobclickAgent;
import com.umeng.message.PushAgent;
import com.umeng.message.UTrack;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.UmengNotificationClickHandler;
import com.umeng.message.entity.UMessage;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/10 13:07
 */
public class BaseApplication extends Application {
    private static Context context;
    private PushAgent mPushAgent;

    public static String token = "";

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        initSharePreference();
        initToken();
        initLog();
        initStetho();
        initPushAgent();
        initUmengAnalytics();
    }

    /**
     * 从Sp中获取Token
     */
    private void initToken() {
        token = SPCache.getString(Constants.SharePreference.USER_TOKEN, "");
    }

    /**
     * 初始化 stetho
     */
    private void initStetho() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this).enableDumpapp(
                        Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }

    public static Context getContext() {
        return context;
    }

    /**
     * 初始化 日志
     */
    private void initLog() {
        Log.setLogNode(new LogWrapper());
    }

    /**
     * 初始化sharepreference
     * 用法：
     * int count = SpCache.getInt(ACTIVITY_CREATE_COUNT, 0) + 1;
     * SpCache.putInt(ACTIVITY_CREATE_COUNT, count);
     */
    private void initSharePreference() {
        SPCache.init(this);
    }

    /**
     * Umeng统计，正式版本置为false
     */
    private void initUmengAnalytics() {
        MobclickAgent.setDebugMode(true);
        // 捕获日志（蒲公英）
        MobclickAgent.setCatchUncaughtExceptions(false);
        // 内测版本
        PgyCrashManager.register(this);
    }

    /**
     * 友盟推送
     */
    private void initPushAgent() {
        mPushAgent = PushAgent.getInstance(this);
        mPushAgent.setDebugMode(true);

        /**
         * 该Handler是在IntentService中被调用，故
         * 1. 如果需启动Activity，需添加Intent.FLAG_ACTIVITY_NEW_TASK
         * 2. IntentService里的onHandleIntent方法是并不处于主线程中，因此，如果需调用到主线程，需如下所示;
         * 	      或者可以直接启动Service
         * */
        UmengMessageHandler messageHandler = new UmengMessageHandler() {
            @Override
            public void dealWithCustomMessage(final Context context, final UMessage msg) {
                new Handler(getMainLooper()).post(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        UTrack.getInstance(getApplicationContext()).trackMsgClick(msg);
                        Toast.makeText(context, msg.custom, Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public Notification getNotification(Context context,
                                                UMessage msg) {
                switch (msg.builder_id) {
                    case 0:
                        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                                .setLargeIcon(getAppIcon())
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setContentTitle(msg.title)
                                .setContentText(msg.text);
                        mBuilder.setAutoCancel(true);
                        Notification mNotification = mBuilder.build();
                        return mNotification;
                    default:
                        //默认为0，若填写的builder_id并不存在，也使用默认。
                        return super.getNotification(context, msg);

                }
            }
        };
        mPushAgent.setMessageHandler(messageHandler);

        /**
         * 该Handler是在BroadcastReceiver中被调用，故
         * 如果需启动Activity，需添加Intent.FLAG_ACTIVITY_NEW_TASK
         * */
        UmengNotificationClickHandler notificationClickHandler = new UmengNotificationClickHandler() {
            @Override
            public void dealWithCustomAction(Context context, UMessage msg) {
                Toast.makeText(context, "i cclick :" + msg.custom, Toast.LENGTH_LONG).show();
            }
        };
        mPushAgent.setNotificationClickHandler(notificationClickHandler);
    }

    /**
     * 获取图片Icon
     *
     * @return
     */
    private Bitmap getAppIcon() {
        BitmapDrawable bitmapDrawable;
        Bitmap appIcon;
        bitmapDrawable = (BitmapDrawable) context.getApplicationInfo().loadIcon(context.getPackageManager());
        appIcon = bitmapDrawable.getBitmap();
        return appIcon;
    }


}
