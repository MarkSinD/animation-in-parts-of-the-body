package com.gamecodeschool.hero01;

import android.graphics.Rect;

interface Animator {
    Rect getCurrentFrame(long time, Transform transform);
}
