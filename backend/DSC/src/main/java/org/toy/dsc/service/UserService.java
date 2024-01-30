package org.toy.dsc.service;

import org.springframework.http.ResponseEntity;
import org.toy.dsc.domain.User;
import org.toy.dsc.dto.UserRegisterCommand;
import org.toy.dsc.dto.response.UserLoginResponse;

public interface UserService {
    void createUser(UserRegisterCommand command);
    User getUserById(Long userId);
    UserLoginResponse loginUserByEmail(String email);
    Boolean logoutById(String userId);
}
