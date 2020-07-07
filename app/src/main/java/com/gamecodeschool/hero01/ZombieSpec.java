package com.gamecodeschool.hero01;

import android.graphics.PointF;

import java.util.HashMap;
import java.util.Map;

public class ZombieSpec extends GameObjectSpec {

    // This is all the unique specifications for a player
    private static final String tag = "zombie";
    private static final int id = 1;
    private static final Map<String, Integer> bitmaps;

    static {
        bitmaps = new HashMap<String, Integer>();
        bitmaps.put("walkzombie1", 30);

        bitmaps.put("idlezombie1", 30);

        bitmaps.put("attackzombie1", 15);
    }

    private static final float speed = 10f;
    private static final PointF size = new PointF(512f, 512f);
    private static final String[] components = new String [] {
            "AnimatedZombieGraphicsComponent",
            "ZombieUpdateComponent"};


    ZombieSpec() {
        super(tag, id, speed, size, components, bitmaps);
    }
}
