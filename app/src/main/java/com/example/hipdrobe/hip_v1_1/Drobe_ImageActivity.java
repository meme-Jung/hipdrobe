package com.example.hipdrobe.hip_v1_1;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Drobe_ImageActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private GestureDetector gestureScanner;
    private ImageView imageView;
    public static Activity ImageAct;
    private List imgList = new ArrayList();
    private Button button;
    private int position;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageAct = this;
        Log.i("Activity_Stack",AlwaysOnTop.Activity_Stack);
        setContentView(R.layout.activity_drobe__image);
        if(Objects.equals(AlwaysOnTop.Activity_Stack, "EF")) {
            gestureScanner = new GestureDetector(this);
            imageView = (ImageView) findViewById(R.id.imageView);
            button = (Button) findViewById(R.id.hipit);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlwaysOnTop.Activity_Stack = "EFG";
                    Intent intent = new Intent(Drobe_ImageActivity.this, Drobe_CropAndFilter.class);
                    intent.putParcelableArrayListExtra("imglist", (ArrayList<? extends Parcelable>) imgList);
                    intent.putExtra("position", position);
                    startActivity(intent);
                }
            });
            setImage(imageView);
        }
        else{
            finish();
        }
    }
    private void setImage(ImageView imageView) {
        //----------------------------------------------------------------
        // 초기 액티비티의 GridView 뷰의 이미지 항목을 클릭할 때 생성된 인텐트는
        // 이 액티비티는 getIntent 메소드를 호출하여 접근할 수 있습니다.
        Intent receivedIntent = getIntent();

        //----------------------------------------------------------------
        // 확대되는 이미지의 리소스 ID를 인텐트로부터 읽어들이고,
        // 그것을 ImageView 뷰의 이미지 리소스로 설정합니다.

        imgList = receivedIntent.getParcelableArrayListExtra("imglist");
        position = (int) receivedIntent.getExtras().get("position");
        String imageURI = (String) imgList.get(position);
        imageURI = imageURI.replace("thumbnails","screenshots");
        imageView.setImageURI(Uri.parse(imageURI));
    }
    @Override
    public boolean onTouchEvent(MotionEvent me) {
        return gestureScanner.onTouchEvent(me);
    }
    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }
    @Override
    public boolean onSingleTapUp(MotionEvent e) {/*
         Toast.makeText(getApplicationContext(), "onSingleTapUp", Toast.LENGTH_SHORT).show();
        Button button = (Button) findViewById(R.id.hipit);
        Animation animation = new AlphaAnimation(0, 1);
        animation.setDuration(1000);
        button.startAnimation(animation);*/
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
        try {
            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                return false;

            // right to left swipe
            if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
    //            Toast.makeText(getApplicationContext(), "Left Swipe", Toast.LENGTH_SHORT).show();
                if(position != imgList.size()-1){
                    position = position +1;
                    String imageURI = (String) imgList.get(position);
                    imageURI = imageURI.replace("thumbnails","screenshots");
                    imageView.setImageURI(Uri.parse(imageURI));
                }
            }
            // left to right swipe
            else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
    //            Toast.makeText(getApplicationContext(), "Right Swipe", Toast.LENGTH_SHORT).show();
                if(position != 0){
                    position = position -1;
                    String imageURI = (String) imgList.get(position);
                    imageURI = imageURI.replace("thumbnails","screenshots");
                    imageView.setImageURI(Uri.parse(imageURI));
                }
            }
        } catch (Exception e) {

        }
        return true;
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
            Drobe.DrobeAct.finish();
            finish();
        }
    }
    @Override
    protected void onDestroy() {
        AlwaysOnTop.Activity_Stack = AlwaysOnTop.Activity_Stack.replace("F","");
        Log.i("Activity_Stack",AlwaysOnTop.Activity_Stack);
        super.onDestroy();
    }

}

