package com.example.hipdrobe.hip_v1_1;

import android.app.Activity;
import android.app.ListActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Drobe extends Activity {
    private File file;
    private List imgList;
    private String STORE_DIRECTORY_thumb;
    private GridView gridView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drobe);
        imgList = new ArrayList();
        File externalFilesDir = getExternalFilesDir(null);
        STORE_DIRECTORY_thumb = externalFilesDir.getAbsolutePath() + "/thumbnails/";
        file = new File(STORE_DIRECTORY_thumb);
        File list[] = file.listFiles();
        if(list!=null) {
            for (int i = 0; i < list.length; i++) {
                imgList.add(STORE_DIRECTORY_thumb + list[i].getName());
            }
            gridView = (GridView) findViewById(R.id.ImgGridView);
            DrobeAdapter DrobeAdapter = new DrobeAdapter(this, imgList);
            gridView.setAdapter(DrobeAdapter);
        }
    }
}

