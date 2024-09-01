package com.ibm.balloon.ballooning.data;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.balloon.ballooning.data.domain.InputBalloonData;
import com.ibm.balloon.ballooning.data.domain.InputBalloonDataList;
import com.ibm.balloon.ballooning.faker.containers.ContainerFakeList;
import com.ibm.balloon.ballooning.faker.domain.BalloonRoot;
import com.ibm.balloon.ballooning.faker.containers.ContainerFakeMap;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Slf4j
@AllArgsConstructor
public class BalloonFactory {
    private final Class<? extends InputBalloonData> dtoClazz;
    private final BalloonRoot root;

    BalloonFactory(BalloonStrategyEnum balloonStrategyEnum) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        this.dtoClazz = balloonStrategyEnum.getDtoClazz();
        this.root = new BalloonRoot(objectMapper.readValue(
                new File(balloonStrategyEnum.getKnowledgeBaseFile()),
                objectMapper.getTypeFactory().constructCollectionType(List.class, dtoClazz)
        ));
    }

    public InputBalloonData generateObject() {
        ContainerFakeMap data = root.drawObject();

        try {
            return mapFieldsToBalloonData(data, dtoClazz);
        } catch (Exception exception) {
            log.error("Error during generating fake object...", exception);
            return null;
        }
    }

    public String showRootProbability() {
        return root.getProbability();
    }

    private <T extends InputBalloonData> T mapFieldsToBalloonData(ContainerFakeMap fieldsMap, Class<T> targetType) throws Exception {
        T instance = targetType.getDeclaredConstructor().newInstance();
        Map<Field, Object> data = fieldsMap.getFakeFieldsMap();

        for (Map.Entry<Field, Object> entry : data.entrySet()) {
            Field field = entry.getKey();
            Object value = entry.getValue();

            if (value instanceof ContainerFakeMap) {
                Object nestedObject = mapFieldsToBalloonData(
                        (ContainerFakeMap) value,
                        (Class<T>) field.getGenericType()
                );
                field.set(instance, nestedObject);
            } else if (value instanceof ContainerFakeList<?>) {
                field.set(instance, new InputBalloonDataList<>(
                        ((ContainerFakeList<?>) value).getFakeFieldsList()
                ));
            } else {
                field.set(instance, value);
            }
        }

        return instance;
    }
}
