package com.ibm.balloon.ballooning.processing;

import lombok.Getter;

@Getter
public enum ProcessingStrategyEnum {
    JSON_FIRST_LIST_FLATTENER,
    JSON_PATH_FLATTENER,
    JSON_FLATTEN,
    JSON_LIST_TO_TABLE_CONVERTER,
    JSON_DUMMY
}
