package com.gamecodeschool.hero01;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.media.SoundPool;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;

import java.util.concurrent.CopyOnWriteArrayList;

public class GameEngine extends SurfaceView implements Runnable,
        EngineController, GameEngineBroadcaster {

    private GameState mGameState;
    private SoundEngine mSoundEngine;
    private Thread mThread = null;
    public static long mFPS;
    private HUD mHUD;
    private Renderer mRenderer;
    Hero hero;
    private GameObjectFactory mGameObjectFactory;
    GameObject mPlayerObject;

    private CopyOnWriteArrayList<InputObserver>
            inputObservers = new CopyOnWriteArrayList<>();


    public GameEngine(Context context, Point size){
        super(context);
        BitmapStore bs = BitmapStore.getInstance(context);
        hero = new Hero(context, (GameEngineBroadcaster)this);
        mGameState = new GameState(this, context);
        mRenderer = new Renderer(this, size);
        mHUD = new HUD(context, size);
        mSoundEngine = SoundEngine.getInstance(context);

        mGameObjectFactory = new GameObjectFactory(context, this);
        mPlayerObject = mGameObjectFactory.create(new PlayerSpec(), new PointF(500, 500));
    }

    @Override
    public void run() {
        while ( mGameState.getThreadRunning() ){
            long frameStartTime = System.currentTimeMillis();
            if( !mGameState.getPaused()){
                // PhysicsEngine
            }

            mRenderer.draw(mGameState, mPlayerObject, mHUD);

            long timeThisFrame = System.currentTimeMillis() - frameStartTime;
            if(timeThisFrame >= 1){
                final int MILLIS_IN_SECOND = 1000;
                mFPS = MILLIS_IN_SECOND / timeThisFrame;
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        for (InputObserver o : inputObservers) {
            o.handleInput(motionEvent, mGameState, mHUD.getControls());
        }
        return true;
    }

    public  void stopThread(){
        mGameState.stopEverything();
        mGameState.stopThread();
        try {
            mThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  void startThread(){
        mGameState.startThread();
        mGameState.startNewGame();
        mThread = new Thread(this);
        mThread.start();
    }

    @Override
    public void startNewLevel() {
    }

    @Override
    public void addObserver(InputObserver o) {
        inputObservers.add(o);
    }
}
