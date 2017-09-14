package com.example.hipdrobe.hip_v1_1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Parcelable;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;

/**
 * Created by Her on 2017-09-12.
 */

public class DrobeAdapter extends BaseAdapter{
    Context context = null;

    //-----------------------------------------------------------
    // imageIDs는 이미지 파일들의 리소스 ID들을 담는 배열입니다.
    // 이 배열의 원소들은 자식 뷰들인 ImageView 뷰들이 무엇을 보여주는지를
    // 결정하는데 활용될 것입니다.

    private List imgList = new ArrayList();
    private Bitmap bmp;
    public DrobeAdapter(Context context, List imgList) {
        this.context = context;
        this.imgList = imgList;
    }

    public int getCount() {
        return (null != imgList) ? imgList.size() : 0;
    }

    public Object getItem(int position) {
        return (null != imgList) ? imgList.get(position) : 0;
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (null != convertView)
            imageView = (ImageView) convertView;
        else {
            imageView = new ImageView(context);
        }
        //---------------------------------------------------------------
        // GridView 뷰를 구성할 ImageView 뷰의 비트맵을 정의합니다.
        // 그리고 그것의 크기를 1/4으로 줄입니다.
       // BitmapFactory.Options options = new BitmapFactory.Options();
       // options.inSampleSize = 4;
        bmp = BitmapFactory.decodeFile((String) imgList.get(position));

        //---------------------------------------------------------------
        // GridView 뷰를 구성할 ImageView 뷰들을 정의합니다.
        // 뷰에 지정할 이미지는 앞에서 정의한 비트맵 객체입니다.
        imageView = new ImageView(context);
        imageView.setAdjustViewBounds(true);
        imageView.setImageBitmap(bmp);
        // 사진 항목들의 클릭을 처리하는 ImageClickListener 객체를 정의합니다.
        // 그리고 그것을 ImageView의 클릭 리스너로 설정합니다.
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Drobe_ImageActivity.class);
                intent.putParcelableArrayListExtra("imglist", (ArrayList<? extends Parcelable>) imgList);
                intent.putExtra("position",position);
                context.startActivity(intent);
            }
        });
        return imageView;
    }
}
