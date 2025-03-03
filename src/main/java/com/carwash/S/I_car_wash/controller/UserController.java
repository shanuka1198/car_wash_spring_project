package com.carwash.S.I_car_wash.controller;

import com.carwash.S.I_car_wash.Entity.UserEntity;
import com.carwash.S.I_car_wash.dto.UserDTO;
import com.carwash.S.I_car_wash.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/user")
public class UserController {


    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserEntity createUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDTO userDTO){
        return userService.login(userDTO);
    }
}
