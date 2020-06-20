package com.gamecodeschool.hero01;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Renderer {
    private Canvas mCanvas;
    private SurfaceHolder mSurfaceHolder;
    private Paint mPaint;

    Renderer(SurfaceView sh, Point screenSize){
        mSurfaceHolder = sh.getHolder();
        mPaint = new Paint();
    }

    void draw(GameState gs){
        if(mSurfaceHolder.getSurface().isValid()){
            mCanvas = mSurfaceHolder.lockCanvas();
            mCanvas.drawColor(Color.argb(255, 180,55,55));

            if(gs.getDrawing()){

            }

            mSurfaceHolder.unlockCanvasAndPost(mCanvas);
        }
    }
}
