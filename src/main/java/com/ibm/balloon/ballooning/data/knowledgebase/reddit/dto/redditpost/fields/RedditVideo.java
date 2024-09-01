package com.ibm.balloon.ballooning.data.knowledgebase.reddit.dto.redditpost.fields;

import com.ibm.balloon.ballooning.data.knowledgebase.reddit.dto.DtoStandard;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RedditVideo implements DtoStandard {
    private int bitrateKbps;
    private String fallbackUrl;
    private int height;
    private int width;
    private String scrubberMediaUrl;
    private String dashUrl;
    private int duration;
    private String hlsUrl;
    private boolean isGif;
    private String transcodingStatus;
}
