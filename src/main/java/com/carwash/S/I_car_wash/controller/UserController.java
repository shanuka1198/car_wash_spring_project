package com.carwash.S.I_car_wash.controller;

import com.carwash.S.I_car_wash.Entity.UserEntity;
import com.carwash.S.I_car_wash.dto.UserDTO;
import com.carwash.S.I_car_wash.dto.UserResponseDTO;
import com.carwash.S.I_car_wash.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserResponseDTO>getAllUser(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
    public boolean deleteUser(@PathVariable Long userId){
        return userService.deleteUsers(userId);
    }

    @PutMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
    public UserEntity updateUser(@PathVariable Long userId,@RequestBody UserDTO userDTO){
        return userService.updateUser(userId,userDTO);
    }
}
