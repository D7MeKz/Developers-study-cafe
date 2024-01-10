package org.toy.dsc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.toy.dsc.domain.User;
import org.toy.dsc.dto.UserRegisterCommand;
import org.toy.dsc.entity.UserEntity;
import org.toy.dsc.mapper.UserMapper;
import org.toy.dsc.repository.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void createUser(UserRegisterCommand command) {
        userRepository.save(new UserEntity(command.getEmail(), command.getPassword(), command.getUsername()));

    }

    @Override
    public User getUserById(Long userId) {
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        return userMapper.UserEntityToUser(userEntity.get());
    }
}
