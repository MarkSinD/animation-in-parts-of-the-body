package com.gamecodeschool.hero01;

public class GameState {
    //Использование ключевого слова volatile гарантирует,
    // что все потоки всегда будут использовать общее,
    // исходное значение, и они будут видеть изменения
    // этого исходного значения другими потоками сразу же.
    private static volatile boolean mThreadRunning = false;
    private static volatile boolean mPaused = true;
    private static volatile boolean mGamerOver = true;
    private static volatile boolean mDrawing = false;

    void startNewGame(){

    }

    void stopEverything(){
        mPaused = true;
        mGamerOver = true;
        mDrawing = false;
    }

    private void startEverything(){
        mPaused = false;
        mGamerOver = false;
        mDrawing = true;
    }

    void stopThread(){ mThreadRunning = false; }
    boolean getThreadRunning(){ return mThreadRunning; }
    void startThread() { mThreadRunning = true; }
    boolean getDrawing(){ return mDrawing; }
    boolean getGameOver(){ return mGamerOver; }
    boolean getPaused(){ return mPaused; }
}
