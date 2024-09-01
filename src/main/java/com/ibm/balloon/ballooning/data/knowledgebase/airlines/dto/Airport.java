package com.ibm.balloon.ballooning.data.knowledgebase.airlines.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Airport implements DtoStandard {
    private String code, name;
}
