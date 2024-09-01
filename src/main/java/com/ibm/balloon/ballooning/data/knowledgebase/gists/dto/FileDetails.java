package com.ibm.balloon.ballooning.data.knowledgebase.gists.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FileDetails implements DtoStandard {
    private String filename, type, language, rawUrl;
    private Integer size;
}
