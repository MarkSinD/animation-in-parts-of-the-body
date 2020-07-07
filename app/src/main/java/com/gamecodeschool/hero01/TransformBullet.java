package com.gamecodeschool.hero01;

import android.graphics.PointF;
import android.graphics.RectF;

public class TransformBullet extends Transform {
    public static final String LEFT = "left";
    public static final String RIGHT = "right";
    RectF mCollider;
    private PointF mLocation;
    private float mObjectHeight;
    private float mObjectWidth;
    private float mSpeed;

    private boolean mHeadingLeft = false;
    private boolean mHeadingRight = true;



    TransformBullet(float speed, float objectWidth, float objectHeight, PointF startingLocation) {
        mSpeed = speed;
        mCollider = new RectF();
        mObjectHeight = objectHeight;
        mObjectWidth = objectWidth;
        mLocation = startingLocation;
    }


    public void updateCollider() {
        mCollider.left = mLocation.x;
        mCollider.top = mLocation.y;

        mCollider.right = mLocation.x + mObjectWidth;
        mCollider.bottom = mLocation.y + mObjectHeight;
    }


    public RectF getCollider() {
        return mCollider;
    }

    public PointF getLocation() {
        return mLocation;
    }

    public void setLocation(PointF location){ mLocation = location;}

    public PointF getSize() {
        return new PointF((int) mObjectWidth, (int) mObjectHeight);
    }

    public float getSpeed(){ return mSpeed; }

    boolean isHeadRight() {
        return mHeadingRight;
    }
    void headingRight() {mHeadingRight = true; mHeadingLeft = false;}

    boolean isHeadLeft() {
        return mHeadingLeft;
    }
    void headingLeft() {mHeadingLeft = true; mHeadingRight = false;}


}
