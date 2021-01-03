package com.gamecodeschool.hero01;

import android.graphics.PointF;

import java.util.HashMap;
import java.util.Map;

public class BackgroundTopSpec extends  GameObjectSpec {
    private static final String tag = "background";
    private static final int id = 1;
    private static final float speed = 200f;
    private static final PointF size = new PointF(2467f, 1696f);
    private static final Map<String, Integer> bitmaps;

    static {
        bitmaps = new HashMap<String, Integer>();
        bitmaps.put("skay", 1);
    }

    private static final String[] components = new String[]{
            "BackgroundGraphicsComponent",
            "BackgroundUpdateComponent",
            "BackgroundSpawnComponent"
    };


    BackgroundTopSpec() {
        super(tag, id, speed, size, components, bitmaps);
    }
}
