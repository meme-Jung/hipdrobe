package com.example.hipdrobe.hip_v1_1;
import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;

public class Drobe extends Activity {

    private Context mContext;
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 100:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mContext = this;

                    GridView gv = (GridView)findViewById(R.id.ImgGridView);
                    final ImageAdapter ia = new ImageAdapter(this);
                    gv.setAdapter(ia);
                    gv.setOnItemClickListener(new OnItemClickListener(){
                        public void onItemClick(AdapterView parent, View v, int position, long id){
                            ia.callImageViewer(position);
                        }
                    });
                } else {
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},100);
                }
                return;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drobe);
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);

        if(permissionCheck== PackageManager.PERMISSION_DENIED){
            // Activity에서 실행하는경우
            if (ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},100);

                }
        }else{
            mContext = this;

            GridView gv = (GridView)findViewById(R.id.ImgGridView);
            final ImageAdapter ia = new ImageAdapter(this);
            gv.setAdapter(ia);
            gv.setOnItemClickListener(new OnItemClickListener(){
                public void onItemClick(AdapterView parent, View v, int position, long id){
                    ia.callImageViewer(position);
                }
            });
        }


    }

    /**==========================================
     *              Adapter class
     * ==========================================*/
    public class ImageAdapter extends BaseAdapter {
        private String imgData;
        private String geoData;
        private ArrayList<String> thumbsDataList;
        private ArrayList<String> thumbsIDList;

        ImageAdapter(Context c){
            mContext = c;
        }

        public final void callImageViewer(int selectedIndex){
            Intent i = new Intent(mContext, Drobe.class);
            File externalFilesDir = getExternalFilesDir(null);
            String STORE_DIRECTORY = externalFilesDir.getAbsolutePath() + "/screenshots/";
            ImageView imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
            try{
                Bitmap bm = BitmapFactory.decodeFile(STORE_DIRECTORY);  //mThumbIds[position] : 파일경로
                Bitmap resized = Bitmap.createScaledBitmap(bm, 85, 85, true); //Size 조정
                imageView.setImageBitmap(resized); //ImageView로 형변환
            }catch(Exception e){
                Log.i("" , "Error : " + e.getMessage());
            }
        }

        public boolean deleteSelected(int sIndex){
            return true;
        }

        public int getCount() {
            return thumbsIDList.size();
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }

    }
}

