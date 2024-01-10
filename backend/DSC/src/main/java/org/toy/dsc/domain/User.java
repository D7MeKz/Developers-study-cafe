package org.toy.dsc.domain;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class User {
    private Long userId;
    private String email;
    private String username;
    private String password;

}
