package org.toy.dsc.mapper;

import org.toy.dsc.dto.request.CreatePostRequest;
import org.toy.dsc.entity.PostEntity;
import org.toy.dsc.util.annotation.Mapper;

@Mapper
public class PostMapper {
    public PostEntity RequestMapToEntity(CreatePostRequest request){
        return new PostEntity(
                request.getTitle(),
                request.getContent()
        );
    }
}
