package com.example.hipdrobe.hip_v1_1;


import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.InputQueue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.naver.android.helloyako.imagecrop.view.ImageCropView;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Drobe_CropAndFilter extends AppCompatActivity {

    private File file;
    private String STORE_DIRECTORY_thumb;
    private ImageCropView imageView;
    public static Activity CropAct;

    private List imgList = new ArrayList();
    private int position;
    private Context context;
    private String categoryy = "0",pricee = "0";
    private static final String SAMPLE_CROPPED_IMAGE_NAME = "SampleCropImage.jpeg";
    private static final int REQUEST_SELECT_PICTURE = 0x01;
    private Uri mDestinationUri;
    private String imageURI;
    static int state = 0;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CropAct = this;

        ///////////////////////// 스피너에서 선택된거랑 img 이름 resultactivity 시작될때 넘겨주기.
        state = 0;
        Log.i("Activity_Stack",AlwaysOnTop.Activity_Stack);
        setContentView(R.layout.activity_drobe__crop_and_filter);
        if(Objects.equals(AlwaysOnTop.Activity_Stack, "EFG") || Objects.equals(AlwaysOnTop.Activity_Stack,"G")) {
            //Spinner
            final String[] category_ = {"Outerwear/Vest", "Jacket/Blazer", "Cardigan",
                    "Knit/Sweater", "Shirt/Blouse", "T-shirt/Top", "Pants", "Dress", "Skirt"};

            final Spinner category = (Spinner) findViewById(R.id.category);
            // category 에 대한 Spinner
            ArrayAdapter adapter = new ArrayAdapter(
                    getApplicationContext(), // 현재화면의 제어권자
                    R.layout.spin,
                    category_); // 데이터
            adapter.setDropDownViewResource(
                    R.layout.spin_dropdown);
            category.setAdapter(adapter);
            category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    categoryy= category_[position];
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });

            // price 에 대한 seekbar
            // get seekbar from view
            final CrystalRangeSeekbar price = (CrystalRangeSeekbar) findViewById(R.id.price);
            price.setMinValue(0);
            price.setMaxValue(4);
            // get min and max text view
            final TextView tvMin = (TextView) findViewById(R.id.mintxt);
            final TextView tvMax = (TextView) findViewById(R.id.maxtxt);
            // set listener
            price.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
                @Override
                public void valueChanged(Number minValue, Number maxValue) {
                    if(minValue.intValue() == 0){
                        tvMin.setText(String.valueOf(minValue));
                    }
                    else if(minValue.intValue()==1){
                        tvMin.setText("20000");
                    }
                    else if(minValue.intValue()==2){
                        tvMin.setText("50000");
                    }
                    else if(minValue.intValue()==3){
                        tvMin.setText("100000");
                    }
                    else{
                        tvMin.setText("MAX");
                    }
                    if(maxValue.intValue() == 0){
                        tvMax.setText(String.valueOf(minValue));
                    }
                    else if(maxValue.intValue()==1){
                        tvMax.setText("20000");
                    }
                    else if(maxValue.intValue()==2){
                        tvMax.setText("50000");
                    }
                    else if(maxValue.intValue()==3){
                        tvMax.setText("100000");
                    }
                    else{
                        tvMax.setText("MAX");
                    }
                    pricee = minValue.toString() +"~"+maxValue.toString();
                }
            });


            imageView = (ImageCropView) findViewById(R.id.image);
            Intent receivedIntent = getIntent();
            position = (int) receivedIntent.getExtras().get("position");

            if (position == -1) {
                imgList = new ArrayList();
                File externalFilesDir = getExternalFilesDir(null);
                STORE_DIRECTORY_thumb = externalFilesDir.getAbsolutePath() + "/thumbnails/";
                file = new File(STORE_DIRECTORY_thumb);
                File list[] = file.listFiles();
                imageURI = STORE_DIRECTORY_thumb + list[list.length - 1].getName();
            } else {
                imgList = receivedIntent.getParcelableArrayListExtra("imglist");
                imageURI = (String) imgList.get(position);
            }
            imageURI = imageURI.replace("thumbnails", "screenshots");
            mDestinationUri = Uri.fromFile(new File(getCacheDir(), SAMPLE_CROPPED_IMAGE_NAME));
            imageView.setImageFilePath(imageURI);
            imageView.setAspectRatio(1, 1);
            findViewById(R.id.complete).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("", "click complete");
       //             Toast.makeText(Drobe_CropAndFilter.this, "Complete", Toast.LENGTH_SHORT).show();
                    Bitmap b = imageView.getCroppedImage();
                    bitmapConvertToFile(b);
                    AlwaysOnTop.Activity_Stack = "EFGH";
                    Intent i = new Intent(Drobe_CropAndFilter.this, ResultActivity.class);
                    i.putExtra("category",categoryy);
                    i.putExtra("price",pricee);
                    i.putExtra("imguri",imageURI);
                    startActivity(i);
                }
            });
        }
        else{
            finish();
        }
    }
    public File bitmapConvertToFile(Bitmap bitmap) {
        FileOutputStream fileOutputStream = null;
        File bitmapFile = null;
        try {
            File file = new File(getExternalFilesDir(null).getAbsolutePath()+"/crops/" , "");
            if (!file.exists()) {
                file.mkdir();
            }
            bitmapFile = new File(file, "HIPDROBE_" + (new SimpleDateFormat("yyyyMMddHHmmss")).format(Calendar.getInstance().getTime()) + ".png");
            fileOutputStream = new FileOutputStream(bitmapFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            MediaScannerConnection.scanFile(this, new String[]{bitmapFile.getAbsolutePath()}, null, new MediaScannerConnection.MediaScannerConnectionClient() {
                @Override
                public void onMediaScannerConnected() {
                }
                @Override
                public void onScanCompleted(String path, Uri uri) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
         //                   Toast.makeText(Drobe_CropAndFilter.this, "file saved", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (Exception e) {
                }
            }
        }
        return bitmapFile;
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onStop() {
        super.onStop();
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
            if( Objects.equals(AlwaysOnTop.Activity_Stack,"EFG")) {
                Drobe_ImageActivity.ImageAct.finish();
                Drobe.DrobeAct.finish();
            }
            finish();
        }
    }
    @Override
    protected void onDestroy() {
        state=2;
        AlwaysOnTop.Activity_Stack = AlwaysOnTop.Activity_Stack.replace("G","");
        Log.i("Activity_Stack",AlwaysOnTop.Activity_Stack);
        super.onDestroy();
    }

}