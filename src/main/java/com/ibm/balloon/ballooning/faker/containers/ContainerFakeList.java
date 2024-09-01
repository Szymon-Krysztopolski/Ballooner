package com.ibm.balloon.ballooning.faker.containers;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ContainerFakeList<T> {
    private List<T> fakeFieldsList;
}
