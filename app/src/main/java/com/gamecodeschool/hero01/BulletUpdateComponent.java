package com.gamecodeschool.hero01;

import android.graphics.PointF;
import android.util.Log;

public class BulletUpdateComponent implements UpdateComponent {
    @Override
    public boolean update(long fps, Transform transform) {

        TransformBullet transformBullet = (TransformBullet) transform;
        float range = 2000;
        PointF location = transformBullet.getLocation();

        float speed = transformBullet.getSpeed();

        if( transformBullet.isHeadRight()){
            location.x += speed/fps;
        }

        else if( transformBullet.isHeadLeft()){
            location.x -= speed/fps;
        }

        if(location.x < - range || location.x > range){
            return false;
        }

        transformBullet.updateCollider();

        return true;
    }
}
