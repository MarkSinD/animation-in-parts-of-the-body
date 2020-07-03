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

    void setGraphics(GraphicsComponent g, Context c, GameObjectSpec spec,
                     PointF objectSize){
        mGraphicsComponent = g;
        g.initialize(c, spec, objectSize);
    }

    void setMovement(UpdateComponent m){
        mUpdateComponent = m;
    }


    void setTransform(Transform t){

        Log.e("Transform", " complete ");
        Log.e("Transform", " complete ");
        Log.e("Transform", " complete ");
        Log.e("Transform", " complete ");
        Log.e("Transform", " complete ");
        Log.e("Transform", " complete ");
        Log.e("Transform", " complete ");
        Log.e("Transform", " complete ");
        Log.e("Transform", " complete ");
        Log.e("Transform", " complete ");
        mTransform = t;
    }

    void draw(Canvas canvas, Paint paint){
        mGraphicsComponent.draw( canvas, paint, mTransform);
    }

    void setPlayerInputTransform( PlayerInputComponent s){
        s.setTransform(mTransform);
    }

    void update( long fps, Transform playerTransform){

        mUpdateComponent.update(fps, mTransform);
    }

    boolean checkActive(){ return mActive; }

    String getTag(){ return mTag; }

    void setInactive(){ mActive = false; }

    Transform getTransform(){ return mTransform; }

    void setTag(String tag){ mTag = tag; }
}