package com.example.hipdrobe.hip_v1_1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Screenshot extends Activity {

    private static final String TAG = Screenshot.class.getName();
    private static final int REQUEST_CODE = 100;
    private static String STORE_DIRECTORY, STORE_DIRECTORY_thumb;
    private static int IMAGES_PRODUCED=0;
    private static final String SCREENCAP_NAME = "screencap";
    private static final int VIRTUAL_DISPLAY_FLAGS = DisplayManager.VIRTUAL_DISPLAY_FLAG_OWN_CONTENT_ONLY | DisplayManager.VIRTUAL_DISPLAY_FLAG_PUBLIC;
    private static MediaProjection sMediaProjection;
    private MediaProjectionManager mProjectionManager;
    private ImageReader mImageReader;
    private Handler mHandler;
    private Display mDisplay;
    private VirtualDisplay mVirtualDisplay;
    private int mDensity;
    private Bitmap bitmap;
    private int mWidth;
    private int mHeight;
    static int state = 0;
    private int mRotation;
    private OrientationChangeCallback mOrientationChangeCallback;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private class ImageAvailableListener implements ImageReader.OnImageAvailableListener {

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onImageAvailable(final ImageReader reader) {
            //// 시작하자마자 Thumbnails와 ScreenShot 폴더 없으면 만들고,  sample이미지 각각 저장하기. "000000000.jpg"
            File externalFilesDir = getExternalFilesDir(null);
            STORE_DIRECTORY = externalFilesDir.getAbsolutePath() + "/screenshots/";
            File storeDirectory2 = new File(STORE_DIRECTORY + "/HIPDROBE_" + "00000000000000" + ".png");
            File storeDirectory = new File(STORE_DIRECTORY);
            if (!storeDirectory.exists()) {
                storeDirectory.mkdirs();
            }
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
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            Log.i("brrrr","ImageAvailableListner");
            Image image = null;
            final FileOutputStream[] fos = new FileOutputStream[1];
            try {
                image = reader.acquireLatestImage();
                if (image != null) {
                    Image.Plane[] planes = image.getPlanes();
                    ByteBuffer buffer = planes[0].getBuffer();
                    int pixelStride = planes[0].getPixelStride();
                    int rowStride = planes[0].getRowStride();
                    int rowPadding = rowStride - pixelStride * mWidth;

                    // create bitmap
                    bitmap = Bitmap.createBitmap(mWidth + rowPadding / pixelStride, mHeight, Bitmap.Config.ARGB_8888);
                    bitmap.copyPixelsFromBuffer(buffer);
                    // 년월일시분초
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
                    Date currentTime = new Date();
                    String dateString = formatter.format(currentTime);
                    fos[0] = new FileOutputStream(STORE_DIRECTORY + "/HIPDROBE_" + dateString + ".png");
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos[0]);
                    createThumbnail(bitmap,STORE_DIRECTORY_thumb,"/HIPDROBE_" + dateString + ".png");
                    state =1;
                    finish();
                    sMediaProjection.stop();
                    Log.e(TAG, "captured image: " + IMAGES_PRODUCED);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (fos[0] != null) {
                    try {
                        fos[0].close();
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                }
                if (bitmap != null) {
                    bitmap.recycle();
                }
                if (image != null) {
                    image.close();
                }
            }
        }
    }

    private class OrientationChangeCallback extends OrientationEventListener {

        OrientationChangeCallback(Context context) {
            super(context);
        }
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onOrientationChanged(int orientation) {
            Log.i("brrrr","onOrientationChanged");
            final int rotation = mDisplay.getRotation();
            if (rotation != mRotation) {
                mRotation = rotation;
                try {
                    // clean up
                    if (mVirtualDisplay != null) mVirtualDisplay.release();
                    if (mImageReader != null) mImageReader.setOnImageAvailableListener(null, null);
                    // re-create virtual display depending on device width / height
                    createVirtualDisplay();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private class MediaProjectionStopCallback extends MediaProjection.Callback {
        @Override
        public void onStop() {
            Log.e("ScreenCapture", "stopping projection.");
            if (mVirtualDisplay != null) mVirtualDisplay.release();
            if (mImageReader != null) mImageReader.setOnImageAvailableListener(null, null);
            if (mOrientationChangeCallback != null) mOrientationChangeCallback.disable();
            sMediaProjection.unregisterCallback(MediaProjectionStopCallback.this);
        }
    }

    /****************************************** Activity Lifecycle methods ************************/
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("brrrr","onCreate");
        this.overridePendingTransition(0,0);
        super.onCreate(savedInstanceState);
        state=0;
        setContentView(R.layout.activity_screenshot);

        // call for the projection manager
        mProjectionManager = (MediaProjectionManager) getSystemService(Context.MEDIA_PROJECTION_SERVICE);
        startProjection();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.i("brrrr","onActivityResult");
        if (requestCode == REQUEST_CODE) {
            sMediaProjection = mProjectionManager.getMediaProjection(resultCode, data);

            if (sMediaProjection != null) {
                File externalFilesDir = getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    STORE_DIRECTORY = externalFilesDir.getAbsolutePath() + "/screenshots/";
                    STORE_DIRECTORY_thumb = externalFilesDir.getAbsolutePath() + "/thumbnails/";
                    File storeDirectory = new File(STORE_DIRECTORY);
                    if (!storeDirectory.exists()) {
                        boolean success = storeDirectory.mkdirs();
                        if (!success) {
                            Log.e(TAG, "failed to create file storage directory.");
                            return;
                        }
                    }
                } else {
                    Log.e(TAG, "failed to create file storage directory, getExternalFilesDir is null.");
                    return;
                }

                // display metrics
                DisplayMetrics metrics = getResources().getDisplayMetrics();
                mDensity = metrics.densityDpi;
                mDisplay = getWindowManager().getDefaultDisplay();

                // create virtual display depending on device width / height
                new Handler().postDelayed(new Runnable() {
                    @Override public void run() {
                        createVirtualDisplay();
                    } }, 500);

                // register orientation change callback
                mOrientationChangeCallback = new OrientationChangeCallback(this);
                if (mOrientationChangeCallback.canDetectOrientation()) {
                    mOrientationChangeCallback.enable();
                }

                // register media projection stop callback
                sMediaProjection.registerCallback(new MediaProjectionStopCallback(), mHandler);
            }
        }if (resultCode != RESULT_OK) {
            finish();
            state =1;
            return;
        }

    }

    /****************************************** UI Widget Callbacks *******************************/
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void startProjection() {
        Log.i("brrrr","startProjection");
        startActivityForResult(mProjectionManager.createScreenCaptureIntent(), REQUEST_CODE);
    }

    /****************************************** Factoring Virtual Display creation ****************/
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void createVirtualDisplay() {
        Log.i("brrrr","createVirtualDisplay");
        // get width and height
        Point size = new Point();
        mDisplay.getSize(size);
        mWidth = size.x;
        mHeight = size.y;
        // start capture reader
        mImageReader = ImageReader.newInstance(mWidth, mHeight, PixelFormat.RGBA_8888, 2);
        mVirtualDisplay = sMediaProjection.createVirtualDisplay(SCREENCAP_NAME, mWidth, mHeight, mDensity, VIRTUAL_DISPLAY_FLAGS, mImageReader.getSurface(), null, mHandler);
        mImageReader.setOnImageAvailableListener(new ImageAvailableListener(), mHandler);
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
}