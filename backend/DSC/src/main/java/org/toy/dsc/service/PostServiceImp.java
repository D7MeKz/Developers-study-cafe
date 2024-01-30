package org.toy.dsc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.toy.dsc.domain.CreatePostDto;
import org.toy.dsc.dto.request.CreatePostRequest;
import org.toy.dsc.entity.PostEntity;
import org.toy.dsc.entity.UserEntity;
import org.toy.dsc.exception.exception.JPAUnexpectedError;
import org.toy.dsc.exception.exception.UserDoesNotExist;
import org.toy.dsc.mapper.PostMapper;
import org.toy.dsc.repository.PostRepository;
import org.toy.dsc.repository.UserRepository;

@Service
public class PostServiceImp implements PostService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostMapper postMapper;

    @Override
    public CreatePostDto createPost(CreatePostRequest request) {
        try {
            // Check user exist
            UserEntity user = userRepository.getById(request.getUserId());
            if (user == null){
                throw new UserDoesNotExist();
            }

            // Create post
            PostEntity post = postMapper.RequestMapToEntity(request);
            post.updateUser(user);

            // Save Data
            PostEntity savedPost = postRepository.save(post);

            // return value
            return CreatePostDto.builder()
                    .postId(savedPost.getId())
                    .title(savedPost.getTitle())
                    .content(savedPost.getContent())
                    .createdDate(String.valueOf(savedPost.getCreatedDate()))
                    .modifiedDate(String.valueOf(savedPost.getModifiedDate()))
                    .userId(savedPost.getUser().getId())
                    .username(savedPost.getUser().getUsername())
                    .build();

        }catch (Exception e){
            System.out.println(e);
            throw new JPAUnexpectedError();
        }
    }
}
