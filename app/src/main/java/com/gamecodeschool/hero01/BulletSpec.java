package com.gamecodeschool.hero01;

import android.graphics.PointF;

import java.util.HashMap;
import java.util.Map;

public class BulletSpec extends GameObjectSpec {

    // This is all the unique specifications for a player
    private static final String tag = "bullet";
    private static final int id = 1;
    private static final Map<String, Integer> bitmaps;

    static {
        bitmaps = new HashMap<String, Integer>();
        bitmaps.put("bullet", 1);
    }

    private static final float speed = 2000f;
    private static final PointF size = new PointF(40f, 40f);
    private static final String[] components = new String [] {
            "BulletGraphicsComponent",
            "BulletUpdateComponent",
            "BulletSpawnComponent"};


    BulletSpec() {
        super(tag, id, speed, size, components, bitmaps);
    }
}
