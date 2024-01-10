package org.toy.dsc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.toy.dsc.domain.User;
import org.toy.dsc.dto.UserRegisterCommand;
import org.toy.dsc.dto.UserRegisterRequest;
import org.toy.dsc.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/users/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    public void registerUser(@RequestBody UserRegisterRequest request){

        UserRegisterCommand command = UserRegisterCommand.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .username(request.getUsername())
                .build();

        userService.createUser(command);
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable("id") long id){
        return userService.getUserById(id);
    }
}
