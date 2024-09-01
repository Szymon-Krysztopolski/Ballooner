package com.ibm.balloon.ballooning.faker.containers;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Field;
import java.util.Map;

@Getter
@AllArgsConstructor
public class ContainerFakeMap {
    private Map<Field, Object> fakeFieldsMap;
}
