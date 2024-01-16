package org.toy.dsc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.toy.dsc.constant.ResponseMessage;
import org.toy.dsc.constant.StatusCode;
import org.toy.dsc.domain.User;
import org.toy.dsc.dto.UserRegisterCommand;
import org.toy.dsc.dto.response.UserLoginResponse;
import org.toy.dsc.entity.UserEntity;
import org.toy.dsc.mapper.UserMapper;
import org.toy.dsc.repository.UserRepository;
import org.toy.dsc.dto.response.DefaultResponse;

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

    @Override
    public ResponseEntity loginUserByEmail(String email) {
        String userId = userRepository.getIdByUserEmail(email);
        UserLoginResponse userLoginResponse = new UserLoginResponse(userId);
        if (userId != null){
            return new ResponseEntity(DefaultResponse.response(StatusCode.OK, ResponseMessage.CREATED_USER, userLoginResponse), HttpStatus.OK);
        }else {
            return new ResponseEntity(DefaultResponse.response(StatusCode.INTERNAL_SERVER_ERROR, ResponseMessage.NOT_FOUND_DATA), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public DefaultResponse logoutById(String userId) {
        try{
            long convertedId = Long.parseLong(userId);
            Optional<UserEntity> user = userRepository.findById(convertedId);
            if (user.isEmpty()){
                return DefaultResponse.response(StatusCode.INTERNAL_SERVER_ERROR,ResponseMessage.USER_DID_NOT_EXIST);
            }else{
                return DefaultResponse.response(StatusCode.OK, ResponseMessage.LOGOUT_SUCCESS);
            }
        }catch (NumberFormatException e){
            return DefaultResponse.response(StatusCode.INTERNAL_SERVER_ERROR, "Invalid Number Format");
        }

    }
}
