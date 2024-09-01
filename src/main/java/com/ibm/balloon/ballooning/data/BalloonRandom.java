package com.ibm.balloon.ballooning.data;

import lombok.Getter;

import java.util.Random;

@Getter
public enum BalloonRandom {
    INSTANCE;

    private final Random random;
    private final long SEED = 73925L;

    BalloonRandom() {
        random = new Random(SEED);
    }

    public void reset() {
        random.setSeed(SEED);
    }
}
