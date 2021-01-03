package com.gamecodeschool.hero01;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;

public class TransformBackground extends Transform {

    private float xClip;
    private boolean reversedFirst = false;
    private float mSpeed;
    private PointF mLocation;
    RectF mCollider;
    private float mObjectHeight;
    private float mObjectWidth;
    private static Point mScreenSize;


    TransformBackground(float speed, float objectWidth, float objectHeight, PointF startingLocation, Point screenSize) {
        mSpeed = speed;
        mObjectWidth = objectWidth;
        mObjectHeight = objectHeight;
        mLocation = startingLocation;
        mScreenSize = screenSize;
    }

    PointF getSize(){
        return new PointF((int)mObjectWidth, (int)mObjectHeight);
    }

    Point getScreenSize() { return mScreenSize; }


    void setLocation( float horizontal, float vertical){
        mLocation = new PointF(horizontal, vertical);
        updateCollider();
    }

    public float getSpeed() { return mSpeed; }

    boolean getReversedFirst(){
        return reversedFirst;
    }
    void flipReversedFirst(){
        reversedFirst=!reversedFirst;
    }

    float getXClip(){
        return  xClip;
    }

    void setXClip( float newXClip){
        xClip = newXClip;
    }

    public void updateCollider() {
        mCollider.left = mLocation.x;
        mCollider.top = mLocation.y;

        mCollider.right = mLocation.x + mObjectWidth;
        mCollider.bottom = mLocation.y + mObjectHeight;
    }
}
