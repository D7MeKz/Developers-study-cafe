package org.toy.dsc.service;

import org.toy.dsc.domain.CreatePostDto;
import org.toy.dsc.dto.request.CreatePostRequest;

public interface PostService {
    CreatePostDto createPost(CreatePostRequest request);
}
