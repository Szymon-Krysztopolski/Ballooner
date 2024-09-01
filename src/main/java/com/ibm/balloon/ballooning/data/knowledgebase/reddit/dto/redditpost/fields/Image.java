package com.ibm.balloon.ballooning.data.knowledgebase.reddit.dto.redditpost.fields;

import com.ibm.balloon.ballooning.data.knowledgebase.reddit.dto.DtoStandard;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Image implements DtoStandard {
    private Source source;
    private List<Resolution> resolutions;
    private Variants variants;
    private String id;
}
