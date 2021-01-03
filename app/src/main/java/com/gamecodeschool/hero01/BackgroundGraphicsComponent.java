package com.gamecodeschool.hero01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Log;

public class BackgroundGraphicsComponent implements GraphicsComponent {

    private String bnBackground = "skay";
    private int mWidth;
    private int mHeight;
    @Override
    public void initialize(Context context, GameObjectSpec spec, PointF objectSize) {
        BitmapStore.addBitmap( context , bnBackground, new PointF(objectSize.x, objectSize.y), true );
        mWidth = (int) spec.getSize().x;
        mHeight = (int) spec.getSize().y;
        Log.e("Width = ", mWidth + " ");
        Log.e("Height = ", mHeight + " ");
    }

    @Override
    public void draw(Canvas canvas, Paint paint, Transform transform) {
        TransformBackground transformBackground = (TransformBackground) transform;
        int xClip = (int) transformBackground.getXClip();
        int startY = 0;
        int endY = mHeight +20;
        int endX = transformBackground.getScreenSize().x;
        Log.e("ENDX = ", endX + " ");
        Log.e("xClip = ", xClip + " ");

        // For the regular bitmap
        Rect fromRect1 = new Rect(0, 0, endX - xClip, mHeight);
        Rect toRect1 = new Rect(xClip - (endX - mWidth), startY, endX, endY);

        // For the reversed background
        Rect fromRect2 = new Rect(endX - xClip, 0, endX, mHeight);
        Rect toRect2 = new Rect(0, startY, xClip, endY);

        //draw the two background bitmaps
        if (!transformBackground.getReversedFirst()) {
            canvas.drawBitmap(BitmapStore.getBitmap(bnBackground), fromRect1, toRect1, paint);
            canvas.drawBitmap(BitmapStore.getBitmapReversed(bnBackground), fromRect2, toRect2, paint);
        } else {
            //canvas.drawBitmap(BitmapStore.getBitmap(bnBackground), fromRect2, toRect2, paint);
            canvas.drawBitmap(BitmapStore.getBitmapReversed(bnBackground), fromRect1, toRect1, paint);
        }
    }
}
