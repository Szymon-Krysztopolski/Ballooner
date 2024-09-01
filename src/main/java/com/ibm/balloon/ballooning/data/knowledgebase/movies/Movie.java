package com.ibm.balloon.ballooning.data.knowledgebase.movies;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.ibm.balloon.ballooning.data.domain.InputBalloonData;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Movie implements InputBalloonData {
    private String title;
    private Integer year;
    private List<String> cast, genres;
    private String href, extract, thumbnail;
    private Integer thumbnailWidth, thumbnailHeight;
}
