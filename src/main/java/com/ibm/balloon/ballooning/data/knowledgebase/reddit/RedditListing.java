package com.ibm.balloon.ballooning.data.knowledgebase.reddit;

import com.ibm.balloon.ballooning.data.domain.InputBalloonData;
import com.ibm.balloon.ballooning.data.knowledgebase.reddit.dto.DtoStandard;
import com.ibm.balloon.ballooning.data.knowledgebase.reddit.dto.RedditListingData;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RedditListing implements InputBalloonData, DtoStandard {
    private String kind;
    private RedditListingData data;
}
