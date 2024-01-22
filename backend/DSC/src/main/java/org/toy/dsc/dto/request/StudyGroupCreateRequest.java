package org.toy.dsc.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudyGroupCreateRequest {
    private String userId;
    private String name;
    private String description;
}
