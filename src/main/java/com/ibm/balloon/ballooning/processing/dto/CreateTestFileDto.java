package com.ibm.balloon.ballooning.processing.dto;

import com.ibm.balloon.ballooning.data.BalloonStrategyEnum;
import lombok.Getter;

@Getter
public class CreateTestFileDto {
    private BalloonStrategyEnum balloonStrategyEnum;
    private Integer fileSize;
    private Integer numberOfFiles;
    private Boolean isJsonList;
}
