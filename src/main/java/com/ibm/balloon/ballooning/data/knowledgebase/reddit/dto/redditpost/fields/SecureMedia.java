package com.ibm.balloon.ballooning.data.knowledgebase.reddit.dto.redditpost.fields;

import com.ibm.balloon.ballooning.data.knowledgebase.reddit.dto.DtoStandard;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SecureMedia implements DtoStandard {
    private RedditVideo redditVideo;
}
