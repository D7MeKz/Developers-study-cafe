package org.toy.dsc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.toy.dsc.constant.ResponseMessage;
import org.toy.dsc.dto.request.StudyGroupCreateRequest;
import org.toy.dsc.dto.response.GetStudyGroupResponse;
import org.toy.dsc.dto.response.StudyGroupCreateResponse;
import org.toy.dsc.entity.StudyGroupEntity;
import org.toy.dsc.exception.exception.DefaultException;
import org.toy.dsc.repository.StudyGroupRepository;

import java.util.Optional;


@Service
public class StudyGroupServiceImp implements StudyGroupService{
    @Autowired
    private StudyGroupRepository studyGroupRepository;

    @Override
    public StudyGroupCreateResponse create_group(StudyGroupCreateRequest request) {
        try{
            StudyGroupEntity savedData = studyGroupRepository.save(StudyGroupEntity.builder().name(request.getName()).description(request.getDescription()).build());
            return new StudyGroupCreateResponse(Long.toString(savedData.getId()));
        }catch (Exception e){
            throw new DefaultException(ResponseMessage.DB_UNEXPECTED_ERROR,"study group");
        }
    }

    @Override
    public GetStudyGroupResponse getStudyGroupById(Long id) {
        try{
            StudyGroupEntity studyGroupEntity = studyGroupRepository.findById(id).orElseThrow(() -> new DefaultException(ResponseMessage.NOT_FOUND,"group"));
            return GetStudyGroupResponse.builder()
                    .groupId(String.valueOf(studyGroupEntity.getId()))
                    .name(studyGroupEntity.getName())
                    .description(studyGroupEntity.getDescription())
                    .build();
        }catch (DataAccessException e){
            throw new DefaultException(ResponseMessage.DATA_ACCESS_ERROR,"group");
        }catch (Exception e){
            System.out.println("OUT"  + e.getMessage());
            throw new DefaultException(ResponseMessage.DB_UNEXPECTED_ERROR,"group");
        }
    }
}
