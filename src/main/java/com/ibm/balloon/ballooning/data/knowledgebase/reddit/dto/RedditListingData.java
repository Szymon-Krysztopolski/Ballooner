package com.ibm.balloon.ballooning.data.knowledgebase.reddit.dto;

import com.ibm.balloon.ballooning.data.domain.InputBalloonData;
import com.ibm.balloon.ballooning.data.domain.InputBalloonDataList;
import com.ibm.balloon.ballooning.data.knowledgebase.reddit.dto.redditpost.RedditChild;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RedditListingData implements InputBalloonData, DtoStandard {
    public String before, after;
    public int dist;
    public String modhash;
    public Object geoFilter;
    public InputBalloonDataList<RedditChild> children;
}
