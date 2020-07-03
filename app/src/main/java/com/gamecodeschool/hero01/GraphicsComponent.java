package com.gamecodeschool.hero01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

public interface GraphicsComponent {
    void initialize(Context c, GameObjectSpec spec, PointF objectSize);
    void draw(Canvas canvas, Paint paint, Transform t);
}
