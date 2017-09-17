package com.example.hipdrobe.hip_v1_1;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.io.File;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.hipdrobe.hip_v1_1.R.string.app_name;

public class AlwaysOnTop extends Service {
    private ImageView mPopupView_h;
    private ImageView mPopupView_x;
    private ImageView mPopupView_d;
    private ImageView mPopupView_s;
    private WindowManager.LayoutParams mParams, mParams_d,mParams_s;
    private WindowManager mWindowManager;
    private float START_X, START_Y,START_X_s, START_Y_s,START_X_d, START_Y_d;
    private int PREV_X, PREV_Y,PREV_X_s, PREV_Y_s,PREV_X_d, PREV_Y_d;
    private int MAX_X = -1, MAX_Y = -1;
    private static final int MAX_CLICK_DURATION = 150;
    private long startClickTime;
    private TimerTask mTask;
    private Timer mTimer;
    private TimerTask mTask2;
    private Timer mTimer2;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mPopupView_h = new ImageView(this);
        Log.i("service!","onCreate");
        mPopupView_h.setImageResource(R.drawable.icon_h);
        mPopupView_h.setOnTouchListener(mViewTouchListener_h);
        mParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        mParams.gravity = Gravity.RIGHT | Gravity.TOP;
        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        mWindowManager.addView(mPopupView_h, mParams);

    }
    private View.OnTouchListener mViewTouchListener_h = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_UP:
                    long ClickDuration = Calendar.getInstance().getTimeInMillis() - startClickTime;
                    if (ClickDuration < MAX_CLICK_DURATION) {
                        String folder = "HIP";
                        File dirs = new File(Environment.getExternalStorageDirectory(), folder);
                        if (!dirs.exists()) { // 원하는 경로에 폴더가 있는지 확인
                            dirs.mkdirs(); // Test 폴더 생성
                            Log.d("CAMERA_TEST", "Directory Created");
                        }
                        Log.i("loggggg", "H버튼 없애고 X,d,s버튼 만들기");
                        mWindowManager.removeViewImmediate(mPopupView_h);
                        make_three_buttons();
                    }
                case MotionEvent.ACTION_DOWN:
                    startClickTime = Calendar.getInstance().getTimeInMillis();
                    if (MAX_X == -1)
                        setMaxPosition();
                    START_X = event.getRawX();
                    START_Y = event.getRawY();
                    PREV_X = mParams.x;
                    PREV_Y = mParams.y;
                    break;
                case MotionEvent.ACTION_MOVE:
                    int x = (int) (event.getRawX() - START_X);
                    int y = (int) (event.getRawY() - START_Y);

                    mParams.x = PREV_X - x;
                    mParams.y = PREV_Y + y;

                    optimizePosition();
                    mWindowManager.updateViewLayout(mPopupView_h, mParams);
                    break;
            }
            return true;
        }
    };
    private View.OnTouchListener mViewTouchListener_x = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_UP:
                    long ClickDuration = Calendar.getInstance().getTimeInMillis() - startClickTime;
                    if (ClickDuration < MAX_CLICK_DURATION) {
                        String folder = "HIP";
                        File dirs = new File(Environment.getExternalStorageDirectory(), folder);
                        if (!dirs.exists()) { // 원하는 경로에 폴더가 있는지 확인
                            dirs.mkdirs(); // Test 폴더 생성
                            Log.d("CAMERA_TEST", "Directory Created");
                        }
                        Log.i("loggggg", "X버튼 없애고 H버튼 만들기");
                        mWindowManager.removeViewImmediate(mPopupView_x);
                        mWindowManager.removeViewImmediate(mPopupView_s);
                        mWindowManager.removeViewImmediate(mPopupView_d);
                        mPopupView_h = new ImageView(AlwaysOnTop.this);
                        mPopupView_h.setImageResource(R.drawable.icon_h);
                        mPopupView_h.setOnTouchListener(mViewTouchListener_h);
                        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
                        mWindowManager.addView(mPopupView_h, mParams);
                    }
                case MotionEvent.ACTION_DOWN:
                    startClickTime = Calendar.getInstance().getTimeInMillis();
                    if (MAX_X == -1)
                        setMaxPosition();
                    START_X = event.getRawX();
                    START_Y = event.getRawY();
                    PREV_X = mParams.x;
                    PREV_Y = mParams.y;

                    START_X_s = event.getRawX() + 120;
                    START_Y_s = event.getRawY() + 120;
                    PREV_X_s = mParams_s.x;
                    PREV_Y_s = mParams_s.y;

                    START_X_d = event.getRawX() + 120;
                    START_Y_d = event.getRawY() - 120;
                    PREV_X_d = mParams_d.x;
                    PREV_Y_d = mParams_d.y;

                    break;
                case MotionEvent.ACTION_MOVE:
                    int x = (int) (event.getRawX() - START_X);
                    int y = (int) (event.getRawY() - START_Y);
                    int x_s = (int) (event.getRawX() +120 - START_X_s);
                    int y_s = (int) (event.getRawY() +120 - START_Y_s);
                    int x_d = (int) (event.getRawX() +120 - START_X_d);
                    int y_d = (int) (event.getRawY() -120 - START_Y_d);

                    mParams_s.x = PREV_X_s - x_s;
                    mParams_s.y = PREV_Y_s + y_s;
                    mParams_d.x = PREV_X_d - x_d;
                    mParams_d.y = PREV_Y_d + y_d;
                    mParams.x = PREV_X - x;
                    mParams.y = PREV_Y + y;

                    optimizePosition();
                    mWindowManager.updateViewLayout(mPopupView_x, mParams);
                    mWindowManager.updateViewLayout(mPopupView_s, mParams_s);
                    mWindowManager.updateViewLayout(mPopupView_d, mParams_d);
                    break;
            }
            return true;
        }
    };
    private View.OnTouchListener mViewTouchListener_d = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_UP:
                    long ClickDuration = Calendar.getInstance().getTimeInMillis() - startClickTime;
                    if (ClickDuration < MAX_CLICK_DURATION) {
                        //버튼 없애기
                        mPopupView_d.setVisibility(View.GONE);
                        mPopupView_s.setVisibility(View.GONE);
                        mPopupView_x.setVisibility(View.GONE);
                        mTimer = new Timer();
                        final Handler handler = new Handler()
                        {
                            public void handleMessage(Message msg)
                            {
                                Log.i("imdoing","handler" + toString().valueOf(Drobe.state));
                                if(Drobe.state == 0){
                                    mPopupView_d.setVisibility(View.GONE);
                                    mPopupView_s.setVisibility(View.GONE);
                                    mPopupView_x.setVisibility(View.GONE);
                                }
                                if (Drobe.state == 1) {
                                    Context mContext = getApplicationContext();
                                    ActivityManager activityManager = (ActivityManager) mContext.getSystemService(mContext.ACTIVITY_SERVICE);
                                    List<ActivityManager.RunningTaskInfo> info;
                                    info = activityManager.getRunningTasks(1);
                                    String top;
                                    Iterator iterator = info.iterator();
                                    ActivityManager.RunningTaskInfo runningTaskInfo = (ActivityManager.RunningTaskInfo) iterator.next();
                                    top = runningTaskInfo.topActivity.getClassName();
                                    Log.i("alwaysontop",top);
                                    if (!top.contains("hipdrobe")) {
                                        mPopupView_d.setVisibility(View.VISIBLE);
                                        mPopupView_s.setVisibility(View.VISIBLE);
                                        mPopupView_x.setVisibility(View.VISIBLE);
                                        if (mTimer != null) {
                                            mTimer.cancel();
                                        }
                                    }
                                }
                                else if(Drobe.state==2){
                                    mPopupView_d.setVisibility(View.VISIBLE);
                                    mPopupView_s.setVisibility(View.VISIBLE);
                                    mPopupView_x.setVisibility(View.VISIBLE);
                                    if (mTimer != null) {
                                        mTimer.cancel();
                                    }
                                }
                            }
                        };
                        mTask = new TimerTask() {  //UIthread에 접근하기 위해 핸들러 사용
                            @Override
                            public void run() {
                                new Thread()
                                {
                                    public void run()
                                    {
                                        Message msg = handler.obtainMessage();
                                        handler.sendMessage(msg);
                                    }
                                }.start();
                            }
                        };
                        mTimer.schedule(mTask, 100, 500);
                        startActivity(new Intent(AlwaysOnTop.this, Drobe.class));
                    }
                case MotionEvent.ACTION_DOWN:
                    startClickTime = Calendar.getInstance().getTimeInMillis();
            }
            return true;
        }
    };
    private View.OnTouchListener mViewTouchListener_s = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_UP:
                    long ClickDuration = Calendar.getInstance().getTimeInMillis() - startClickTime;
                    if (ClickDuration < MAX_CLICK_DURATION) {

                        //버튼 없애기
                        mPopupView_d.setVisibility(View.GONE);
                        mPopupView_s.setVisibility(View.GONE);
                        mPopupView_x.setVisibility(View.GONE);
                        mTimer2 = new Timer();
                        final Handler handler2 = new Handler()
                        {
                            public void handleMessage(Message msg)
                            {
                                Log.i("imdoing","handler" + toString().valueOf(Drobe.state));
                                if(Screenshot.state==1){
                                    mPopupView_d.setVisibility(View.VISIBLE);
                                    mPopupView_s.setVisibility(View.VISIBLE);
                                    mPopupView_x.setVisibility(View.VISIBLE);
                                    if (mTimer2 != null) {
                                        mTimer2.cancel();
                                    }
                                }
                            }
                        };
                        mTask2 = new TimerTask() {  //UIthread에 접근하기 위해 핸들러 사용
                            @Override
                            public void run() {
                                new Thread()
                                {
                                    public void run()
                                    {
                                        Message msg = handler2.obtainMessage();
                                        handler2.sendMessage(msg);
                                    }
                                }.start();
                            }
                        };
                        mTimer2.schedule(mTask2, 100, 500);
                        startActivity(new Intent(AlwaysOnTop.this, Screenshot.class));
                    }
                case MotionEvent.ACTION_DOWN:
                    startClickTime = Calendar.getInstance().getTimeInMillis();
            }
            return true;
        }
    };
    private void make_three_buttons()
    {
        mPopupView_d = new ImageView(AlwaysOnTop.this);
        mPopupView_d.setImageResource(R.drawable.icon_d);
        mPopupView_d.setOnTouchListener(mViewTouchListener_d);
        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        mParams_d = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        mParams_d.gravity = Gravity.RIGHT | Gravity.TOP;
        mParams_d.x = mParams.x + 120;
        mParams_d.y = mParams.y - 120;
        mWindowManager.addView(mPopupView_d, mParams_d);

        mPopupView_s = new ImageView(AlwaysOnTop.this);
        mPopupView_s.setImageResource(R.drawable.icon_s);
        mPopupView_s.setOnTouchListener(mViewTouchListener_s);
        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        mParams_s = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        mParams_s.gravity = Gravity.RIGHT | Gravity.TOP;
        mParams_s.x = mParams.x + 120;
        mParams_s.y = mParams.y + 120;
        mWindowManager.addView(mPopupView_s, mParams_s);

        mPopupView_x = new ImageView(AlwaysOnTop.this);
        mPopupView_x.setImageResource(R.drawable.icon_x);
        mPopupView_x.setOnTouchListener(mViewTouchListener_x);
        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        mWindowManager.addView(mPopupView_x, mParams);
        mWindowManager.updateViewLayout(mPopupView_x, mParams);
    }
    private void setMaxPosition() {
        DisplayMetrics matrix = new DisplayMetrics();
        mWindowManager.getDefaultDisplay().getMetrics(matrix);

        MAX_X = matrix.widthPixels - mPopupView_h.getWidth();
        MAX_Y = matrix.heightPixels - mPopupView_h.getHeight();
    }
    private void optimizePosition() {
        if(mParams.x > MAX_X) mParams.x = MAX_X;
        if(mParams.y > MAX_Y) mParams.y = MAX_Y;
        if(mParams.x < 0) mParams.x = 0;
        if(mParams.y < 0) mParams.y = 0;
    }
}
