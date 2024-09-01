package com.ibm.balloon.ballooning.data.knowledgebase.airlines.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.balloon.ballooning.data.domain.InputBalloonData;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Statistics implements InputBalloonData, DtoStandard {
    @JsonProperty("# of Delays")
    private Delays delays;
    private Carriers carriers;
    private Flights flights;

    @JsonProperty("Minutes Delayed")
    private MinutesDelayed minutesDelayed;

    @Data
    @NoArgsConstructor
    static class Delays implements DtoStandard {
        private Integer carrier, security, weather;

        @JsonProperty("Late Aircraft")
        private Integer lateAircraft;

        @JsonProperty("National Aviation System")
        private Integer nationalAviationSystem;
    }

    @Data
    @NoArgsConstructor
    static class Carriers implements DtoStandard {
        private String names;
        private Integer total;
    }

    @Data
    @NoArgsConstructor
    static class Flights implements DtoStandard {
        private Integer cancelled, delayed, diverted, total;

        @JsonProperty("On Time")
        private Integer onTime;
    }

    @Data
    @NoArgsConstructor
    static class MinutesDelayed implements DtoStandard {
        private Integer carrier, security, total, weather;

        @JsonProperty("Late Aircraft")
        private Integer lateAircraft;

        @JsonProperty("National Aviation System")
        private Integer nationalAviationSystem;
    }
}
