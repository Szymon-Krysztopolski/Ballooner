package com.ibm.balloon.ballooning.data.knowledgebase.reddit.dto.redditpost.fields;

import com.ibm.balloon.ballooning.data.knowledgebase.reddit.dto.DtoStandard;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Preview implements DtoStandard {
    private List<Image> images;
    private boolean enabled;
}
