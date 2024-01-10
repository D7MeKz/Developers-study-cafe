package org.toy.dsc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserRegisterRequest {
    private String email;
    private String password;
    private String username;
}
