package com.gamecodeschool.hero01;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.method.HideReturnsTransformationMethod;
import android.util.Log;

import java.util.ArrayList;

public class HUD {
    private int mScreenHeight;
    private int mScreenWidth;

    private ArrayList<Rect> mControls;

    static int LEFT = 0;
    static int RIGHT = 1;
    static int JUMP = 2;
    static int ATTAСK = 3;
    static int PAUSE = 4;

    HUD(Context context, Point size){
        mScreenHeight = size.y;
        mScreenWidth = size.x;
        prepareControls();


    }
    void draw(Canvas c, Paint p, GameState gs){

        if(!gs.getGameOver()){
            drawControls(c, p);
        }

    }

    private void prepareControls(){
        int buttonWidth = mScreenWidth / 10;
        int buttonHeight = mScreenHeight / 9;
        int buttonPadding = mScreenWidth / 90;

        Rect pause = new Rect(
                mScreenWidth - buttonPadding - buttonWidth,
                buttonPadding,
                mScreenWidth - buttonPadding,
                buttonPadding + buttonHeight);

        Rect left = new Rect(
                buttonPadding,
                mScreenHeight - buttonHeight - buttonPadding,
                buttonWidth + buttonPadding,
                mScreenHeight - buttonPadding);

        Rect right = new Rect(
                (buttonPadding * 2) + buttonWidth,
                mScreenHeight - buttonHeight - buttonPadding,
                (buttonPadding * 2) + (buttonWidth * 2),
                mScreenHeight - buttonPadding);

        Rect jump = new Rect(mScreenWidth - buttonPadding - buttonWidth,
                mScreenHeight - buttonHeight - buttonPadding,
                mScreenWidth - buttonPadding,
                mScreenHeight - buttonPadding);

        Rect attack = new Rect(mScreenWidth - buttonPadding - buttonWidth, mScreenHeight-2*buttonPadding - 2*buttonHeight,
                mScreenWidth - buttonPadding, mScreenHeight - 2*buttonPadding - buttonHeight);


        mControls = new ArrayList<>();
        mControls.add(LEFT,left);
        mControls.add(RIGHT,right);
        mControls.add(JUMP, jump);
        mControls.add(ATTAСK, attack);
        mControls.add(PAUSE, pause);

    }


    private void drawControls(Canvas c, Paint p){
        p.setColor(Color.argb(100,255,255,255));

        for(Rect r : mControls){
            c.drawRect(r.left, r.top, r.right, r.bottom, p);
        }

        p.setColor(Color.argb(255,255,255,255));
    }

    ArrayList<Rect> getControls(){
        return mControls;
    }
}
