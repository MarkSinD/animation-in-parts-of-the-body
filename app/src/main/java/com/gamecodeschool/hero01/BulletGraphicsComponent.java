package com.gamecodeschool.hero01;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;

public class BulletGraphicsComponent implements GraphicsComponent{
    String bnBullet = "bullet";

    @Override
    public void initialize(Context context, GameObjectSpec spec, PointF objectSize) {

        BitmapStore.addBitmap( context , bnBullet, new PointF(objectSize.x, objectSize.y), true );


    }

    @Override
    public void draw(Canvas canvas, Paint paint, Transform transform) {
        TransformBullet transformBullet = (TransformBullet) transform;
        if(transformBullet.isHeadRight())
            canvas.drawBitmap(BitmapStore.getBitmap(bnBullet), transformBullet.getLocation().x,
                    transformBullet.getLocation().y, paint);

        else
            canvas.drawBitmap(BitmapStore.getBitmapReversed(bnBullet), transformBullet.getLocation().x,
                    transformBullet.getLocation().y, paint);
    }
}
