package com.gamecodeschool.hero01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Log;

public class AnimatedHeroGraphicsComponent implements GraphicsComponent {
    Context mContext;
    private String bnWalkTop = "topwalk"; // bn - Bitmap Name
    private String bnWalkBottom = "bottomwalk";

    private String bnIdleTop = "topidle";
    private String bnIdleBottom = "bottomidle";

    private String bnShootTop = "topshoot";
    private String bnShootBottom = "bottomshoot";


    private int frameCountWalk;
    private int frameCountIdle;
    private int frameCountShoot;


    private Animator mAnWalkTop;
    private Animator mAnWalkBottom;

    private Animator mAnIdleTop;
    private Animator mAnIdleBottom;

    private Animator mAnShootTop;
    private Animator mAnShootBottom;

    private Rect mSectionToDrawTop;
    private Rect mSectionToDrawBottom;

    private Point objectSize= new Point(512,512);
    private Point mStartPosition = new Point(0,0);

    @Override
    public void initialize(Context context, GameObjectSpec spec, PointF objectSize) {



        String correctionNamBitmap = spec.getTag() +spec.getId();
        bnWalkTop     += correctionNamBitmap;
        bnWalkBottom  += correctionNamBitmap;
        bnIdleTop     += correctionNamBitmap;
        bnIdleBottom  += correctionNamBitmap;
        bnShootTop    += correctionNamBitmap;
        bnShootBottom += correctionNamBitmap;

        frameCountWalk = spec.getAnimation().get(bnWalkTop);
        frameCountIdle = spec.getAnimation().get(bnIdleTop);
        frameCountShoot = spec.getAnimation().get(bnShootTop);




        mAnWalkTop = new AnimatorCanStop( objectSize.x, objectSize.y, frameCountWalk, 30);
        float TotalWidthWalk = objectSize.x * frameCountWalk;
        BitmapStore.addBitmap( context , bnWalkTop, new PointF(TotalWidthWalk, objectSize.y), true );

        mAnWalkBottom  = new AnimatorCanStop( objectSize.x, objectSize.y, frameCountWalk, 30);
        BitmapStore.addBitmap( context , bnWalkBottom, new PointF(TotalWidthWalk, objectSize.y), true );



        mAnIdleTop  = new AnimatorCanStop( objectSize.x, objectSize.y, frameCountIdle, 25);
        float TotalWidthIdle = objectSize.x * frameCountIdle;
        BitmapStore.addBitmap( context , bnIdleTop, new PointF(TotalWidthIdle, objectSize.y), true );

        mAnIdleBottom  = new AnimatorCanStop( objectSize.x, objectSize.y, frameCountIdle, 25);
        BitmapStore.addBitmap( context , bnIdleBottom, new PointF(TotalWidthIdle, objectSize.y), true );



        mAnShootTop  = new AnimatorCanStop( objectSize.x, objectSize.y, frameCountShoot, 40);
        float TotalWidthShoot = objectSize.x * frameCountShoot;
        BitmapStore.addBitmap( context , bnShootTop, new PointF(TotalWidthShoot, objectSize.y), true );

        mAnShootBottom  = new AnimatorCanStop( objectSize.x, objectSize.y, frameCountShoot, 25);
        BitmapStore.addBitmap( context , bnShootBottom, new PointF(TotalWidthShoot, objectSize.y), true );

    }

    @Override
    public void draw(Canvas canvas, Paint paint, Transform transform) {


        Rect screenCoorfinates = new Rect(mStartPosition.x, mStartPosition.y, mStartPosition.x + 2 * objectSize.x, mStartPosition.y + 2 * objectSize.y);

        // Голова
        if(transform.isShooting()){
            mSectionToDrawBottom = mAnShootTop.getCurrentFrame(System.currentTimeMillis(), transform);


            if (transform.isHeadRight())
                canvas.drawBitmap(BitmapStore.getBitmap(bnShootTop), mSectionToDrawBottom, screenCoorfinates, paint);
            else if (transform.isHeadLeft())
                canvas.drawBitmap(BitmapStore.getBitmapReversed(bnShootTop), mSectionToDrawBottom, screenCoorfinates, paint);


        }
        else if(transform.isWalking()) {
            mSectionToDrawTop = mAnWalkTop.getCurrentFrame(System.currentTimeMillis(), transform);

            if (transform.isHeadRight())
                canvas.drawBitmap(BitmapStore.getBitmap(bnWalkTop), mSectionToDrawTop, screenCoorfinates, paint);
            else if (transform.isHeadLeft())
                canvas.drawBitmap(BitmapStore.getBitmapReversed(bnWalkTop), mSectionToDrawTop, screenCoorfinates, paint);

        }
        else{
            mSectionToDrawTop = mAnIdleTop.getCurrentFrame(System.currentTimeMillis(), transform);

            if (transform.isHeadRight())
                canvas.drawBitmap(BitmapStore.getBitmap(bnIdleTop), mSectionToDrawTop, screenCoorfinates, paint);
            else if (transform.isHeadLeft())
                canvas.drawBitmap(BitmapStore.getBitmapReversed(bnIdleTop), mSectionToDrawTop, screenCoorfinates, paint);

        }

        // Ноги
        if(transform.isWalking()) {
            mSectionToDrawBottom = mAnWalkBottom.getCurrentFrame(System.currentTimeMillis(), transform);


            if (transform.isHeadRight())
                canvas.drawBitmap(BitmapStore.getBitmap(bnWalkBottom), mSectionToDrawBottom, screenCoorfinates, paint);
            else if (transform.isHeadLeft())
                canvas.drawBitmap(BitmapStore.getBitmapReversed(bnWalkBottom), mSectionToDrawBottom, screenCoorfinates, paint);
        }
        else if(transform.isShooting() && !transform.isFacingLeft() && !transform.isFacingRight()) {
            mSectionToDrawBottom = mAnShootBottom.getCurrentFrame(System.currentTimeMillis(), transform);


            if (transform.isHeadRight())
                canvas.drawBitmap(BitmapStore.getBitmap(bnShootBottom), mSectionToDrawBottom, screenCoorfinates, paint);
            else if (transform.isHeadLeft())
                canvas.drawBitmap(BitmapStore.getBitmapReversed(bnShootBottom), mSectionToDrawBottom, screenCoorfinates, paint);

        }
        else{
            mSectionToDrawBottom = mAnIdleBottom.getCurrentFrame(System.currentTimeMillis(), transform);


            if (transform.isHeadRight())
                canvas.drawBitmap(BitmapStore.getBitmap(bnIdleBottom), mSectionToDrawBottom, screenCoorfinates, paint);
            else if (transform.isHeadLeft())
                canvas.drawBitmap(BitmapStore.getBitmapReversed(bnIdleBottom), mSectionToDrawBottom, screenCoorfinates, paint);

        }
    }
}
