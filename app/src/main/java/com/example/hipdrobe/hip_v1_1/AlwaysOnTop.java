package com.example.hipdrobe.hip_v1_1;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.net.Uri;
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
    private ImageView mPopupView_close;
    private ImageView mPopupView_mvp;
    static String Activity_Stack;
    private WindowManager.LayoutParams mParams, mParams_d,mParams_s, mParams_close, mParams_mvp;
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
    private int SaveOrSearch=0;
    private TimerTask second;
    private Handler mhandler = new Handler();
    private int id;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent i, int flags, int startID)
    {
        id = startID;
        return flags;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("service!","onCreate");
        // H 버튼을 만든다.
        mPopupView_h = new ImageView(this);
        Bitmap orgImage = BitmapFactory.decodeResource(getResources(), R.drawable.icon_h);
        Bitmap resize = Bitmap.createScaledBitmap(orgImage, 120, 120, true);
        mPopupView_h.setImageBitmap(resize);
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
                    // 손을 떼면 X버튼이 없어진다.
                    mWindowManager.removeViewImmediate(mPopupView_close);

                    /*
                    Log.i("exit", String.valueOf(mParams.x));
                    Log.i("exit", String.valueOf(mParams.y));
                    Log.i("exit", String.valueOf(width));
                    Log.i("exit", String.valueOf(height));*/

                    // down과 up 사이 시간을 계산하여 클릭인지 아닌지 확인한다.
                    long ClickDuration = Calendar.getInstance().getTimeInMillis() - startClickTime;

                    //손을 떼었을 때 h의 위치가 하단 중앙쪽에 있으면 앱을 종료하고
                    DisplayMetrics dm = getApplicationContext().getResources().getDisplayMetrics();
                    int width = dm.widthPixels;
                    int height = dm.heightPixels;
                    if(mParams.x < width/2 + 150 && mParams.x > width/2 - 150 && mParams.y > height - 300){
                        Log.i("exit", "stop : " + id);
                        mWindowManager.removeViewImmediate(mPopupView_h);
                        stopSelf();
                    }
                    else if (ClickDuration < MAX_CLICK_DURATION) { // 그 위치가 아니며 클릭인 경우에는 H버튼을 없애고 X,D,S버튼을 만든다.
                        mWindowManager.removeViewImmediate(mPopupView_h);
                        make_three_buttons();
                    }
                    break;
                case MotionEvent.ACTION_DOWN:
                    startClickTime = Calendar.getInstance().getTimeInMillis();
                    if (MAX_X == -1)
                        setMaxPosition();
                    START_X = event.getRawX();
                    START_Y = event.getRawY();
                    PREV_X = mParams.x;
                    PREV_Y = mParams.y;

                    // 누름과 동시에 X버튼이 화면 하단 중앙에 나타난다.(종료 버튼 만들기)
                    mPopupView_close = new ImageView(AlwaysOnTop.this);
                    Bitmap orgImage = BitmapFactory.decodeResource(getResources(), R.drawable.icon_x);
                    Bitmap resize = Bitmap.createScaledBitmap(orgImage, 120, 120, true);
                    mPopupView_close.setImageBitmap(resize);
                    mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
                    mParams_close = new WindowManager.LayoutParams(
                            WindowManager.LayoutParams.WRAP_CONTENT,
                            WindowManager.LayoutParams.WRAP_CONTENT,
                            WindowManager.LayoutParams.TYPE_PHONE,
                            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                            PixelFormat.TRANSLUCENT);
                    mParams_close.gravity = Gravity.CENTER | Gravity.BOTTOM;
                    mWindowManager.addView(mPopupView_close, mParams_close);
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
                        // x버튼을 클릭하면 다 없애고 H만 남긴다.
                        mWindowManager.removeViewImmediate(mPopupView_x);
                        mWindowManager.removeViewImmediate(mPopupView_s);
                        mWindowManager.removeViewImmediate(mPopupView_d);
                        mPopupView_h = new ImageView(AlwaysOnTop.this);

                        Bitmap orgImage = BitmapFactory.decodeResource(getResources(), R.drawable.icon_h);
                        Bitmap resize = Bitmap.createScaledBitmap(orgImage, 120, 120, true);
                        mPopupView_h.setImageBitmap(resize);
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
                    //X버튼과의 상대적인 거리이다.
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

                    // 만약 X버튼의 위치가 위나 왼쪽으로 지나치게 치우쳐지면, 움직이지 않는다.(깨짐 방지)
                    DisplayMetrics dm = getApplicationContext().getResources().getDisplayMetrics();
                    int width = dm.widthPixels;
                    int height = dm.heightPixels;



                    optimizePosition_3();
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
                        // 드롭에 들어갔을 경우, Floating 버튼들을 없앤다.
                        mPopupView_d.setVisibility(View.GONE);
                        mPopupView_s.setVisibility(View.GONE);
                        mPopupView_x.setVisibility(View.GONE);

                        mPopupView_mvp = new ImageView(AlwaysOnTop.this);
                        Bitmap orgImage = BitmapFactory.decodeResource(getResources(), R.drawable.icon_h);
                        Bitmap resize = Bitmap.createScaledBitmap(orgImage, 120, 120, true);
                        mPopupView_mvp.setImageBitmap(resize);
                        mPopupView_mvp.setOnTouchListener(mViewTouchListener_mvp);
                        mParams_mvp = new WindowManager.LayoutParams(
                                WindowManager.LayoutParams.WRAP_CONTENT,
                                WindowManager.LayoutParams.WRAP_CONTENT,
                                WindowManager.LayoutParams.TYPE_PHONE,
                                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                                PixelFormat.TRANSLUCENT);
                        mParams_mvp.gravity = Gravity.RIGHT | Gravity.TOP;
                        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
                        mWindowManager.addView(mPopupView_mvp, mParams_mvp);

                        // 0.5초마다 drobe의 상태를 살피며 버튼을 보여줄지 말지 살핀다.
                        mTimer = new Timer();
                        final Handler handler = new Handler()
                        {
                            public void handleMessage(Message msg)
                            {
                                Log.i("imdoing","handler" + toString().valueOf(Drobe.state));
                                if(Drobe.state == 0){
                                    // 만약 onCreate단계면 계속 안보이고
                                    mPopupView_d.setVisibility(View.GONE);
                                    mPopupView_s.setVisibility(View.GONE);
                                    mPopupView_x.setVisibility(View.GONE);
                                }
                                if (Drobe.state == 1) {
                                    // 만약 onStop의 단계라면 지금 최상위의 Activity를 살펴 hipdrobe의 액티비티면 계속 안보이게 유지하고 아니면 다시 보여준다.
                                    Context mContext = getApplicationContext();
                                    ActivityManager activityManager = (ActivityManager) mContext.getSystemService(mContext.ACTIVITY_SERVICE);
                                    List<ActivityManager.RunningTaskInfo> info;
                                    info = activityManager.getRunningTasks(1);
                                    String top;
                                    Iterator iterator = info.iterator();
                                    ActivityManager.RunningTaskInfo runningTaskInfo = (ActivityManager.RunningTaskInfo) iterator.next();
                                    top = runningTaskInfo.topActivity.getClassName();
                                    Log.i("drobe!?",top);
                                    if (!top.contains("hipdrobe")) {
                                        mPopupView_d.setVisibility(View.VISIBLE);
                                        mPopupView_s.setVisibility(View.VISIBLE);
                                        mPopupView_x.setVisibility(View.VISIBLE);
                                        mWindowManager.removeViewImmediate(mPopupView_mvp);
                                        if (mTimer != null) {
                                            mTimer.cancel();
                                        }
                                    }
                                }
                                else if(Drobe.state==2){
                                    // 만약 onDestory의 단계면 보여준다.
                                    mPopupView_d.setVisibility(View.VISIBLE);
                                    mPopupView_s.setVisibility(View.VISIBLE);
                                    mPopupView_x.setVisibility(View.VISIBLE);
                                    mWindowManager.removeViewImmediate(mPopupView_mvp);
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
                        Intent intent = new Intent(AlwaysOnTop.this, Drobe.class);
                        intent.putExtra("from","AlwaysOnTop");
                        // 현재 실행중인 액티비티는 E 임을 저장한다.
                        Activity_Stack = "E";
                        startActivity(intent);
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
                        if(SaveOrSearch==0) { // 클릭된 버튼이 Save button 이면

                            Bitmap orgImage = BitmapFactory.decodeResource(getResources(), R.drawable.search);
                            Bitmap resize = Bitmap.createScaledBitmap(orgImage, 120, 120, true);
                            mPopupView_s.setImageBitmap(resize);// 이미지를 돋보기로 바꾸고
                            SaveOrSearch = 1; // 현재가 돋보기 상태임을 알려준다.
                            // 스크린샷 하는 동안 잠시 버튼을 보여주지 않는다.
                            mPopupView_d.setVisibility(View.GONE);
                            mPopupView_s.setVisibility(View.GONE);
                            mPopupView_x.setVisibility(View.GONE);

                            mTimer2 = new Timer();
                            final Handler handler2 = new Handler() {
                                public void handleMessage(Message msg) {
                                    Log.i("imdoing", "handler" + toString().valueOf(Drobe.state));
                                    if (Screenshot.state == 1) {
                                        //0.5초마다 확인하여 스크린샷이 끝났으면 버튼을 다시 보여준다.
                                        mPopupView_d.setVisibility(View.VISIBLE);
                                        mPopupView_s.setVisibility(View.VISIBLE);
                                        mPopupView_x.setVisibility(View.VISIBLE);
                                        // 3초후 까지 기다렸다가 다시 Savebutton 으로 바꿔준다.
                                        SearchToSave();
                                        if (mTimer2 != null) {
                                            mTimer2.cancel();
                                        }
                                    }
                                }
                            };
                            mTask2 = new TimerTask() {  //UIthread에 접근하기 위해 핸들러 사용
                                @Override
                                public void run() {
                                    new Thread() {
                                        public void run() {
                                            Message msg = handler2.obtainMessage();
                                            handler2.sendMessage(msg);
                                        }
                                    }.start();
                                }
                            };
                            mTimer2.schedule(mTask2, 100, 500);
                            startActivity(new Intent(AlwaysOnTop.this, Screenshot.class));
                        }
                        else{  // 클릭된 버튼이 돋보기면
                            // 다시 Savebutton으로 바꿔준다.
                            Bitmap orgImage = BitmapFactory.decodeResource(getResources(), R.drawable.icon_s);
                            Bitmap resize = Bitmap.createScaledBitmap(orgImage, 120, 120, true);
                            mPopupView_s.setImageBitmap(resize);
                            SaveOrSearch=0;
                            //D버튼을 눌렀을 때와 같이 버튼을 숨기고 상황을 계속 살피며 보여줄지 말지 정한다.
                            mPopupView_d.setVisibility(View.GONE);
                            mPopupView_s.setVisibility(View.GONE);
                            mPopupView_x.setVisibility(View.GONE);

                            mPopupView_mvp = new ImageView(AlwaysOnTop.this);
                            Bitmap orgImage2 = BitmapFactory.decodeResource(getResources(), R.drawable.icon_h);
                            Bitmap resize2 = Bitmap.createScaledBitmap(orgImage2, 120, 120, true);
                            mPopupView_mvp.setImageBitmap(resize2);
                            mPopupView_mvp.setOnTouchListener(mViewTouchListener_mvp);
                            mParams_mvp = new WindowManager.LayoutParams(
                                    WindowManager.LayoutParams.WRAP_CONTENT,
                                    WindowManager.LayoutParams.WRAP_CONTENT,
                                    WindowManager.LayoutParams.TYPE_PHONE,
                                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                                    PixelFormat.TRANSLUCENT);
                            mParams_mvp.gravity = Gravity.RIGHT | Gravity.TOP;
                            mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
                            mWindowManager.addView(mPopupView_mvp, mParams_mvp);

                            mTimer2 = new Timer();
                            final Handler handler2 = new Handler() {
                                public void handleMessage(Message msg) {
                                    if(Drobe_CropAndFilter.state == 0){
                                        mPopupView_d.setVisibility(View.GONE);
                                        mPopupView_s.setVisibility(View.GONE);
                                        mPopupView_x.setVisibility(View.GONE);
                                    }
                                    if (Drobe_CropAndFilter.state == 1) {
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
                                            mWindowManager.removeViewImmediate(mPopupView_mvp);
                                            if (mTimer2 != null) {
                                                mTimer2.cancel();
                                            }
                                        }
                                    }
                                    else if(Drobe_CropAndFilter.state==2){
                                        mPopupView_d.setVisibility(View.VISIBLE);
                                        mPopupView_s.setVisibility(View.VISIBLE);
                                        mPopupView_x.setVisibility(View.VISIBLE);
                                        mWindowManager.removeViewImmediate(mPopupView_mvp);
                                        if (mTimer2 != null) {
                                            mTimer2.cancel();
                                        }
                                    }
                                }
                            };
                            mTask2 = new TimerTask() {  //UIthread에 접근하기 위해 핸들러 사용
                                @Override
                                public void run() {
                                    new Thread() {
                                        public void run() {
                                            Message msg = handler2.obtainMessage();
                                            handler2.sendMessage(msg);
                                        }
                                    }.start();
                                }
                            };
                            mTimer2.schedule(mTask2, 100, 500);

                            // 현재 실행중인 액티비티는 G 임을 저장한다.
                            Activity_Stack = "G";
                            Intent intent = new Intent(AlwaysOnTop.this, Drobe_CropAndFilter.class);
                            // position이 -1임을 넘겨주어 CropAndFilter의 대상이 방금 찍은 사진임을 알려준다.
                            intent.putExtra("position",-1);
                            startActivity(intent);
                        }
                    }
                case MotionEvent.ACTION_DOWN:
                    startClickTime = Calendar.getInstance().getTimeInMillis();
            }
            return true;
        }
    };

    private View.OnTouchListener mViewTouchListener_mvp = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_UP:
                    long ClickDuration = Calendar.getInstance().getTimeInMillis() - startClickTime;
                    if (ClickDuration < MAX_CLICK_DURATION) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.kr"));
                        startActivity(intent);
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

        Bitmap orgImage = BitmapFactory.decodeResource(getResources(), R.drawable.icon_d);
        Bitmap resize = Bitmap.createScaledBitmap(orgImage, 120, 120, true);
        mPopupView_d.setImageBitmap(resize);
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

        Bitmap orgImage2 = BitmapFactory.decodeResource(getResources(), R.drawable.icon_s);
        Bitmap resize2 = Bitmap.createScaledBitmap(orgImage2, 120, 120, true);
        mPopupView_s.setImageBitmap(resize2);
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

        Bitmap orgImage3 = BitmapFactory.decodeResource(getResources(), R.drawable.icon_x);
        Bitmap resize3 = Bitmap.createScaledBitmap(orgImage3, 120, 120, true);
        mPopupView_x.setImageBitmap(resize3);
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
    private void optimizePosition_3() {
        Log.i("mParams.x", String.valueOf(mParams.x));
        Log.i("mParams.y", String.valueOf(mParams.y));
        Log.i("mParams_s.x", String.valueOf(mParams_s.x));
        Log.i("mParams_s.y", String.valueOf(mParams_s.y));
        Log.i("mParams_d.x", String.valueOf(mParams_d.x));
        Log.i("mParams_d.y", String.valueOf(mParams_d.y));
        Log.i("MAXMAX", String.valueOf(MAX_Y));
        if(mParams.x > MAX_X-120) {
            mParams.x = MAX_X-120;
            mParams_d.x = MAX_X;
            mParams_s.x = MAX_X;
        }
        if(mParams.y > MAX_Y-180) {
            mParams.y = MAX_Y-180;
            mParams_d.y = MAX_Y-300;
            mParams_s.y = MAX_Y-60;
        }
        if(mParams.x < 0) {
            mParams.x = 0;
            mParams_d.x = 120;
            mParams_s.x = 120;
        }
        if(mParams.y < 120) {
            mParams.y = 120;
            mParams_d.y = 0;
            mParams_s.y = 240;
        }
    }
    public void SearchToSave() {
        second = new TimerTask() {
            @Override
            public void run() {
                Runnable updater = new Runnable() {
                    public void run() {
                        Bitmap orgImage = BitmapFactory.decodeResource(getResources(), R.drawable.icon_s);
                        Bitmap resize = Bitmap.createScaledBitmap(orgImage, 120, 120, true);
                        mPopupView_s.setImageBitmap(resize);
                        SaveOrSearch=0;
                    }
                };
                mhandler.post(updater);
            }
        };
        Timer timer = new Timer();
        timer.schedule(second, 3500);
    }
}
