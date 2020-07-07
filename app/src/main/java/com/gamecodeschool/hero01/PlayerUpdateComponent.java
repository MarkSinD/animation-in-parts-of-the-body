package com.gamecodeschool.hero01;

import android.graphics.PointF;
import android.util.Log;

public class PlayerUpdateComponent implements UpdateComponent {
    @Override
    public boolean update(long fps, Transform transform) {


        TransformCharacter transformCharacter = (TransformCharacter) transform;
        float range = 1000;
        PointF location = transformCharacter.getLocation();

        float speed = transformCharacter.getSpeed();

        /*Log.e("Speed = ", speed + " ");
        Log.e("speed/fps = ", speed/fps + " ");
        Log.e("location.x = ", location.x + " ");*/

        if( transformCharacter.isFacingRight()){
            location.x += speed/fps;
        }

        else if( transformCharacter.isFacingLeft()){
            location.x -= speed/fps;
        }

        if(location.x < - range || location.x > range){
            return false;
        }

        transformCharacter.updateCollider();

        return false;
    }
}
