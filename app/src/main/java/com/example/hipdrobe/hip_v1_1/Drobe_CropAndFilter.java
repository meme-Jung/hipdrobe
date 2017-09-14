package com.example.hipdrobe.hip_v1_1;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.InputQueue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.naver.android.helloyako.imagecrop.view.ImageCropView;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Drobe_CropAndFilter extends AppCompatActivity {

    private ImageCropView imageView;
    private List imgList = new ArrayList();
    private int position;
    private Context context;
    private static final String SAMPLE_CROPPED_IMAGE_NAME = "SampleCropImage.jpeg";
    private static final int REQUEST_SELECT_PICTURE = 0x01;
    private Uri mDestinationUri;
    private String imageURI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drobe__crop_and_filter);
        //Spinner
        final String [] category_ = {"Outerwear/Vest","Jacket/Blazer","Cardigan",
                "Knit/Sweater","Shirt/Blouse","T-shirt/Top","Pants","Dress","Skirt"};
        final String [] price_ = {"1만원이하","1~3만원","3~5만원","5~10만원","10만원이상"};

        final Spinner category = (Spinner) findViewById(R.id.category);
        final Spinner price = (Spinner) findViewById(R.id.price);
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
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        // price 에 대한 Spinner
        ArrayAdapter adapter2 = new ArrayAdapter(
                getApplicationContext(), // 현재화면의 제어권자
                R.layout.spin,
                price_); // 데이터
        adapter.setDropDownViewResource(
                R.layout.spin_dropdown);
        price.setAdapter(adapter2);
        price.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        imageView = (ImageCropView) findViewById(R.id.image);
        Intent receivedIntent = getIntent();
        imgList = receivedIntent.getParcelableArrayListExtra("imglist");
        position = (int) receivedIntent.getExtras().get("position");
        imageURI = (String) imgList.get(position);
        imageURI = imageURI.replace("thumbnails", "screenshots");
        mDestinationUri = Uri.fromFile(new File(getCacheDir(), SAMPLE_CROPPED_IMAGE_NAME));
        imageView.setImageFilePath(imageURI);
        imageView.setAspectRatio(1,1);
        findViewById(R.id.complete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("", "click complete");
                Toast.makeText(Drobe_CropAndFilter.this, "Complete", Toast.LENGTH_SHORT).show();
                Bitmap b = imageView.getCroppedImage();
                bitmapConvertToFile(b);
                Intent i = new Intent(Drobe_CropAndFilter.this, ResultActivity.class);
                startActivity(i);
            }
        });
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
                            Toast.makeText(Drobe_CropAndFilter.this, "file saved", Toast.LENGTH_LONG).show();
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
}