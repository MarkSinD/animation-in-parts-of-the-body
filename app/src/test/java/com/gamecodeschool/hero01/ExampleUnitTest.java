package com.gamecodeschool.hero01;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;

import static org.junit.Assert.*;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

// AssertionError - генерируемая ошибка
@RunWith(JUnit4.class)
public class ExampleUnitTest {
    @Mock
    Context mContext;

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void addition_correct() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public  void TestBitmapStore() throws Exception {

        BitmapStore mBitmapStore = BitmapStore.getInstance(mContext);
        BitmapStore.addBitmap(mContext, "skin01_gun01_shot_00", new PointF(100, 100), false);
        Bitmap mSBitmap = BitmapStore.getBitmap("skin01_gun01_shot_00");

        int resID = mContext.getResources().getIdentifier( "skin01_gun01_shot_00", "drawable", mContext.getPackageName());
        Bitmap mTBitmap = BitmapFactory.decodeResource(mContext.getResources(), resID);
        mTBitmap = Bitmap.createScaledBitmap(mTBitmap, 100 , 100 , false);

        assertEquals("Error ", mSBitmap, mTBitmap);
    }
}