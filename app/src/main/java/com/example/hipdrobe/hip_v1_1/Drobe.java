package com.example.hipdrobe.hip_v1_1;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class Drobe extends Activity {
    private File file;
    private List imgList;
    private String STORE_DIRECTORY_thumb;
    private GridView gridView;
    static int state;
    @TargetApi(Build.VERSION_CODES.KITKAT)
    @RequiresApi(api = Build.VERSION_CODES.FROYO)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i("activity!", "onCreate");
        state=0;
        Log.i("Activity_Stack",AlwaysOnTop.Activity_Stack);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drobe);



        if(Objects.equals(AlwaysOnTop.Activity_Stack, "E")) {
            imgList = new ArrayList();
            File externalFilesDir = getExternalFilesDir(null);
            STORE_DIRECTORY_thumb = externalFilesDir.getAbsolutePath() + "/thumbnails/";
            file = new File(STORE_DIRECTORY_thumb);
            File list[] = file.listFiles();
            if (list != null) {
                for (int i = 0; i < list.length; i++) {
                    imgList.add(STORE_DIRECTORY_thumb + list[i].getName());
                }
                gridView = (GridView) findViewById(R.id.ImgGridView);
                DrobeAdapter DrobeAdapter = new DrobeAdapter(this, imgList);
                gridView.setAdapter(DrobeAdapter);
            }
        }
        else{
            finish();
        }
    }
    @Override
    protected void onStop() {
        Log.i("activity!", "onStop");
        state=1;
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
            finish();
        }
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        Log.i("activity!", "onDestroy");
        state=2;
        AlwaysOnTop.Activity_Stack = AlwaysOnTop.Activity_Stack.replace("E","");
        Log.i("Activity_Stack",AlwaysOnTop.Activity_Stack);
        super.onDestroy();
    }
}

