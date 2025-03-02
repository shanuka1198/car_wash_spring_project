package com.carwash.S.I_car_wash.service;

import com.carwash.S.I_car_wash.Entity.Appointment;
import com.carwash.S.I_car_wash.Entity.User;
import com.carwash.S.I_car_wash.dto.AppointmentDTO;
import com.carwash.S.I_car_wash.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User createUser(UserDTO userDTO);
    List<User> getAllUsers();
    boolean deleteUsers(Long userId);
    User updateUser(Long userId, UserDTO userDTO);
}
