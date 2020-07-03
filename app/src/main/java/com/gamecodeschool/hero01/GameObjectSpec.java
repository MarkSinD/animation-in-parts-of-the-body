package com.gamecodeschool.hero01;

import android.graphics.PointF;

import java.util.Map;

public class GameObjectSpec {
    private String mTag;
    private int mId;
    private String mBitmapName;
    private float mSpeed;
    private PointF mSize;
    private String[] mComponents;
    private Map<String, Integer> mAnimation;

    GameObjectSpec( String tag, int id,
                    float speed,
                    PointF size,
                    String[] components,
                    Map<String, Integer> animation){
        mId = id;
        mAnimation = animation;
        mTag = tag;
        mSpeed = speed;
        mSize = size;
        mComponents = components;

    }

    public int getId(){return mId;}
    public String getTag(){ return mTag; }
    public float getSpeed(){ return mSpeed; }
    public PointF getSize(){ return  mSize; }
    public String[] getComponents(){ return mComponents; }
    public Map<String, Integer> getAnimation() {
        return mAnimation;
    }
}
