package com.ibm.balloon.ballooning.data.knowledgebase.reddit.dto.redditpost;

import com.ibm.balloon.ballooning.data.knowledgebase.reddit.dto.DtoStandard;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RedditChild implements DtoStandard {
    public String kind;
    public RedditPost data;
}
