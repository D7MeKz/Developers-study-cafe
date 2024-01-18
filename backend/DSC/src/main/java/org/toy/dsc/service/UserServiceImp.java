package org.toy.dsc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.toy.dsc.constant.ResponseMessage;
import org.toy.dsc.constant.StatusCode;
import org.toy.dsc.domain.User;
import org.toy.dsc.dto.UserRegisterCommand;
import org.toy.dsc.dto.response.UserLoginResponse;
import org.toy.dsc.entity.UserEntity;
import org.toy.dsc.exception.exception.DefaultException;
import org.toy.dsc.mapper.UserMapper;
import org.toy.dsc.repository.UserRepository;
import org.toy.dsc.dto.response.DefaultResponse;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void createUser(UserRegisterCommand command) {
        try {
            userRepository.save(new UserEntity(command.getEmail(), command.getPassword(), command.getUsername()));
        }catch (DataAccessException e){
            throw new DefaultException(ResponseMessage.DATA_ACCESS_ERROR,"user");
        }catch (Exception e){
            throw new DefaultException(ResponseMessage.DB_UNEXPECTED_ERROR,"user");
        }

    }

    @Override
    public User getUserById(Long userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(()-> new DefaultException(ResponseMessage.NOT_FOUND,"user"));
        return userMapper.UserEntityToUser(userEntity);
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
    public Boolean logoutById(String userId) {
        try{
            long convertedId = Long.parseLong(userId);
            UserEntity user = userRepository.findById(convertedId).orElseThrow(() -> new DefaultException(ResponseMessage.NOT_FOUND,"user"));
            return true;
        }catch (DataAccessException e){
            throw new DefaultException(ResponseMessage.DATA_ACCESS_ERROR,"user");
        }
    }
}
