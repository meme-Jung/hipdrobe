package com.example.hipdrobe.hip_v1_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.overridePendingTransition(0,0);
        startService(new Intent(MainActivity.this, AlwaysOnTop.class));
        finish();
    }
}
