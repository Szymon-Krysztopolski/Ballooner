package com.ibm.balloon.ballooning.faker;

public interface BalloonFaker {

    default Object drawObject(int knowledgeBaseSize) {
        return null;
    }

    String getProbability(int knowledgeBaseSize, int lvl);
}
