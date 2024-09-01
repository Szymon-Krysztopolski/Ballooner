package com.ibm.balloon.ballooning.faker.domain;

import com.ibm.balloon.ballooning.data.domain.InputBalloonData;
import com.ibm.balloon.ballooning.faker.containers.ContainerFakeMap;

import java.util.List;

public class BalloonRoot extends BalloonHook {
    public <T extends InputBalloonData> BalloonRoot(List<T> data) {
        data.forEach(super::addObject);
        super.setKnowledgeBaseObjectAppearances(data.size());
    }

    public ContainerFakeMap drawObject() {
        return super.drawObject(getKnowledgeBaseSize());
    }

    public String getProbability() {
        return String.format("\nRoot: %s\n", super.getProbability(getKnowledgeBaseSize(), 1));
    }
}
