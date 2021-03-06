package com.fuck.formoney.activity.main;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.fuck.formoney.R;
import com.fuck.formoney.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

public class LotteryActivity extends BaseActivity {

    //设置一个时间常量，此常量有两个作用，1.圆灯视图显示与隐藏中间的切换时间；2.指针转一圈所需要的时间，现设置为500毫秒
    private static final long ONE_WHEEL_TIME = 500;
    //记录圆灯视图是否显示的布尔常量
    private boolean lightsOn = true;
    //开始转动时候的角度，初始值为0
    private int startDegree = 0;

    private ImageView lightIv;
    private ImageView pointIv;
    private ImageView wheelIv;

    //指针转圈圈数数据源
    private int[] laps = {5, 7, 10, 15};
    //指针所指向的角度数据源，因为有6个选项，所有此处是6个值
    private int[] angles = {0, 45, 90, 135, 180, 225, 270, 315};
    //转盘内容数组
    private String[] lotteryStr = {"特等奖", "四等奖", "六等奖", "一等奖", "二等奖", "感谢参与", "五等奖", "三等奖"};

    //子线程与UI线程通信的handler对象
    private Handler mHandler = new Handler(Looper.getMainLooper());

    //监听动画状态的监听器
    private Animation.AnimationListener al = new Animation.AnimationListener() {

        @Override
        public void onAnimationStart(Animation animation) {
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            String name = lotteryStr[startDegree % 360 / 45];
            Toast.makeText(LotteryActivity.this, name, Toast.LENGTH_LONG).show();
            // 请求网络
        }
    };


    @Override
    protected void init(Bundle savedInstanceState) {
        setupViews();
        flashLights();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_lottery;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.point:
                int lap = laps[(int) (Math.random() * 4)];
                int angle = angles[(int) (Math.random() * 8)];
                //每次转圈角度增量
                int increaseDegree = lap * 360 + angle;
                //初始化旋转动画，后面的四个参数是用来设置以自己的中心点为圆心转圈
                RotateAnimation rotateAnimation = new RotateAnimation(startDegree, startDegree + increaseDegree, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                //将最后的角度赋值给startDegree作为下次转圈的初始角度
                startDegree += increaseDegree;
                //计算动画播放总时间
                long time = (lap + angle / 360) * ONE_WHEEL_TIME;
                //设置动画播放时间
                rotateAnimation.setDuration(time);
                //设置动画播放完后，停留在最后一帧画面上
                rotateAnimation.setFillAfter(true);
                //设置动画的加速行为，是先加速后减速
                rotateAnimation.setInterpolator(LotteryActivity.this, android.R.anim.accelerate_decelerate_interpolator);
                //设置动画的监听器
                rotateAnimation.setAnimationListener(al);
                //开始播放动画
                pointIv.startAnimation(rotateAnimation);
                break;
        }
    }

    private void setupViews() {
        lightIv = (ImageView) findViewById(R.id.light);
        pointIv = (ImageView) findViewById(R.id.point);
        pointIv.setOnClickListener(this);
        wheelIv = (ImageView) findViewById(R.id.main_wheel);
    }

    //控制灯圈动画的方法
    private void flashLights() {
        Timer timer = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                // 向UI线程发送消息
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (lightsOn) {
                            // 设置lightIv不可见
                            lightIv.setVisibility(View.INVISIBLE);
                            lightsOn = false;
                        } else {
                            // 设置lightIv可见
                            lightIv.setVisibility(View.VISIBLE);
                            lightsOn = true;
                        }
                    }
                });
            }
        };

        // 每隔ONE_WHEEL_TIME毫秒运行tt对象的run方法
        timer.schedule(tt, 0, ONE_WHEEL_TIME);
    }

}
