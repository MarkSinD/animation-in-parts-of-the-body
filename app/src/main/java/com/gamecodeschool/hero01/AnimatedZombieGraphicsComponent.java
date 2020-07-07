package com.gamecodeschool.hero01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Log;

public class AnimatedZombieGraphicsComponent  implements GraphicsComponent  {

    private String bnWalk = "walk";
    private String bnIdle = "idle";
    private String bnAttack = "attack";


    private int frameCountWalk;
    private int frameCountIdle;
    private int frameCountShoot;


    private Animator mAnWalk;
    private Animator mAnIdle;
    private Animator mAnAttack;

    private Rect mSectionToDraw;

    private Point objectSize= new Point(512,512);
    private Point mStartPosition = new Point(1000,1000);

    @Override
    public void initialize(Context context, GameObjectSpec spec, PointF objectSize) {

        String correctionNamBitmap = spec.getTag() +spec.getId();
        bnWalk += correctionNamBitmap;
        bnIdle += correctionNamBitmap;
        bnAttack += correctionNamBitmap;

        Log.e("Zombie ", bnWalk + " " + correctionNamBitmap);
        frameCountWalk = spec.getAnimation().get(bnWalk);
        frameCountIdle = spec.getAnimation().get(bnIdle);
        frameCountShoot = spec.getAnimation().get(bnAttack);


        mAnWalk = new AnimatorCanStop( objectSize.x, objectSize.y, frameCountWalk, 30);
        float TotalWidthWalk = objectSize.x * frameCountWalk;
        BitmapStore.addBitmap( context , bnWalk, new PointF(TotalWidthWalk, objectSize.y), true );


        mAnIdle = new AnimatorCanStop( objectSize.x, objectSize.y, frameCountIdle, 25);
        float TotalWidthIdle = objectSize.x * frameCountIdle;
        BitmapStore.addBitmap( context , bnIdle, new PointF(TotalWidthIdle, objectSize.y), true );


        mAnAttack = new AnimatorCanStop( objectSize.x, objectSize.y, frameCountShoot, 40);
        float TotalWidthShoot = objectSize.x * frameCountShoot;
        BitmapStore.addBitmap( context , bnAttack, new PointF(TotalWidthShoot, objectSize.y), true );

    }

    @Override
    public void draw(Canvas canvas, Paint paint, Transform transform) {

        TransformCharacter transformCharacter = (TransformCharacter) transform;

        Rect screenCoorfinates = new Rect(mStartPosition.x, mStartPosition.y, mStartPosition.x + objectSize.x, mStartPosition.y + objectSize.y);

        // Голова
        if(transformCharacter.isAttack() || true){
            mSectionToDraw = mAnAttack.getCurrentFrame(System.currentTimeMillis(), transformCharacter);


            if (transformCharacter.isHeadRight())
                canvas.drawBitmap(BitmapStore.getBitmap(bnAttack), mSectionToDraw, screenCoorfinates, paint);
            else if (transformCharacter.isHeadLeft())
                canvas.drawBitmap(BitmapStore.getBitmapReversed(bnAttack), mSectionToDraw, screenCoorfinates, paint);


        }
        else if(transformCharacter.isWalking()) {
            mSectionToDraw = mAnWalk.getCurrentFrame(System.currentTimeMillis(), transformCharacter);

            if (transformCharacter.isHeadRight())
                canvas.drawBitmap(BitmapStore.getBitmap(bnWalk), mSectionToDraw, screenCoorfinates, paint);
            else if (transformCharacter.isHeadLeft())
                canvas.drawBitmap(BitmapStore.getBitmapReversed(bnWalk), mSectionToDraw, screenCoorfinates, paint);

        }
        else{
            mSectionToDraw = mAnIdle.getCurrentFrame(System.currentTimeMillis(), transformCharacter);

            if (transformCharacter.isHeadRight())
                canvas.drawBitmap(BitmapStore.getBitmap(bnIdle), mSectionToDraw, screenCoorfinates, paint);
            else if (transformCharacter.isHeadLeft())
                canvas.drawBitmap(BitmapStore.getBitmapReversed(bnIdle), mSectionToDraw, screenCoorfinates, paint);

        }
    }
}
