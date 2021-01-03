package com.gamecodeschool.hero01;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;

public class GameObjectFactory {
    private Context mContext;
    private GameEngine mGameEngine;
    private Point mScreenSize;

    GameObjectFactory(Context context, Point mScreenSize, GameEngine gameEngine){
        mContext = context;
        this.mScreenSize = mScreenSize;
        mGameEngine = gameEngine;
    }


    GameObject create(GameObjectSpec spec, PointF location){

        GameObject object = new GameObject();

        int mNumComponents = spec.getComponents().length;

        object.setTag(spec.getTag());

        switch( object.getTag() ){
            case "player":
                object.setTransform(new TransformCharacter(spec.getSpeed(), spec.getSize().x, spec.getSize().y, location));
                break;

            case "zombie":
                object.setTransform(new TransformCharacter(spec.getSpeed(), spec.getSize().x, spec.getSize().y, location));
                break;

            case "bullet":
                object.setTransform(new TransformBullet(spec.getSpeed(), spec.getSize().x, spec.getSize().y, location));
                break;

            case "background":
                object.setTransform(new TransformBackground(spec.getSpeed(),spec.getSize().x, spec.getSize().y, location, mScreenSize));


            default:
                break;
        }

        for( int i = 0; i < mNumComponents; i++ ){
            switch( spec.getComponents()[i]){

                case "PlayerInputComponent":
                    // Code coming soon
                    object.setPlayerInputTransform(
                            new PlayerInputComponent(mGameEngine));
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

                case "AnimatedZombieGraphicsComponent":
                    // Code coming soon
                    object.setGraphics(
                            new AnimatedZombieGraphicsComponent(),
                            mContext, spec, spec.getSize());
                    break;
                case "ZombieUpdateComponent":
                    // Code coming soon
                    object.setMovement(new ZombieUpdateComponent());
                    break;

                case "BulletGraphicsComponent":
                    object.setGraphics(new BulletGraphicsComponent(),
                            mContext, spec, spec.getSize());
                    break;

                case "BulletUpdateComponent":
                    object.setMovement(new BulletUpdateComponent());
                    break;

                case "BulletSpawnComponent":
                    object.setSpawner(new BulletSpawnComponent());
                    break;

                case "BackgroundGraphicsComponent":
                    object.setGraphics(new BackgroundGraphicsComponent(),
                            mContext, spec, spec.getSize());
                    break;

                case "BackgroundUpdateComponent":
                    object.setMovement(new BackgroundUpdateComponent());
                    break;

                case "BackgroundSpawnComponent":
                    object.setSpawner(new BackgroundSpawnComponent());
                    break;



                default:
                    // Error unidentified component
                    break;
            }
        }

        return object;
    }
}
