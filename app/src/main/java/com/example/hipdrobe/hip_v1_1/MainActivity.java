package com.example.hipdrobe.hip_v1_1;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
    static int state;
    private ComponentName mService;
    private TimerTask mTask;
    private Intent i;
    private Timer mTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        state = 0;
        Log.i("MainActivity","oncreate");
        i = new Intent(MainActivity.this, AlwaysOnTop.class);
        mService = startService(i);
        Log.i("main_state", String.valueOf(i));
        finish();
    }
}
