package org.toy.dsc.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreatePostResponse {
    private String postId;
    private String title;
    private String content;
    // TODO : Created time, Modified Time
}
