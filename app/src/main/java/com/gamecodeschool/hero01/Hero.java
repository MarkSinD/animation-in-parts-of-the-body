package com.gamecodeschool.hero01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;


public class Hero {

    Context mContext;
    TransformCharacter heroTransform;
    private String mBitmapName1;
    private String mBitmapName2;
    private String mBitmapName3;
    private String mBitmapName4;
    private String mBitmapName5;

    private int mFrameCount1 = 11;
    private int mFrameCount2 = 15;
    private int mFrameCount3 = 11;
    private int mFrameCount4 = 15;
    private int mFrameCount5 = 15;

    private Animator mAnimatorEngine1;
    private Animator mAnimatorEngine2;
    private Animator mAnimatorEngine3;
    private Animator mAnimatorEngine4;
    private Animator mAnimatorEngine5;

    private Rect mSectionToDraw;
    private Point objectSize= new Point(512,512);


    PlayerInputComponent mPlayerInputComponent;
    private Point mStartPosition = new Point(0,0);

    Hero(Context context, GameEngineBroadcaster ger){
    }

    public void initialize() {

        mBitmapName1 = "hurtgun3";
        mBitmapName2 = "walkgun3";
        mBitmapName3 = "hurtgun3";
        mBitmapName4 = "idlegun3";
        mBitmapName5 = "idlegun3";


        float totalWidth1 = objectSize.x * mFrameCount1;
        float totalWidth2 = objectSize.x * mFrameCount2;
        float totalWidth3 = objectSize.x * mFrameCount3;
        float totalWidth4 = objectSize.x * mFrameCount4;
        float totalWidth5 = objectSize.x * mFrameCount5;


        BitmapStore.addBitmap( mContext, mBitmapName1, new PointF(totalWidth1, objectSize.y), true );
        BitmapStore.addBitmap( mContext, mBitmapName2, new PointF(totalWidth2, objectSize.y), true );
        BitmapStore.addBitmap( mContext, mBitmapName3, new PointF(totalWidth3, objectSize.y), true );
        BitmapStore.addBitmap( mContext, mBitmapName4, new PointF(totalWidth4, objectSize.y), true );
        BitmapStore.addBitmap( mContext, mBitmapName5, new PointF(totalWidth5, objectSize.y), true );

    }

    public void draw(Canvas canvas, Paint paint){
        if(heroTransform.isAttack()){
            mSectionToDraw = mAnimatorEngine1.getCurrentFrame(System.currentTimeMillis(), heroTransform);

            Rect screenCoorfinates = new Rect(mStartPosition.x, mStartPosition.y,
                    mStartPosition.x +  2 * objectSize.x,mStartPosition.y + 2 * objectSize.y);


            if (heroTransform.isHeadRight())
                canvas.drawBitmap(BitmapStore.getBitmap(mBitmapName1), mSectionToDraw, screenCoorfinates, paint);

            else if( heroTransform.isHeadLeft() )
                canvas.drawBitmap(BitmapStore.getBitmapReversed(mBitmapName1), mSectionToDraw, screenCoorfinates, paint);
        }
        else {
            mSectionToDraw = mAnimatorEngine2.getCurrentFrame(System.currentTimeMillis(), heroTransform);

            Rect screenCoorfinates = new Rect(mStartPosition.x, mStartPosition.y,
                    mStartPosition.x +  2 * objectSize.x,mStartPosition.y + 2 * objectSize.y);


            if (heroTransform.isHeadRight())
                canvas.drawBitmap(BitmapStore.getBitmap(mBitmapName2), mSectionToDraw, screenCoorfinates, paint);

            else if( heroTransform.isHeadLeft() )
                canvas.drawBitmap(BitmapStore.getBitmapReversed(mBitmapName2), mSectionToDraw, screenCoorfinates, paint);
        }
    }
}
