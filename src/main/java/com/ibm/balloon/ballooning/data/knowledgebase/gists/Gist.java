package com.ibm.balloon.ballooning.data.knowledgebase.gists;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.balloon.ballooning.data.domain.InputBalloonData;
import com.ibm.balloon.ballooning.data.knowledgebase.gists.dto.DtoStandard;
import com.ibm.balloon.ballooning.data.knowledgebase.gists.dto.FileDetails;
import com.ibm.balloon.ballooning.data.knowledgebase.gists.dto.Owner;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class Gist implements InputBalloonData, DtoStandard {
    private String id, nodeId;
    private String url, forksUrl, commitsUrl, gitPullUrl, gitPushUrl, htmlUrl, commentsUrl;
    private Map<String, FileDetails> files;
    private String createdAt, updatedAt;
    private String description, user;
    private Integer comments;
    private Owner owner;
    private Boolean truncated;

    @JsonProperty("public")
    private Boolean isPublic;
}
