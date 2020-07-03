package com.gamecodeschool.hero01;

import android.content.Context;
import android.graphics.PointF;

public class GameObjectFactory {
    private Context mContext;
    private GameEngineBroadcaster mGameEngineReference;
    private int mPixelsPerMetre;

    GameObjectFactory( Context context, GameEngineBroadcaster gameEngine){
        mContext = context;
        mGameEngineReference = gameEngine;
    }


    GameObject create(GameObjectSpec spec, PointF location ){

        GameObject object = new GameObject();

        int mNumComponents = spec.getComponents().length;

        object.setTag(spec.getTag());

        switch( object.getTag() ){
            case "player":
                object.setTransform(new Transform(spec.getSpeed(), spec.getSize().x, spec.getSize().y, location));
                break;

            default:
                break;
        }

        for( int i = 0; i < mNumComponents; i++ ){
            switch( spec.getComponents()[i]){

                case "PlayerInputComponent":
                    // Code coming soon
                    object.setPlayerInputTransform(
                            new PlayerInputComponent(mGameEngineReference));
                    break;
                case "AnimatedHeroGraphicsComponent":
                    // Code coming soon
                    object.setGraphics(
                            new AnimatedHeroGraphicsComponent(),
                            mContext, spec, spec.getSize());
                    break;
                case "PlayerUpdateComponent":
                    // Code coming soon
                    object.setMovement(new PlayerUpdateComponent());
                    break;

                default:
                    // Error unidentified component
                    break;
            }
        }

        return object;
    }
}
