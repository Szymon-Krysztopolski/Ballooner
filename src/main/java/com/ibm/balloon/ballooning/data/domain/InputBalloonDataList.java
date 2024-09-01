package com.ibm.balloon.ballooning.data.domain;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class InputBalloonDataList<T> extends ArrayList<T> {
    public InputBalloonDataList(List<T> list) {
        super(list);
    }
}
