package org.toy.dsc.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class GetStudyGroupResponse {
    private String groupId;
    private String name;
    private String description;

    @Builder
    public GetStudyGroupResponse(String groupId, String name, String description) {
        this.groupId = groupId;
        this.name = name;
        this.description = description;
    }
}
