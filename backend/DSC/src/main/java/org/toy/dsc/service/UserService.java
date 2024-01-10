package org.toy.dsc.service;

import org.toy.dsc.domain.User;
import org.toy.dsc.dto.UserRegisterCommand;

public interface UserService {
    void createUser(UserRegisterCommand command);
    User getUserById(Long userId);
}
