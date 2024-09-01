package com.ibm.balloon.ballooning.faker.domain;

import com.ibm.balloon.ballooning.data.BalloonRandom;
import com.ibm.balloon.ballooning.data.domain.InputBalloonData;
import com.ibm.balloon.ballooning.data.domain.InputBalloonDataList;
import com.ibm.balloon.ballooning.faker.BalloonEntry;
import com.ibm.balloon.ballooning.faker.containers.ContainerFakeMap;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.*;

@Slf4j
@Getter
@NoArgsConstructor
public class BalloonHook extends BalloonEntry {
    private final Random rand = BalloonRandom.INSTANCE.getRandom();
    private final Map<Field, BalloonEntry> objects = new HashMap<>();
    private int knowledgeBaseSize = 0;

    public <T extends InputBalloonData, E> void addObject(T complexObject) {
        for (Field field : complexObject.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(complexObject);
                if (value != null) {
                    if (InputBalloonData.class.isAssignableFrom(field.getType())) {
                        checkKey(field, BalloonHook.class);
                        ((BalloonHook) objects.get(field)).addObject((T) value);
                    } else if (InputBalloonDataList.class.isAssignableFrom(field.getType())) {
                        checkKey(field, BalloonFakeList.class);
                        ((BalloonFakeList<E>) objects.get(field)).addValues((Collection<E>) value);
                    } else {
                        checkKey(field, BalloonFakeField.class);
                        ((BalloonFakeField) objects.get(field)).addValue(value);
                    }
                    objects.get(field).increaseObjectAppearance();
                }
            } catch (Exception e) {
                log.error("Error while creating a faker", e);
            }
        }
        knowledgeBaseSize++;
    }

    private <T extends BalloonEntry> void checkKey(Field field, Class<T> clazz) throws Exception {
        if (!objects.containsKey(field)) {
            objects.put(field, clazz.getDeclaredConstructor().newInstance());
        }
    }

    @Override
    public ContainerFakeMap drawObject(int knowledgeBaseSize) {
        double probability = (double) getKnowledgeBaseObjectAppearances() / knowledgeBaseSize;

        if (rand.nextInt(10_000) / 10_000.0 < probability) {
            return new ContainerFakeMap(objects
                    .entrySet()
                    .stream()
                    .collect(HashMap::new,
                            (m, v) -> m.put(v.getKey(), v.getValue().drawObject(getKnowledgeBaseSize())),
                            HashMap::putAll
                    ));
        }

        return null;
    }

    @Override
    public String getProbability(int knowledgeBaseSize, int lvl) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((double) getKnowledgeBaseObjectAppearances() / getKnowledgeBaseSize());

        for (Map.Entry<Field, BalloonEntry> entry : objects.entrySet()) {
            String probability = entry.getValue().getProbability(getKnowledgeBaseSize(), lvl + 1);
            stringBuilder.append("\n")
                    .append(StringUtils.repeat("\t", lvl))
                    .append(entry.getKey().getName()).append(": ")
                    .append(probability);
        }

        return stringBuilder.toString();
    }
}
