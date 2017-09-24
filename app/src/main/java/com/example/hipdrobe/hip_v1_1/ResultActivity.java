package com.example.hipdrobe.hip_v1_1;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ResultActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Activity_Stack",AlwaysOnTop.Activity_Stack);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        if(Objects.equals(AlwaysOnTop.Activity_Stack, "EFGH")){

        }
        else{
            finish();
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
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
    }
    @Override
    protected void onDestroy() {
        AlwaysOnTop.Activity_Stack = AlwaysOnTop.Activity_Stack.replace("H","");
        Log.i("Activity_Stack",AlwaysOnTop.Activity_Stack);
        super.onDestroy();
    }
}
