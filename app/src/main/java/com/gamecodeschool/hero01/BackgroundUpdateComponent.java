package com.gamecodeschool.hero01;


import android.util.Log;

public class BackgroundUpdateComponent implements UpdateComponent {

    @Override
    public boolean update(long fps, Transform transform, Transform playerTransform) {

        TransformBackground transformBackground = (TransformBackground) transform;
        TransformCharacter transformCharacter = (TransformCharacter) playerTransform;

        float currentXClip = transformBackground.getXClip();

        if(transformCharacter.isFacingRight()){
            currentXClip-= transformBackground.getSpeed()/fps;
            transformBackground.setXClip(currentXClip);
        }
        else if(transformCharacter.isFacingLeft()){
            currentXClip+= transformBackground.getSpeed()/fps;
            transformBackground.setXClip(currentXClip);
        }

        if(currentXClip >= transformBackground.getScreenSize().x){
            transformBackground.setXClip(currentXClip);
        }

        if(currentXClip >= transformBackground.getScreenSize().x){
            transformBackground.setXClip(0);
            transformBackground.flipReversedFirst();
        }
        else if(currentXClip <= 0){
            transformBackground.setXClip((int)transformBackground.getScreenSize().x);
            transformBackground.flipReversedFirst();
        }
        return  true;
    }
}
