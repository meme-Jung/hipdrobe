package com.example.hipdrobe.hip_v1_1;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static android.app.ProgressDialog.show;

public class ResultActivity extends AppCompatActivity {
    private String category, price,imguri;
    private Integer[] mThumbIds;
    DisplayMetrics mMetrics;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Activity_Stack",AlwaysOnTop.Activity_Stack);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        if(Objects.equals(AlwaysOnTop.Activity_Stack, "EFGH")){
            // 넘어온 선택사항과 이미지에 따라서 이미지가 샘플이면 선택사항에 해당하는 drawable 이미지로 다 띄워주고 클릭하면 website로 연결.
            Intent receivedIntent = getIntent();
            category = receivedIntent.getStringExtra("category");
            price = receivedIntent.getStringExtra("price");
            imguri = receivedIntent.getStringExtra("imguri");
            if(imguri.contains("0000000000")) {
                if (Objects.equals(category, "Dress")) {
                    if (Objects.equals(price, "0~1")) {
                        mThumbIds = new Integer[]{R.drawable.view26, R.drawable.view27, R.drawable.view28, R.drawable.view29};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener17);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    } else if (Objects.equals(price, "0~2")) {
                        mThumbIds = new Integer[]{R.drawable.view26, R.drawable.view27, R.drawable.view28, R.drawable.view29, R.drawable.view30, R.drawable.view31, R.drawable.view32, R.drawable.view33};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener18);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    } else if (Objects.equals(price, "0~3")) {
                        mThumbIds = new Integer[]{R.drawable.view26, R.drawable.view27, R.drawable.view28, R.drawable.view29, R.drawable.view30, R.drawable.view31, R.drawable.view32, R.drawable.view33, R.drawable.view34, R.drawable.view35, R.drawable.view36, R.drawable.view37};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener19);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    } else if (Objects.equals(price, "0~4")) {
                        mThumbIds = new Integer[]{R.drawable.view26, R.drawable.view27, R.drawable.view28, R.drawable.view29, R.drawable.view30, R.drawable.view31, R.drawable.view32, R.drawable.view33, R.drawable.view34, R.drawable.view35, R.drawable.view36, R.drawable.view37, R.drawable.view38, R.drawable.view39, R.drawable.view40, R.drawable.view41};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener20);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    } else if (Objects.equals(price, "1~2")) {
                        mThumbIds = new Integer[]{R.drawable.view30, R.drawable.view31, R.drawable.view32, R.drawable.view33};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener21);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    } else if (Objects.equals(price, "1~3")) {
                        mThumbIds = new Integer[]{R.drawable.view30, R.drawable.view31, R.drawable.view32, R.drawable.view33, R.drawable.view34, R.drawable.view35, R.drawable.view36, R.drawable.view37};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener22);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    } else if (Objects.equals(price, "1~4")) {
                        mThumbIds = new Integer[]{R.drawable.view30, R.drawable.view31, R.drawable.view32, R.drawable.view33, R.drawable.view34, R.drawable.view35, R.drawable.view36, R.drawable.view37, R.drawable.view38, R.drawable.view39, R.drawable.view40, R.drawable.view41};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener23);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    } else if (Objects.equals(price, "2~3")) {
                        mThumbIds = new Integer[]{ R.drawable.view34, R.drawable.view35, R.drawable.view36, R.drawable.view37};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener24);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    } else if (Objects.equals(price, "2~4")) {
                        mThumbIds = new Integer[]{R.drawable.view34, R.drawable.view35, R.drawable.view36, R.drawable.view37, R.drawable.view38, R.drawable.view39, R.drawable.view40, R.drawable.view41};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener25);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    } else if (Objects.equals(price, "3~4")) {
                        mThumbIds = new Integer[]{R.drawable.view38, R.drawable.view39, R.drawable.view40, R.drawable.view41};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener26);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                }
            }
            if(imguri.contains("111111111")){
                if(Objects.equals(category, "Jacket/Blazer") || Objects.equals(category, "Outerwear/Vest")){
                    if(Objects.equals(price, "0~1")){
                        mThumbIds = new Integer[]{R.drawable.view1,R.drawable.view2,R.drawable.view3,R.drawable.view4};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener1);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "0~2")){
                        mThumbIds = new Integer[]{R.drawable.view1,R.drawable.view2,R.drawable.view3,R.drawable.view4,R.drawable.view5,R.drawable.view6,R.drawable.view7,R.drawable.view8};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener2);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "0~3")){
                        mThumbIds = new Integer[]{R.drawable.view1,R.drawable.view2,R.drawable.view3,R.drawable.view4,R.drawable.view5,R.drawable.view6,R.drawable.view7,R.drawable.view8,R.drawable.view9,R.drawable.view10,R.drawable.view11,R.drawable.view12};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener3);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "0~4")){
                        mThumbIds = new Integer[]{R.drawable.view1,R.drawable.view2,R.drawable.view3,R.drawable.view4,R.drawable.view5,R.drawable.view6,R.drawable.view7,R.drawable.view8,R.drawable.view9,R.drawable.view10,R.drawable.view11,R.drawable.view12,R.drawable.view13,R.drawable.view14,R.drawable.view15,R.drawable.view16};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener4);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "1~2")){
                        mThumbIds = new Integer[]{R.drawable.view5,R.drawable.view6,R.drawable.view7,R.drawable.view8};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener5);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "1~3")){
                        mThumbIds = new Integer[]{R.drawable.view5,R.drawable.view6,R.drawable.view7,R.drawable.view8,R.drawable.view9,R.drawable.view10,R.drawable.view11,R.drawable.view12};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener6);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "1~4")){
                        mThumbIds = new Integer[]{R.drawable.view5,R.drawable.view6,R.drawable.view7,R.drawable.view8,R.drawable.view9,R.drawable.view10,R.drawable.view11,R.drawable.view12,R.drawable.view13,R.drawable.view14,R.drawable.view15,R.drawable.view16};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener7);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "2~3")){
                        mThumbIds = new Integer[]{R.drawable.view9,R.drawable.view10,R.drawable.view11,R.drawable.view12};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener8);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "2~4")){
                        mThumbIds = new Integer[]{R.drawable.view9,R.drawable.view10,R.drawable.view11,R.drawable.view12,R.drawable.view13,R.drawable.view14,R.drawable.view15,R.drawable.view16};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener9);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "3~4")){
                        mThumbIds = new Integer[]{R.drawable.view13,R.drawable.view14,R.drawable.view15,R.drawable.view16};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener10);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                }
                if(Objects.equals(category, "Skirt")){
                    if(Objects.equals(price, "0~1")){
                        mThumbIds = new Integer[]{R.drawable.view17};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener11);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "0~2")){
                        mThumbIds = new Integer[]{R.drawable.view17,R.drawable.view18,R.drawable.view19,R.drawable.view20,R.drawable.view21};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener12);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "0~3") || Objects.equals(price, "0~4")){
                        mThumbIds = new Integer[]{R.drawable.view17,R.drawable.view18,R.drawable.view19,R.drawable.view20,R.drawable.view21,R.drawable.view22,R.drawable.view23,R.drawable.view24,R.drawable.view25};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener13);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "1~2")){
                        mThumbIds = new Integer[]{R.drawable.view18,R.drawable.view19,R.drawable.view20,R.drawable.view21};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener14);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "1~3") || Objects.equals(price, "1~4")){
                        mThumbIds = new Integer[]{R.drawable.view18,R.drawable.view19,R.drawable.view20,R.drawable.view21,R.drawable.view22,R.drawable.view23,R.drawable.view24,R.drawable.view25};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener15);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "2~3") || Objects.equals(price, "2~4")){
                        mThumbIds = new Integer[]{R.drawable.view22,R.drawable.view23,R.drawable.view24,R.drawable.view25};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener16);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                }
            }
            if(imguri.contains("222222222")){
                if(Objects.equals(category, "Knit/Sweater")){
                    if(Objects.equals(price, "0~1")){
                        mThumbIds = new Integer[]{R.drawable.view42,R.drawable.view43};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener27);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "0~2")){
                        mThumbIds = new Integer[]{R.drawable.view42,R.drawable.view43,R.drawable.view44,R.drawable.view45};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener28);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "0~3")){
                        mThumbIds = new Integer[]{R.drawable.view42,R.drawable.view43,R.drawable.view44,R.drawable.view45,R.drawable.view46,R.drawable.view47};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener29);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "0~4")){
                        mThumbIds = new Integer[]{R.drawable.view42,R.drawable.view43,R.drawable.view44,R.drawable.view45,R.drawable.view46,R.drawable.view47,R.drawable.view48,R.drawable.view49};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener30);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "1~2")){
                        mThumbIds = new Integer[]{R.drawable.view44,R.drawable.view45};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener31);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "1~3")){
                        mThumbIds = new Integer[]{R.drawable.view44,R.drawable.view45,R.drawable.view46,R.drawable.view47};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener32);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "1~4")){
                        mThumbIds = new Integer[]{R.drawable.view44,R.drawable.view45,R.drawable.view46,R.drawable.view47,R.drawable.view48,R.drawable.view49};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener33);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "2~3")){
                        mThumbIds = new Integer[]{R.drawable.view46,R.drawable.view47};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener34);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "2~4")){
                        mThumbIds = new Integer[]{R.drawable.view46,R.drawable.view47,R.drawable.view48,R.drawable.view49};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener35);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "3~4")){
                        mThumbIds = new Integer[]{R.drawable.view48,R.drawable.view49};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener36);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                }
                if( Objects.equals(category, "Skirt")){
                    if(Objects.equals(price, "0~1")){
                        mThumbIds = new Integer[]{R.drawable.view50,R.drawable.view51};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener37);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "0~2")){
                        mThumbIds = new Integer[]{R.drawable.view50,R.drawable.view51,R.drawable.view52,R.drawable.view53,R.drawable.view54,R.drawable.view55};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener38);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "0~3")){
                        mThumbIds = new Integer[]{R.drawable.view50,R.drawable.view51,R.drawable.view52,R.drawable.view53,R.drawable.view54,R.drawable.view55,R.drawable.view56,R.drawable.view57,R.drawable.view58,R.drawable.view59};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener39);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "0~4")){
                        mThumbIds = new Integer[]{R.drawable.view50,R.drawable.view51,R.drawable.view52,R.drawable.view53,R.drawable.view54,R.drawable.view55,R.drawable.view56,R.drawable.view57,R.drawable.view58,R.drawable.view59,R.drawable.view60};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener40);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "1~2")){
                        mThumbIds = new Integer[]{R.drawable.view52,R.drawable.view53,R.drawable.view54,R.drawable.view55};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener41);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "1~3")){
                        mThumbIds = new Integer[]{R.drawable.view52,R.drawable.view53,R.drawable.view54,R.drawable.view55,R.drawable.view56,R.drawable.view57,R.drawable.view58,R.drawable.view59};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener42);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "1~4")){
                        mThumbIds = new Integer[]{R.drawable.view52,R.drawable.view53,R.drawable.view54,R.drawable.view55,R.drawable.view56,R.drawable.view57,R.drawable.view58,R.drawable.view59,R.drawable.view60};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener43);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "2~3")){
                        mThumbIds = new Integer[]{R.drawable.view56,R.drawable.view57,R.drawable.view58,R.drawable.view59};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener44);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "2~4")){
                        mThumbIds = new Integer[]{R.drawable.view56,R.drawable.view57,R.drawable.view58,R.drawable.view59,R.drawable.view60};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener45);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                    else if(Objects.equals(price, "3~4")){
                        mThumbIds = new Integer[]{R.drawable.view60};
                        GridView gridview = (GridView) findViewById(R.id.gridview);
                        gridview.setAdapter(new ImageAdapter(this));
                        gridview.setOnItemClickListener(gridviewOnItemClickListener46);
                        mMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
                    }
                }
            }
        }
        else{
            finish();
        }
    }
    private GridView.OnItemClickListener gridviewOnItemClickListener1
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.blingshop.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.icecream12.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.roompacker.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lalael.com/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener2
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.blingshop.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.icecream12.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.roompacker.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lalael.com/"));
                startActivity(intent);
            }
            else if (arg2 == 4){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.choper.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 5){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lookgirl.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 6){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.blingshop.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 7){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://uniquebunny.co.kr/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener3
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.blingshop.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.icecream12.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.roompacker.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lalael.com/"));
                startActivity(intent);
            }
            else if (arg2 == 4){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.choper.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 5){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lookgirl.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 6){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.blingshop.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 7){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://uniquebunny.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 8){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.styletiba.com/"));
                startActivity(intent);
            }
            else if (arg2 == 9){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.styletiba.com/"));
                startActivity(intent);
            }
            else if (arg2 == 10){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://sonho.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 11){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://crazygirls.co.kr/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener4
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.blingshop.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.icecream12.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.roompacker.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lalael.com/"));
                startActivity(intent);
            }
            else if (arg2 == 4){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.choper.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 5){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lookgirl.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 6){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.blingshop.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 7){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://uniquebunny.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 8){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.styletiba.com/"));
                startActivity(intent);
            }
            else if (arg2 == 9){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.styletiba.com/"));
                startActivity(intent);
            }
            else if (arg2 == 10){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://sonho.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 11){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://crazygirls.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 12){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.momnuri.com/"));
                startActivity(intent);
            }
            else if (arg2 == 13){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://orange-flower.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 14){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://stylenanda.com/"));
                startActivity(intent);
            }
            else if (arg2 == 15){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://walkingcoco.co.kr/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener5
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.choper.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lookgirl.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.blingshop.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://uniquebunny.co.kr/"));
                startActivity(intent);
            }

        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener6
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.choper.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lookgirl.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.blingshop.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://uniquebunny.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 4){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.styletiba.com/"));
                startActivity(intent);
            }
            else if (arg2 == 5){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.styletiba.com/"));
                startActivity(intent);
            }
            else if (arg2 == 6){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://sonho.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 7){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://crazygirls.co.kr/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener7
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.choper.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lookgirl.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.blingshop.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://uniquebunny.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 4){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.styletiba.com/"));
                startActivity(intent);
            }
            else if (arg2 == 5){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.styletiba.com/"));
                startActivity(intent);
            }
            else if (arg2 == 6){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://sonho.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 7){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://crazygirls.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 8){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.momnuri.com/"));
                startActivity(intent);
            }
            else if (arg2 == 9){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://orange-flower.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 10){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://stylenanda.com/"));
                startActivity(intent);
            }
            else if (arg2 == 11){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://walkingcoco.co.kr/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener8
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.styletiba.com/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.styletiba.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://sonho.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://crazygirls.co.kr/"));
                startActivity(intent);
            }

        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener9
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.styletiba.com/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.styletiba.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://sonho.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://crazygirls.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 4){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.momnuri.com/"));
                startActivity(intent);
            }
            else if (arg2 == 5){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://orange-flower.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 6){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://stylenanda.com/"));
                startActivity(intent);
            }
            else if (arg2 == 7){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://walkingcoco.co.kr/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener10
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.momnuri.com/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://orange-flower.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://stylenanda.com/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://walkingcoco.co.kr/"));
                startActivity(intent);
            }

        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener11
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.eranzi.co.kr/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener12
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.eranzi.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.banharu.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sezwick.com/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ponyzn.com/"));
                startActivity(intent);
            }
            else if (arg2 == 4){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.projectlee.co.kr/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener13
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.eranzi.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.banharu.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sezwick.com/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ponyzn.com/"));
                startActivity(intent);
            }
            else if (arg2 == 4){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.projectlee.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 5){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ponyzn.com/"));
                startActivity(intent);
            }
            else if (arg2 == 6){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://littleblack.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 7){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.twang.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 8){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://prostj.com/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener14
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.banharu.com/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sezwick.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ponyzn.com/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.projectlee.co.kr/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener15
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.banharu.com/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sezwick.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ponyzn.com/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.projectlee.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 4){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ponyzn.com/"));
                startActivity(intent);
            }
            else if (arg2 == 5){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://littleblack.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 6){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.twang.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 7){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://prostj.com/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener16
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ponyzn.com/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://littleblack.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.twang.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://prostj.com/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener17
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.hippink.com/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://deepny.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ippngirl.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.justone.co.kr/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener18
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.hippink.com/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://deepny.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ippngirl.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.justone.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 4){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://im3.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 5){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lemite.com/"));
                startActivity(intent);
            }
            else if (arg2 == 6){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://realcoco.com/"));
                startActivity(intent);
            }
            else if (arg2 == 7){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://enique.co.kr/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener19
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.hippink.com/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://deepny.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ippngirl.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.justone.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 4){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://im3.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 5){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lemite.com/"));
                startActivity(intent);
            }
            else if (arg2 == 6){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://realcoco.com/"));
                startActivity(intent);
            }
            else if (arg2 == 7){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://enique.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 8){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://annadiva.com/"));
                startActivity(intent);
            }
            else if (arg2 == 9){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://muchic.com/"));
                startActivity(intent);
            }
            else if (arg2 == 10){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.marant.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 11){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.milkcocoa.co.kr/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener20
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.hippink.com/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://deepny.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ippngirl.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.justone.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 4){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://im3.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 5){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lemite.com/"));
                startActivity(intent);
            }
            else if (arg2 == 6){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://realcoco.com/"));
                startActivity(intent);
            }
            else if (arg2 == 7){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://enique.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 8){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://annadiva.com/"));
                startActivity(intent);
            }
            else if (arg2 == 9){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://muchic.com/"));
                startActivity(intent);
            }
            else if (arg2 == 10){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.marant.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 11){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.milkcocoa.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 12){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.paris-newyork.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 13){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ready2wear.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 14){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.by-vivien.com/"));
                startActivity(intent);
            }
            else if (arg2 == 15){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.thecityshop.co.kr/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener21
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://im3.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lemite.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://realcoco.com/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://enique.co.kr/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener22
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://im3.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lemite.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://realcoco.com/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://enique.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 4){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://annadiva.com/"));
                startActivity(intent);
            }
            else if (arg2 == 5){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://muchic.com/"));
                startActivity(intent);
            }
            else if (arg2 == 6){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.marant.kr//"));
                startActivity(intent);
            }
            else if (arg2 == 7){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.milkcocoa.co.kr/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener23
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://im3.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lemite.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://realcoco.com/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://enique.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 4){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://annadiva.com/"));
                startActivity(intent);
            }
            else if (arg2 == 5){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://muchic.com/"));
                startActivity(intent);
            }
            else if (arg2 == 6){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.marant.kr//"));
                startActivity(intent);
            }
            else if (arg2 == 7){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.milkcocoa.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 8){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.paris-newyork.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 9){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ready2wear.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 10){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.by-vivien.com/"));
                startActivity(intent);
            }
            else if (arg2 == 11){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.thecityshop.co.kr/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener24
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://annadiva.com/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://muchic.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.marant.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.milkcocoa.co.kr/"));
                startActivity(intent);
            }

        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener25
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://annadiva.com/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://muchic.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.marant.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.milkcocoa.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 4){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.paris-newyork.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 5){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ready2wear.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 6){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.by-vivien.com/"));
                startActivity(intent);
            }
            else if (arg2 == 7){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.thecityshop.co.kr/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener26
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.paris-newyork.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ready2wear.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.by-vivien.com/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.thecityshop.co.kr/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener27
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ogage.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.stylebonbu.com/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener28
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ogage.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.stylebonbu.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://stylenella.com/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://stylenella.com/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener29
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ogage.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.stylebonbu.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://stylenella.com/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://stylenella.com/"));
                startActivity(intent);
            }
            else if (arg2 == 4){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://storefarm.naver.com/aura4867"));
                startActivity(intent);
            }
            else if (arg2 == 5){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.wconcept.co.kr/Shop/ViewProduct.cshtml?itemcd=300284782"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener30
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ogage.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.stylebonbu.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://stylenella.com/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://stylenella.com/"));
                startActivity(intent);
            }
            else if (arg2 == 4){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://storefarm.naver.com/aura4867"));
                startActivity(intent);
            }
            else if (arg2 == 5){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.wconcept.co.kr/Shop/ViewProduct.cshtml?itemcd=300284782"));
                startActivity(intent);
            }
            else if (arg2 == 6){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://storefarm.naver.com/thehyundai/products/597065975?NaPm=ct%3Dj86xgpxk%7Cci%3D91eb51fe7d1be87bb628334de8ada5ea91388153%7Ctr%3Dslsl%7Csn%3D414435%7Cic%3D%7Chk%3Dee32f6de4035c53f8e3470b6284bb8f7d96d239b"));
                startActivity(intent);
            }
            else if (arg2 == 7){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://item.gmarket.co.kr/DetailView/Item.asp?goodscode=974556659&GoodsSale=Y&jaehuid=200001169&NaPm=ct%3Dj86xf7x4%7Cci%3D835162aded0435a3828713ece0774eb255885e13%7Ctr%3Dslsl%7Csn%3D24%7Chk%3D4e81ba2d2d8e33829a4a83e3ad001b0f5f63b9906"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener31
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://stylenella.com/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://stylenella.com/"));
                startActivity(intent);
            }

        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener32
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://stylenella.com/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://stylenella.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://storefarm.naver.com/aura4867"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.wconcept.co.kr/Shop/ViewProduct.cshtml?itemcd=300284782"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener33
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://stylenella.com/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://stylenella.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://storefarm.naver.com/aura4867"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.wconcept.co.kr/Shop/ViewProduct.cshtml?itemcd=300284782"));
                startActivity(intent);
            }
            else if (arg2 == 4){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://storefarm.naver.com/thehyundai/products/597065975?NaPm=ct%3Dj86xgpxk%7Cci%3D91eb51fe7d1be87bb628334de8ada5ea91388153%7Ctr%3Dslsl%7Csn%3D414435%7Cic%3D%7Chk%3Dee32f6de4035c53f8e3470b6284bb8f7d96d239b"));
                startActivity(intent);
            }
            else if (arg2 == 5){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://item.gmarket.co.kr/DetailView/Item.asp?goodscode=974556659&GoodsSale=Y&j1aehuid=200001169&NaPm=ct%3Dj86xf7x4%7Cci%3D835162aded0435a3828713ece0774eb255885e13%7Ctr%3Dslsl%7Csn%3D24%7Chk%3D4e81ba2d2d8e33829a4a83e3ad001b0f5f63b9906"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener34
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://storefarm.naver.com/aura4867"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.wconcept.co.kr/Shop/ViewProduct.cshtml?itemcd=300284782"));
                startActivity(intent);
            }

        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener35
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://storefarm.naver.com/aura4867"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.wconcept.co.kr/Shop/ViewProduct.cshtml?itemcd=300284782"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://storefarm.naver.com/thehyundai/products/597065975?NaPm=ct%3Dj86xgpxk%7Cci%3D91eb51fe7d1be87bb628334de8ada5ea91388153%7Ctr%3Dslsl%7Csn%3D414435%7Cic%3D%7Chk%3Dee32f6de4035c53f8e3470b6284bb8f7d96d239b"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://item.gmarket.co.kr/DetailView/Item.asp?goodscode=974556659&GoodsSale=Y&j1aehuid=200001169&NaPm=ct%3Dj86xf7x4%7Cci%3D835162aded0435a3828713ece0774eb255885e13%7Ctr%3Dslsl%7Csn%3D24%7Chk%3D4e81ba2d2d8e33829a4a83e3ad001b0f5f63b9906"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener36
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://storefarm.naver.com/thehyundai/products/597065975?NaPm=ct%3Dj86xgpxk%7Cci%3D91eb51fe7d1be87bb628334de8ada5ea91388153%7Ctr%3Dslsl%7Csn%3D414435%7Cic%3D%7Chk%3Dee32f6de4035c53f8e3470b6284bb8f7d96d239b"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://item.gmarket.co.kr/DetailView/Item.asp?goodscode=974556659&GoodsSale=Y&j1aehuid=200001169&NaPm=ct%3Dj86xf7x4%7Cci%3D835162aded0435a3828713ece0774eb255885e13%7Ctr%3Dslsl%7Csn%3D24%7Chk%3D4e81ba2d2d8e33829a4a83e3ad001b0f5f63b9906"));
                startActivity(intent);
            }

        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener37
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.myfiona.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.binary01.co.kr/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener38
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.myfiona.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.binary01.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cherrykoko.com/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ponyzn.com/"));
                startActivity(intent);
            }
            else if (arg2 == 4){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ponyzn.com/"));
                startActivity(intent);
            }
            else if (arg2 == 5){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sezwick.com/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener39
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.myfiona.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.binary01.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cherrykoko.com/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ponyzn.com/"));
                startActivity(intent);
            }
            else if (arg2 == 4){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ponyzn.com/"));
                startActivity(intent);
            }
            else if (arg2 == 5){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sezwick.com/"));
                startActivity(intent);
            }
            else if (arg2 == 6){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ponyzn.com/"));
                startActivity(intent);
            }
            else if (arg2 == 7){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lovehany.com/"));
                startActivity(intent);
            }
            else if (arg2 == 8){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.thecityshop.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 9){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sezwick.com/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener40
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.myfiona.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.binary01.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cherrykoko.com/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ponyzn.com/"));
                startActivity(intent);
            }
            else if (arg2 == 4){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ponyzn.com/"));
                startActivity(intent);
            }
            else if (arg2 == 5){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sezwick.com/"));
                startActivity(intent);
            }
            else if (arg2 == 6){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ponyzn.com/"));
                startActivity(intent);
            }
            else if (arg2 == 7){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lovehany.com/"));
                startActivity(intent);
            }
            else if (arg2 == 8){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.thecityshop.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 9){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sezwick.com/"));
                startActivity(intent);
            }
            else if (arg2 == 10){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://up-closet.com/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener41
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cherrykoko.com/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ponyzn.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ponyzn.com/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sezwick.com/"));
                startActivity(intent);
            }

        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener42
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cherrykoko.com/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ponyzn.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ponyzn.com/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sezwick.com/"));
                startActivity(intent);
            }
            else if (arg2 == 4){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ponyzn.com/"));
                startActivity(intent);
            }
            else if (arg2 == 5){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lovehany.com/"));
                startActivity(intent);
            }
            else if (arg2 == 6){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.thecityshop.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 7){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sezwick.com/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener43
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cherrykoko.com/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ponyzn.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ponyzn.com/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sezwick.com/"));
                startActivity(intent);
            }
            else if (arg2 == 4){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ponyzn.com/"));
                startActivity(intent);
            }
            else if (arg2 == 5){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lovehany.com/"));
                startActivity(intent);
            }
            else if (arg2 == 6){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.thecityshop.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 7){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sezwick.com/"));
                startActivity(intent);
            }
            else if (arg2 == 8){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://up-closet.com/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener44
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ponyzn.com/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lovehany.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.thecityshop.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sezwick.com/"));
                startActivity(intent);
            }

        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener45
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ponyzn.com/"));
                startActivity(intent);
            }
            else if (arg2 == 1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lovehany.com/"));
                startActivity(intent);
            }
            else if (arg2 == 2){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.thecityshop.co.kr/"));
                startActivity(intent);
            }
            else if (arg2 == 3){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sezwick.com/"));
                startActivity(intent);
            }
            else if (arg2 == 4){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://up-closet.com/"));
                startActivity(intent);
            }
        }
    };
    private GridView.OnItemClickListener gridviewOnItemClickListener46
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            if (arg2 == 0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://up-closet.com/"));
                startActivity(intent);
            }
        }
    };
    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return mThumbIds[position];
        }

        public long getItemId(int position) {
            return position;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {

            int rowWidth = (mMetrics.widthPixels) / 3;
            int rowHeight = (mMetrics.heightPixels) / 3;

            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(rowWidth,rowHeight));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setPadding(1, 1, 1, 1);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(mThumbIds[position]);
            return imageView;
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
            Drobe_CropAndFilter.CropAct.finish();
            Drobe_ImageActivity.ImageAct.finish();
            Drobe.DrobeAct.finish();
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
