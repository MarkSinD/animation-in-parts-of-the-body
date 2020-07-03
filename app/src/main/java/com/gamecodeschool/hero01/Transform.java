package com.gamecodeschool.hero01;

import android.graphics.PointF;
import android.graphics.RectF;

public class Transform {

    public static final String LEFT = "left";
    public static final String RIGHT = "right";
    RectF mCollider;
    private PointF mLocation;
    private float mObjectHeight;
    private float mObjectWidth;

    private boolean mFacingRight = false;
    private boolean mFacingLeft = false;
    private boolean mHeadingLeft = false;
    private boolean mHeadingRight = true;

    private boolean mShooting = false;
    private boolean mWalking = false;
    private boolean mIdling = true;
    private boolean mStopSignalAnimation = false;


    private boolean mNonstopAnim = false;

    Transform(float speed, float objectWidth, float objectHeight, PointF startingLocation) {
        mCollider = new RectF();
        mObjectHeight = objectHeight;
        mObjectWidth = objectWidth;
        mLocation = startingLocation;
    }

    public boolean isStopSignalAnimation() {
        return mStopSignalAnimation;
    }

    public boolean isWalking() {
        return mWalking;
    }

    public void setWalking(boolean mWalking) {
        this.mWalking = mWalking;
    }

    public void setWalking(boolean mWalking, String direction) {
        switch (direction){
            case "left" : FacingLeft(); break;
            case "right" : FacingRight(); break;
        }
        this.mWalking = mWalking;
    }

    public boolean isIdling() {
        return mIdling;
    }
    public void setIdling(boolean mIdling) {
        this.mIdling = mIdling;
    }


    public boolean isShooting() {
        return mShooting;
    }
    public void setShooting(boolean mShooting) {
        this.mShooting = mShooting;
    }



    public boolean isNonstopAnim() {
        return mNonstopAnim;
    }

    public void setNonstopAnim(boolean mNonstopAnim) {
        this.mNonstopAnim = mNonstopAnim;
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

    PointF getLocation() {
        return mLocation;
    }

    PointF getSize() {
        return new PointF((int) mObjectWidth, (int) mObjectHeight);
    }

    void FacingRight() {
        mWalking = true;
        mIdling = false;

        mHeadingRight = true;
        mHeadingLeft = false;
        mFacingRight = true;
        mFacingLeft = false;
    }

    void FacingLeft() {


        mWalking = true;
        mIdling = false;

        mHeadingRight = false;
        mHeadingLeft = true;
        mFacingRight = false;
        mFacingLeft = true;
    }

    boolean isHeadRight() {
        return mHeadingRight;
    }

    boolean isHeadLeft() {
        return mHeadingLeft;
    }

    void stopHorizontal() {
        mFacingLeft = false;
        mFacingRight = false;

    }

    boolean isFacingRight() {
        return mFacingRight;
    }

    boolean isFacingLeft() {
        return mFacingLeft;
    }
}

