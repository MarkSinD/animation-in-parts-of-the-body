package com.gamecodeschool.hero01;

import android.content.Context;
import android.graphics.Point;
import android.view.SurfaceView;

public class GameEngine extends SurfaceView implements Runnable, EngineController {

    private GameState mGameState;
    private Thread mThread = null;
    private long mFPS;
    private Renderer mRenderer;


    public GameEngine(Context context, Point size){
        super(context);
        mGameState = new GameState();
        mRenderer = new Renderer(this, size);
    }

    @Override
    public void run() {
        while ( mGameState.getThreadRunning() ){
            long frameStartTime = System.currentTimeMillis();
            if( !mGameState.getPaused()){
                // PhysicsEngine
            }

            mRenderer.draw(mGameState);

            long timeThisFrame = System.currentTimeMillis() - frameStartTime;
            if(timeThisFrame >= 1){
                final int MILLIS_IN_SECOND = 1000;
                mFPS = MILLIS_IN_SECOND / timeThisFrame;
            }
        }
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
        mThread = new Thread(this);
        mThread.start();
    }

    @Override
    public void startNewLevel() {
    }
}
