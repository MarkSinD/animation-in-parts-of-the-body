package com.gamecodeschool.hero01;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class BitmapStore {

    private static Map<String, Bitmap> mBitmapsMap;
    private static Map<String, Bitmap> mBitmapsReservedMap;
    private static BitmapStore mOurInstance;


    static BitmapStore getInstance(Context context){
        mOurInstance = new BitmapStore(context);
        return mOurInstance;
    }

    private BitmapStore(Context c){
        mBitmapsMap = new HashMap();
        mBitmapsReservedMap = new HashMap();

    }

    static Bitmap getBitmap(String bitmapName){
        if( mBitmapsMap.containsKey(bitmapName)){
            return mBitmapsMap.get(bitmapName);
        }
        else{
            // Если не картинка не нашлась;
            Log.e("ВНИМАНИЕ = ", " Картинка не найдена и не возвращена");
            return null;
        }
    }

    static Bitmap getBitmapReversed( String bitmapName){
        if( mBitmapsReservedMap.containsKey(bitmapName)){
            return mBitmapsReservedMap.get(bitmapName);
        }
        else{
            return mBitmapsReservedMap.get("death_visible");
        }
    }

    static void addBitmap(Context c,
                          String bitmapName,
                          PointF objectSize,
                          boolean needReversed){

        Bitmap bitmap;
        Bitmap bitmapReversed;

        int resID = c.getResources().getIdentifier( bitmapName, "drawable", c.getPackageName());
        Log.e("Name : " ,  " " + bitmapName);
        Log.e("resID : " ,  " " + resID);


        bitmap = BitmapFactory.decodeResource(c.getResources(), resID);
        bitmap = Bitmap.createScaledBitmap(bitmap, (int) objectSize.x, (int) objectSize.y, false);
        mBitmapsMap.put(bitmapName, bitmap);


        if(needReversed){
            Matrix matrix = new Matrix();
            matrix.setScale(-1,1);
            bitmapReversed = Bitmap.createBitmap(bitmap, 0,0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            mBitmapsReservedMap.put(bitmapName, bitmapReversed);
        }
    }

    static void clearStore(){
        mBitmapsMap.clear();
        mBitmapsReservedMap.clear();
    }
}
