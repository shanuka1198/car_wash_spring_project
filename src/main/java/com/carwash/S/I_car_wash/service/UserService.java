package com.carwash.S.I_car_wash.service;

import com.carwash.S.I_car_wash.Entity.UserEntity;
import com.carwash.S.I_car_wash.dto.UserDTO;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserEntity createUser(UserDTO userDTO);
    String login(UserDTO userDTO);
    List<UserEntity> getAllUsers();
    boolean deleteUsers(Long userId);
    UserEntity updateUser(Long userId, UserDTO userDTO);
}
