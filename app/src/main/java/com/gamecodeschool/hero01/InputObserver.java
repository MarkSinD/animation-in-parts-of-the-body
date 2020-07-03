package com.gamecodeschool.hero01;

import android.graphics.Rect;
import android.view.MotionEvent;

import java.util.ArrayList;

public interface InputObserver {
    void handleInput(MotionEvent event, GameState gs, ArrayList<Rect> buttons);
}
