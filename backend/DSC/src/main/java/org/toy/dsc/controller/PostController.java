package org.toy.dsc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.toy.dsc.domain.CreatePostDto;
import org.toy.dsc.dto.request.CreatePostRequest;
import org.toy.dsc.dto.response.SuccessResponse;
import org.toy.dsc.service.PostService;

@RestController
@RequestMapping("/posts/")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("create")
    public ResponseEntity posting(@RequestBody CreatePostRequest request){
        CreatePostDto createPostDto = postService.createPost(request);
        return ResponseEntity.ok(createPostDto);
    }
}
