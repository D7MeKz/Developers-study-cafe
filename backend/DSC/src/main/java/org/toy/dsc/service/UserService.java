package org.toy.dsc.service;

import org.springframework.http.ResponseEntity;
import org.toy.dsc.domain.User;
import org.toy.dsc.dto.UserRegisterCommand;
import org.toy.dsc.dto.request.UserLoginRequest;
import org.toy.dsc.utils.DefaultResponse;

public interface UserService {
    void createUser(UserRegisterCommand command);
    User getUserById(Long userId);
    ResponseEntity loginUserByEmail(String email);
}
