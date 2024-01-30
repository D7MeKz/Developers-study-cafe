package org.toy.dsc.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.toy.dsc.entity.UserEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreatePostRequest {
    private Long userId;
    private String title;
    private String content;

//    public UserEntity toEntity(); //
}
