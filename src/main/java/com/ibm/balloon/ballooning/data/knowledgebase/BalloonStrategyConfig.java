package com.ibm.balloon.ballooning.data.knowledgebase;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BalloonStrategyConfig {
    @Value("${ballooning.data.filePath.meteorite}")
    private String nasaFilePath;

    @Value("${ballooning.data.filePath.movie}")
    private String moviesFilePath;

    @Value("${ballooning.data.filePath.airlines}")
    private String airlinesFilePath;

    @Value("${ballooning.data.filePath.gists}")
    private String gistsFilePath;

    @Value("${ballooning.data.filePath.reddit}")
    private String redditFilePath;


    public static String NASA_FILE_PATH;
    public static String MOVIES_FILE_PATH;
    public static String AIRLINES_FILE_PATH;
    public static String GISTS_FILE_PATH;
    public static String REDDIT_FILE_PATH;

    @PostConstruct
    public void initializeBalloonStrategyEnums() {
        NASA_FILE_PATH = nasaFilePath;
        MOVIES_FILE_PATH = moviesFilePath;
        AIRLINES_FILE_PATH = airlinesFilePath;
        GISTS_FILE_PATH = gistsFilePath;
        REDDIT_FILE_PATH = redditFilePath;
    }
}
