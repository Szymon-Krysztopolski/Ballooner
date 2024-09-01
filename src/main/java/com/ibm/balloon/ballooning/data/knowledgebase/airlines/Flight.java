package com.ibm.balloon.ballooning.data.knowledgebase.airlines;

import com.ibm.balloon.ballooning.data.domain.InputBalloonData;
import com.ibm.balloon.ballooning.data.knowledgebase.airlines.dto.Airport;
import com.ibm.balloon.ballooning.data.knowledgebase.airlines.dto.DtoStandard;
import com.ibm.balloon.ballooning.data.knowledgebase.airlines.dto.Statistics;
import com.ibm.balloon.ballooning.data.knowledgebase.airlines.dto.Time;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Flight implements InputBalloonData, DtoStandard {
    private Airport airport;
    private Time time;
    private Statistics statistics;
}
