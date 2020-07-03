package com.gamecodeschool.hero01;

import android.graphics.Bitmap;
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

    void draw(GameState gs,  GameObject object, HUD hud){
        if(mSurfaceHolder.getSurface().isValid()){
            mCanvas = mSurfaceHolder.lockCanvas();
            mCanvas.drawColor(Color.argb(255, 180,55,55));

            if(gs.getDrawing()){

            }

            object.draw(mCanvas, mPaint);
            mPaint.setTextSize(100);
            mCanvas.drawText("IndexUP = " + PlayerInputComponent.mUpIndex, 800, 400, mPaint);

            mCanvas.drawText("LeftID = " + PlayerInputComponent.mLeftID, 1400, 600, mPaint);
            mCanvas.drawText("LeftPr = " + PlayerInputComponent.mLeftPressed, 2000, 600, mPaint);

            mCanvas.drawText("RightID = " + PlayerInputComponent.mRightID, 1400, 750, mPaint);
            mCanvas.drawText("RightPr = " + PlayerInputComponent.mRightPressed, 2000, 750, mPaint);

            mCanvas.drawText("AttackID = " + PlayerInputComponent.mAttackID, 1400, 900, mPaint);
            mCanvas.drawText("AttackPr = " + PlayerInputComponent.mAttackPressed, 2000, 900, mPaint);

            mCanvas.drawText("JumpID = " + PlayerInputComponent.mJumpID, 1400, 1050, mPaint);
            mCanvas.drawText("JumpPr = " + PlayerInputComponent.mJumpPressed, 2000, 1050, mPaint);

            mCanvas.drawText("PauseID = " + PlayerInputComponent.mPauseID, 1400, 1200, mPaint);
            mCanvas.drawText("PausePr = " + PlayerInputComponent.mPausePressed, 2000, 1200, mPaint);

            hud.draw(mCanvas, mPaint, gs);
            mSurfaceHolder.unlockCanvasAndPost(mCanvas);
        }
    }
}
