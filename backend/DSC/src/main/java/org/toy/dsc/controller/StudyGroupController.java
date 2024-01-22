package org.toy.dsc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.toy.dsc.dto.request.StudyGroupCreateRequest;
import org.toy.dsc.dto.response.GetStudyGroupResponse;
import org.toy.dsc.dto.response.StudyGroupCreateResponse;
import org.toy.dsc.service.StudyGroupService;

@RestController
public class StudyGroupController {
    @Autowired
    private StudyGroupService studyGroupService;

    @PostMapping("/v1/group/create")
    public ResponseEntity createStudyGroup(@RequestBody StudyGroupCreateRequest request){
        StudyGroupCreateResponse response = studyGroupService.create_group(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/v1/group/{id}")
    public ResponseEntity getStudyGroup(@PathVariable Long id){
        GetStudyGroupResponse response = studyGroupService.getStudyGroupById(id);
        return ResponseEntity.ok(response);
    }

    
}
