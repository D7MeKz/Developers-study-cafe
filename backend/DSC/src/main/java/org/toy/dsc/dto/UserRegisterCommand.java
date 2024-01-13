package org.toy.dsc.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRegisterCommand {

    private String email;
    private String username;
    private String password;
}
