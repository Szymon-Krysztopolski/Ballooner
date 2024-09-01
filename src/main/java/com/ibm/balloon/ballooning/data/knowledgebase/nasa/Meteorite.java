package com.ibm.balloon.ballooning.data.knowledgebase.nasa;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.ibm.balloon.ballooning.data.domain.InputBalloonData;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Meteorite implements InputBalloonData {
    private String id;

    private String name, nametype, recclass, mass, fall, year, reclat, reclong;
    private Geolocation geolocation;

    @JsonProperty(":@computed_region_cbhk_fwbd")
    private String region_cbhk_fwbd;
    @JsonProperty(":@computed_region_nnqa_25f4")
    private String region_nnqa_25f4;

    @Data
    @NoArgsConstructor
    public static class Geolocation implements InputBalloonData {
        private String type;
        private List<Double> coordinates;
    }
}
