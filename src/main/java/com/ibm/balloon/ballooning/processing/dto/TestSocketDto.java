package com.ibm.balloon.ballooning.processing.dto;

import com.ibm.balloon.ballooning.data.BalloonStrategyEnum;
import com.ibm.balloon.ballooning.processing.ProcessingStrategyEnum;
import lombok.Getter;

@Getter
public class TestSocketDto {
    private BalloonStrategyEnum datasetStrategy;
    private ProcessingStrategyEnum processingStrategy;
    private Integer recordsToSend;
    private Integer socketPort, serverPort;
    private String outputFilename;
}
