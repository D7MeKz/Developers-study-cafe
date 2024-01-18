package org.toy.dsc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.toy.dsc.constant.ResponseMessage;
import org.toy.dsc.constant.StatusCode;
import org.toy.dsc.domain.User;
import org.toy.dsc.dto.UserRegisterCommand;
import org.toy.dsc.dto.request.UserLoginRequest;
import org.toy.dsc.dto.request.UserRegisterRequest;
import org.toy.dsc.service.UserService;
import org.toy.dsc.dto.response.DefaultResponse;

@RestController
@RequestMapping("/users/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    public ResponseEntity registerUser(@RequestBody UserRegisterRequest request){

        UserRegisterCommand command = UserRegisterCommand.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .username(request.getUsername())
                .build();

        userService.createUser(command);
        return new ResponseEntity(DefaultResponse.response(StatusCode.OK, "Register Success"), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity getUserById(@PathVariable("id") long id){
        User user = userService.getUserById(id);
        System.out.println(user.toString());
        return new ResponseEntity(DefaultResponse.response(StatusCode.OK,"Succes",user), HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity loginUser(@RequestBody UserLoginRequest request){
        return userService.loginUserByEmail(request.getEmail());
    }

    @GetMapping("logout/{id}")
    public ResponseEntity logoutUser(@PathVariable("id") String id){
        DefaultResponse defaultResponse = userService.logoutById(id);
        return new ResponseEntity(defaultResponse,defaultResponse.getHttpStatus());
    }
}
