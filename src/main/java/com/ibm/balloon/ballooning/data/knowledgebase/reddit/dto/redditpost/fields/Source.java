package com.ibm.balloon.ballooning.data.knowledgebase.reddit.dto.redditpost.fields;

import com.ibm.balloon.ballooning.data.knowledgebase.reddit.dto.DtoStandard;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Source implements DtoStandard {
    private String url;
    private int width;
    private int height;
}
