package com.gamecodeschool.hero01;

import java.util.ArrayList;

public class PhysicsEngine {
    boolean update(long fps, GameObject bullet, GameObject player, GameState gs){


        bullet.update(fps, bullet.getTransform());
        player.update(fps, player.getTransform());


        return true;
    }
}
