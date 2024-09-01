package com.ibm.balloon.ballooning.faker;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class BalloonEntry implements BalloonFaker {
    private int knowledgeBaseObjectAppearances = 0;

    public void increaseObjectAppearance() {
        knowledgeBaseObjectAppearances++;
    }

    @Override
    public String getProbability(int knowledgeBaseSize, int lvl) {
        if (knowledgeBaseSize == 0)
            knowledgeBaseSize = 1;

        return String.valueOf((double) knowledgeBaseObjectAppearances / knowledgeBaseSize);
    }
}
