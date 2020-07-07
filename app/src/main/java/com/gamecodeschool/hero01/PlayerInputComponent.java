package com.gamecodeschool.hero01;

import android.graphics.Rect;
import android.view.MotionEvent;

import java.util.ArrayList;

public class PlayerInputComponent implements  InputObserver {


    static int mUpIndex = -1;
    static int mLeftID = -1;
    static int mRightID = -1;
    static int mAttackID = -1;
    static int mJumpID = -1;
    static int mPauseID = -1;

    static boolean mLeftPressed = false;
    static boolean mRightPressed = false;
    static boolean mAttackPressed = false;
    static boolean mJumpPressed = false;
    static boolean mPausePressed = false;

    private TransformCharacter mTransform;
    private PlayerBulletSpawner mPBS;

    PlayerInputComponent( GameEngine ger){ ger.addObserver(this); mPBS = ger;}

    public void setTransform(Transform transform){
        mTransform = (TransformCharacter)transform;
    }

    @Override
    public void handleInput(MotionEvent event, GameState gs, ArrayList<Rect> buttons) {


        int i = event.getActionIndex();
        int x = (int) event.getX(i);
        int y = (int) event.getY(i);


        int index = event.getActionIndex();
        int id = event.getPointerId(index);


        // Условный оператор тут не нужен сейчас, но позже пригодится
        if (true) {
            switch (event.getAction() & MotionEvent.ACTION_MASK) {

                case MotionEvent.ACTION_UP:

                    if (mLeftID == id) {
                        mTransform.setWalking(false);
                        mLeftID =  -1;
                        mLeftPressed = false;
                        SoundEngine.stopStep();
                    }

                    else if (mRightID == id) {
                        mTransform.setWalking(false);
                        mRightID  = -1;
                        mRightPressed = false;
                        SoundEngine.stopStep();
                    }

                    else if (mJumpID == id) {
                        mJumpID  = -1;
                        mJumpPressed = false;
                    }
                    else if (mAttackID == id) {
                        mAttackID  = -1;
                        mAttackPressed = false;
                        SoundEngine.playBullets();
                        SoundEngine.stopFire();
                        SoundEngine.stopVoice();

                        mTransform.setContinuousAnimation(false);
                        //mTransform.setAttack(false);
                    }

                    else if (mPauseID == id) {
                        mPauseID  = -1;
                        mPausePressed = false;
                    }
                    mTransform.setIdling(true);
                    break;

                case MotionEvent.ACTION_POINTER_UP:

                    if (mLeftID == id) {
                        mLeftID  = -1;
                        mLeftPressed = false;
                        SoundEngine.stopStep();

                        mTransform.setWalking(false);
                    }

                    else if (mRightID == id) {
                        mRightID = -1;
                        mRightPressed = false;
                        SoundEngine.stopStep();

                        mTransform.setWalking(false);
                    }

                    else if (mJumpID == id) {
                        mJumpID = -1;
                        mJumpPressed = false;
                    }
                    else if (mAttackID == id) {
                        mAttackID = -1;
                        mAttackPressed = false;
                        SoundEngine.stopFire();
                        SoundEngine.playBullets();
                        SoundEngine.stopVoice();

                        mTransform.setContinuousAnimation(false);
                        //mTransform.setAttack(false);
                    }

                    else if (mPauseID == id) {
                        mPauseID = -1;
                        mPausePressed = false;
                    }

                    break;

                case MotionEvent.ACTION_DOWN:
                case MotionEvent.ACTION_POINTER_DOWN:
                    mTransform.setIdling(false);
                    if (buttons.get(HUD.LEFT).contains(x, y)) {
                        if (!mRightPressed) {
                            mTransform.setWalking(true, TransformCharacter.LEFT);
                            SoundEngine.playStep();
                        }


                        mLeftID = id;
                        mLeftPressed = true;

                    }
                    else if (buttons.get(HUD.RIGHT).contains(x, y)) {
                        if (!mLeftPressed) {
                            mTransform.setWalking(true, TransformCharacter.RIGHT);
                            SoundEngine.playStep();
                        }


                        mRightID = id;
                        mRightPressed = true;



                    }
                    else if (buttons.get(HUD.JUMP).contains(x, y)) {
                        SoundEngine.playJump();
                        mJumpID = id;
                        mJumpPressed = true;
                    }
                    else if (buttons.get(HUD.ATTAСK).contains(x, y)) {
                        SoundEngine.playFire();
                        SoundEngine.playVoice();
                        mAttackID = id;
                        mAttackPressed = true;

                        mPBS.spawnPlayerLaser(mTransform);
                        mTransform.setAttack(true);
                        mTransform.setContinuousAnimation(true);
                    }
                    else if (buttons.get(HUD.PAUSE).contains(x, y)) {
                        mPauseID = id;
                        mPausePressed = true;
                    }
                    break;

                case MotionEvent.ACTION_MOVE:
                    if(mTransform.isFacingLeft() && buttons.get(HUD.RIGHT).contains(x,y)){
                        mTransform.setWalking(true, TransformCharacter.RIGHT);
                    }
                    else if(mTransform.isFacingRight() && buttons.get(HUD.LEFT).contains(x,y)){
                        mTransform.setWalking(true, TransformCharacter.LEFT);
                    }
                    break;
            }
        }
    }



}