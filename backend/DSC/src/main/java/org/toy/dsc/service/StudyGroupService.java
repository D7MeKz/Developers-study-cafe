package org.toy.dsc.service;

import org.toy.dsc.dto.request.StudyGroupCreateRequest;
import org.toy.dsc.dto.response.GetStudyGroupResponse;
import org.toy.dsc.dto.response.StudyGroupCreateResponse;

public interface StudyGroupService {
    StudyGroupCreateResponse create_group(StudyGroupCreateRequest request);

    GetStudyGroupResponse getStudyGroupById(Long id);
}
