package com.gamecodeschool.hero01;

import android.graphics.PointF;
import android.util.Log;

public class BulletSpawnComponent implements SpawnComponent {

    public BulletSpawnComponent() {
        Log.e("BulletSpawnComponent1 ", "конструктор");
        Log.e("BulletSpawnComponent2 ", "конструктор");
        Log.e("BulletSpawnComponent3 ", "конструктор");
        Log.e("BulletSpawnComponent4 ", "конструктор");
        Log.e("BulletSpawnComponent5 ", "конструктор");
        Log.e("BulletSpawnComponent6 ", "конструктор");
        Log.e("BulletSpawnComponent7 ", "конструктор");
        Log.e("BulletSpawnComponent8 ", "конструктор");
    }

    @Override
    public void spawn(Transform transformP, Transform transformO) {

        Log.e("Spawn ", "вызов");
        Log.e("Spawn ", "вызов");
        Log.e("Spawn ", "вызов");
        Log.e("Spawn ", "вызов");
        Log.e("Spawn ", "вызов");
        Log.e("Spawn ", "вызов");
        Log.e("Spawn ", "вызов");

        TransformCharacter transformCharacter = (TransformCharacter) transformP;
        TransformBullet transformBullet = (TransformBullet) transformO;

        PointF startPosition =
                transformCharacter.getFiringLocation(transformBullet.getSize().x);

        transformBullet.setLocation(new PointF(startPosition.x, startPosition.y));

        if(transformCharacter.isHeadRight()){
            transformBullet.headingRight();
        }
        else{
            transformBullet.headingLeft();
        }
    }
}
