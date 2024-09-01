package com.ibm.balloon.ballooning.data.knowledgebase.gists.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Owner implements DtoStandard {
    private Integer id;
    private String login, nodeId, url, gravatarId;
    private String avatarUrl, htmlUrl, followersUrl, followingUrl, gistsUrl, starredUrl,
            subscriptionsUrl, organizationsUrl, reposUrl, eventsUrl, receivedEventsUrl;
    private String type;
    private Boolean siteAdmin;
}
