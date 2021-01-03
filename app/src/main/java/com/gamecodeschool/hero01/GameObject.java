package com.gamecodeschool.hero01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.Log;

public class GameObject {

    private Transform mTransform;
    private boolean mActive = true;
    private String mTag;

    private GraphicsComponent mGraphicsComponent;
    private UpdateComponent mUpdateComponent;
    private SpawnComponent spawnComponent;

    void setGraphics(GraphicsComponent g, Context c, GameObjectSpec spec,
                     PointF objectSize){
        mGraphicsComponent = g;
        g.initialize(c, spec, objectSize);
    }
    boolean spawn(Transform transformP) {
            spawnComponent.spawn(transformP, mTransform);
            mActive = true;
            return true;
    }

    void setSpawner(SpawnComponent s){ spawnComponent = s; }

    void setMovement(UpdateComponent m){
        mUpdateComponent = m;
    }
    void setTransform(Transform transform){
        mTransform = transform;
    }

    void draw(Canvas canvas, Paint paint){
        mGraphicsComponent.draw( canvas, paint, mTransform);
    }
    void setPlayerInputTransform( PlayerInputComponent s){
        s.setTransform(mTransform);
    }
    void update( long fps, Transform transformPlayer){
        mUpdateComponent.update(fps, mTransform, transformPlayer);
    }

    boolean checkActive(){ return mActive; }
    String getTag(){ return mTag; }
    void setInactive(){ mActive = false; }
    Transform getTransform(){ return mTransform; }
    void setTag(String tag){ mTag = tag; }
}