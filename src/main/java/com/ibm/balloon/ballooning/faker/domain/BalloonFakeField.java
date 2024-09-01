package com.ibm.balloon.ballooning.faker.domain;

import com.ibm.balloon.ballooning.data.BalloonRandom;
import com.ibm.balloon.ballooning.faker.BalloonEntry;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BalloonFakeField extends BalloonEntry {
    private final Random rand = BalloonRandom.INSTANCE.getRandom();
    private final Set<Object> possibleValues = new HashSet<>();
    private Object[] elements;

    @Override
    public Object drawObject(int knowledgeBaseSize) {
        int randomIndex = rand.nextInt(elements.length);
        double probability = (double) getKnowledgeBaseObjectAppearances() / knowledgeBaseSize;

        return (rand.nextInt(10_000) / 10_000.0 < probability)
                ? elements[randomIndex]
                : null;
    }

    public void addValue(Object value) {
        this.possibleValues.add(value);
        this.elements = possibleValues.toArray();
    }
}
