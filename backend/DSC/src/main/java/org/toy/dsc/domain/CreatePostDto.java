package org.toy.dsc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class CreatePostDto {
    private Long postId;
    private String title;
    private String content;
    private String createdDate;
    private String modifiedDate;
    private Long userId;
    private String username;

}
