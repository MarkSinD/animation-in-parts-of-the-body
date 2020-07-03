package com.gamecodeschool.hero01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.SurfaceHolder;

public class GameActivity extends Activity {

    GameEngine mGameEngine;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        mGameEngine = new GameEngine(this, size);
        setContentView(mGameEngine);
        Log.e("Name : " ,  "onCreate HERO");
    }

    @Override
    protected void onResume(){
        super.onResume();
        mGameEngine.startThread();
    }

    @Override
    protected void onPause(){
        super.onPause();
        mGameEngine.stopThread();
    }
}
