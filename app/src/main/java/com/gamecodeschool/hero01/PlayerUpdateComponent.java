package com.gamecodeschool.hero01;

import android.graphics.PointF;
import android.util.Log;

public class PlayerUpdateComponent implements UpdateComponent {

    @Override
    public boolean update(long fps, Transform transform, Transform playerTransform) {
        TransformCharacter transformCharacter = (TransformCharacter) transform;
        float range = 1000;
        PointF location = transformCharacter.getLocation();

        float speed = transformCharacter.getSpeed();

        /*Log.e("Speed = ", speed + " ");
        Log.e("speed/fps = ", speed/fps + " ");
        Log.e("location.x = ", location.x + " ");*/


        transformCharacter.updateCollider();

        return false;
    }
}
