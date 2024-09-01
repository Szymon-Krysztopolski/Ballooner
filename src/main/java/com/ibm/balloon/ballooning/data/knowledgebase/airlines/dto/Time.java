package com.ibm.balloon.ballooning.data.knowledgebase.airlines.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Time implements DtoStandard {
    private String label;
    private Integer month;
    private Integer year;

    @JsonProperty("Month Name")
    private String monthName;
}
