package com.gamecodeschool.hero01;

import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Log;

public class TransformCharacter extends Transform {

    public static final String LEFT = "left";
    public static final String RIGHT = "right";
    RectF mCollider;
    private PointF mLocation;
    private float mObjectHeight;
    private float mObjectWidth;
    private float mSpeed;

    private boolean mFacingRight = false;
    private boolean mFacingLeft = false;
    private boolean mHeadingLeft = false;
    private boolean mHeadingRight = true;

    private boolean mAttack = false;
    private boolean mWalking = false;
    private boolean mIdling = true;
    private boolean mContinuousAnimation = false;


    private boolean mNonstopAnim = false;

    TransformCharacter(float speed, float objectWidth, float objectHeight, PointF startingLocation) {
        mSpeed = speed;
        mCollider = new RectF();
        mObjectHeight = objectHeight;
        mObjectWidth = objectWidth;
        mLocation = startingLocation;
    }

    public float getSpeed() { return mSpeed; }

    public boolean isContinuousAnimation() {
        return mContinuousAnimation;
    }

    public void setContinuousAnimation(boolean stopSignal) { mContinuousAnimation = stopSignal; }

    public boolean isWalking() {
        return mWalking;
    }

    public void setWalking(boolean mWalking) {
        mFacingLeft = false;
        mFacingRight = false;
        mIdling = true;
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


    public boolean isAttack() {
        return mAttack;
    }
    public void setAttack(boolean mShooting) {
        this.mAttack = mShooting;
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

    PointF getFiringLocation( float laserLength){
        PointF mFiringLocation = new PointF();

        /*Log.e("Location X = ", mLocation.x + " ");
        Log.e("Location Y = ", mLocation.y + " ");*/


        float horizontalPadding = mObjectWidth * 0.208984f;
        float verticalPadding = mObjectWidth * 0.517578f;

        /*Log.e("HorPad = ", horizontalPadding + " ");
        Log.e("VerPad = ", verticalPadding + " ");
        Log.e("Object Height = ", mObjectHeight + " ");
        Log.e("Object Width = ", mObjectWidth + " ");
        Log.e("FLoc.x RIGHT = ", mLocation.x + mObjectWidth - horizontalPadding + " ");
        Log.e("FLoc.x LEFT = ", mLocation.x + horizontalPadding + " ");
        Log.e("FLoc.y LEFT = ", mLocation.y + verticalPadding + " ");*/
        if (mHeadingRight) {
            mFiringLocation.x = mLocation.x + mObjectWidth - horizontalPadding;
        } else {
            mFiringLocation.x = mLocation.x + horizontalPadding;
        }

        mFiringLocation.y = mLocation.y + verticalPadding;

        return mFiringLocation;
    }
}

