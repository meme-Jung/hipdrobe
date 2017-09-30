package com.example.hipdrobe.hip_v1_1;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class Drobe extends Activity {
    private File file;
    public static Activity DrobeAct;
    private List imgList;
    private String STORE_DIRECTORY_thumb;
    private String STORE_DIRECTORY;
    private GridView gridView;
    static int state;
    @TargetApi(Build.VERSION_CODES.KITKAT)
    @RequiresApi(api = Build.VERSION_CODES.FROYO)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i("activity!", "onCreate");
        DrobeAct = this;
        state=0;
        Log.i("Activity_Stack",AlwaysOnTop.Activity_Stack);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drobe);
        if(Objects.equals(AlwaysOnTop.Activity_Stack, "E")) {
            imgList = new ArrayList();
            File externalFilesDir = getExternalFilesDir(null);
            STORE_DIRECTORY_thumb = externalFilesDir.getAbsolutePath() + "/thumbnails/";
            STORE_DIRECTORY = externalFilesDir.getAbsolutePath() + "/screenshots/";

            //// 시작하자마자 Thumbnails와 ScreenShot 폴더 없으면 만들고,  sample이미지 각각 저장하기. "000000000.jpg"
            File storeDirectory = new File(STORE_DIRECTORY);


            if (!storeDirectory.exists()) {
                storeDirectory.mkdirs();
            }
            File storeDirectory2 = new File(STORE_DIRECTORY + "/HIPDROBE_" + "00000000000000" + ".png");
            if(!storeDirectory2.isFile()){
                Bitmap bitmap;
                BitmapDrawable drawable = (BitmapDrawable) getResources().getDrawable(R.drawable.sampleimg1);
                bitmap = drawable.getBitmap();
                final FileOutputStream[] fos = new FileOutputStream[1];
                try {
                    fos[0] = new FileOutputStream(STORE_DIRECTORY + "/HIPDROBE_" + "00000000000000" + ".png");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos[0]);
                createThumbnail(bitmap,STORE_DIRECTORY_thumb,"/HIPDROBE_" + "00000000000000" + ".png");

                Bitmap bitmap2;
                BitmapDrawable drawable2 = (BitmapDrawable) getResources().getDrawable(R.drawable.sampleimg2);
                bitmap2 = drawable2.getBitmap();
                final FileOutputStream[] fos2 = new FileOutputStream[1];
                try {
                    fos2[0] = new FileOutputStream(STORE_DIRECTORY + "/HIPDROBE_" + "11111111111111" + ".png");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, fos2[0]);
                createThumbnail(bitmap2,STORE_DIRECTORY_thumb,"/HIPDROBE_" + "11111111111111" + ".png");

                Bitmap bitmap3;
                BitmapDrawable drawable3 = (BitmapDrawable) getResources().getDrawable(R.drawable.sampleimg3);
                bitmap3 = drawable3.getBitmap();
                final FileOutputStream[] fos3 = new FileOutputStream[1];
                try {
                    fos3[0] = new FileOutputStream(STORE_DIRECTORY + "/HIPDROBE_" + "22222222222222" + ".png");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                bitmap3.compress(Bitmap.CompressFormat.JPEG, 100, fos3[0]);
                createThumbnail(bitmap3,STORE_DIRECTORY_thumb,"/HIPDROBE_" + "22222222222222" + ".png");
            }


            /////////////////////////////////////////////////////////////////////////////////////////////////////
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
    public static void createThumbnail(Bitmap bitmap, String strFilePath,
                                       String filename) {
        File file = new File(strFilePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        File fileCacheItem = new File(strFilePath + filename);
        OutputStream out = null;
        try {
            int height=bitmap.getHeight();
            int width=bitmap.getWidth();
            fileCacheItem.createNewFile();
            out = new FileOutputStream(fileCacheItem);
            bitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth()/4, bitmap.getHeight()/4, true);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
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

