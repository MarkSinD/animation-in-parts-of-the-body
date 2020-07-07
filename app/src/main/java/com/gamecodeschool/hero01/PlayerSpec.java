package com.gamecodeschool.hero01;

import android.graphics.PointF;

import java.util.HashMap;
import java.util.Map;

public class PlayerSpec extends GameObjectSpec {

    // This is all the unique specifications for a player
    private static final String tag = "player";
    private static final int id = 3;
    private static final Map<String, Integer> bitmaps;

    static {
        bitmaps = new HashMap<String, Integer>();
        bitmaps.put("topwalkplayer3", 15);
        bitmaps.put("bottomwalkplayer3", 15);

        bitmaps.put("topidleplayer3", 15);
        bitmaps.put("bottomidleplayer3", 15);

        bitmaps.put("topshootplayer3", 9);
        bitmaps.put("bottomshootplayer3", 9);
    }

    private static final float speed = 200f;
    private static final PointF size = new PointF(512f, 512f);
    private static final String[] components = new String [] {
            "PlayerInputComponent",
            "AnimatedHeroGraphicsComponent",
            "PlayerUpdateComponent"};

    public PlayerSpec() {
        super(tag, id, speed,size,components,bitmaps);
    }
}