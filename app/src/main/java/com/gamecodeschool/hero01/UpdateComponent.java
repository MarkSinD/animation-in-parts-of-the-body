package com.gamecodeschool.hero01;

public interface UpdateComponent {
    boolean update(long fps,
                   Transform transform,
                   Transform playerTransform);
}
