package com.gamecodeschool.hero01;

import android.graphics.Rect;

public class AnimatorCanStop implements Animator  {
    private static String RIGHT = "right";
    private static String LEFT = "left";

    private Rect mSourceRect;
    private int mFrameCount;
    private int mCurrentFrame;
    private long mFrameTicker;
    private int mFramePeriod;
    private int mFrameWidth;
    private String CurrentMoving = null;

    AnimatorCanStop(float frameWidth, float frameHeight, int frameCount, int anim_fps){
        final int ANIM_FPS = anim_fps;
        this.mCurrentFrame = 0;
        this.mFrameCount = frameCount;
        this.mFrameWidth = (int)frameWidth;

        mSourceRect = new Rect( 0, 0, this.mFrameWidth, (int)frameHeight);
        mFramePeriod = 1000 / ANIM_FPS;
        mFrameTicker = 0L;
    }

    @Override
    public Rect getCurrentFrame(long time, TransformCharacter transform) {


        if(transform.isHeadRight()) {
            if(CurrentMoving == LEFT){
                mCurrentFrame = 0;
            }

            this.mSourceRect.left = mCurrentFrame * mFrameWidth;
            this.mSourceRect.right = this.mSourceRect.left + mFrameWidth;

            if (time > mFrameTicker + mFramePeriod) {
                mFrameTicker = time;
                mCurrentFrame++;
                if (mCurrentFrame >= mFrameCount) {
                    mCurrentFrame = 0;

                }
            }

            CurrentMoving = RIGHT;

        }
        else{
            if(CurrentMoving == RIGHT){
                mCurrentFrame = mFrameCount - 1;
            }
            if (time > mFrameTicker + mFramePeriod) {
                mFrameTicker = time;
                mCurrentFrame--;
                if (mCurrentFrame <= 0 ) {
                    mCurrentFrame = mFrameCount - 1;
                }
            }

            this.mSourceRect.left = mCurrentFrame * mFrameWidth;
            this.mSourceRect.right = this.mSourceRect.left + mFrameWidth;

            CurrentMoving = LEFT;
        }


        return mSourceRect;
    }
}
