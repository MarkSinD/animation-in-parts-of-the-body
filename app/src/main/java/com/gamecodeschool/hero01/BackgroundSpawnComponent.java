package com.gamecodeschool.hero01;

public class BackgroundSpawnComponent implements SpawnComponent {
    @Override
    public void spawn(Transform transformP, Transform transformO) {
        ((TransformBackground)transformO).setLocation(0f,0f);
    }
}
