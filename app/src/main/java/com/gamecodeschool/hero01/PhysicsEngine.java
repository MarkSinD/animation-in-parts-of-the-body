package com.gamecodeschool.hero01;

import java.util.ArrayList;

public class PhysicsEngine {
    boolean update(long fps, GameObject bullet, GameObject player, GameObject back,GameState gs){


        bullet.update(fps, player.getTransform());
        player.update(fps, player.getTransform());
        back.update(fps, player.getTransform());



        return true;
    }
}
