package com.ibm.balloon.ballooning.data;

import com.ibm.balloon.ballooning.data.domain.InputBalloonData;
import com.ibm.balloon.ballooning.data.knowledgebase.BalloonStrategyConfig;
import com.ibm.balloon.ballooning.data.knowledgebase.airlines.Flight;
import com.ibm.balloon.ballooning.data.knowledgebase.gists.Gist;
import com.ibm.balloon.ballooning.data.knowledgebase.movies.Movie;
import com.ibm.balloon.ballooning.data.knowledgebase.nasa.Meteorite;
import com.ibm.balloon.ballooning.data.knowledgebase.reddit.RedditListing;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BalloonStrategyEnum {
    NASA(Meteorite.class, BalloonStrategyConfig.NASA_FILE_PATH),
    MOVIES(Movie.class, BalloonStrategyConfig.MOVIES_FILE_PATH),
    AIRLINES(Flight.class, BalloonStrategyConfig.AIRLINES_FILE_PATH),
    GISTS(Gist.class, BalloonStrategyConfig.GISTS_FILE_PATH),
    REDDIT(RedditListing.class, BalloonStrategyConfig.REDDIT_FILE_PATH);

    private final Class<? extends InputBalloonData> dtoClazz;
    private final String knowledgeBaseFile;
}
