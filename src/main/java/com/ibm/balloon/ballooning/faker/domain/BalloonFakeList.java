package com.ibm.balloon.ballooning.faker.domain;

import com.ibm.balloon.ballooning.data.BalloonRandom;
import com.ibm.balloon.ballooning.faker.BalloonEntry;
import com.ibm.balloon.ballooning.faker.containers.ContainerFakeList;

import java.util.*;

public class BalloonFakeList<T> extends BalloonEntry {
    private final Random rand = BalloonRandom.INSTANCE.getRandom();
    private final Set<T> possibleValues = new HashSet<>();
    private List<T> elements;

    public void addValues(Collection<T> values) {
        possibleValues.addAll(values);
        elements = new ArrayList<>(possibleValues.stream().toList());
    }

    @Override
    public Object drawObject(int knowledgeBaseSize) {
        int randomLength = rand.nextInt(elements.size());

        Collections.shuffle(elements);
        double probability = (double) getKnowledgeBaseObjectAppearances() / knowledgeBaseSize;

        return (rand.nextInt(10_000) / 10_000.0 < probability)
                ? new ContainerFakeList<>(elements.subList(0, randomLength))
                : null;
    }
}
