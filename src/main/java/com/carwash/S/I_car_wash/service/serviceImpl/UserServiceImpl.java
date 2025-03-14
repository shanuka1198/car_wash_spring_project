package com.carwash.S.I_car_wash.service.serviceImpl;

import com.carwash.S.I_car_wash.Entity.UserEntity;
import com.carwash.S.I_car_wash.dto.UserDTO;
import com.carwash.S.I_car_wash.repository.UserRepository;
import com.carwash.S.I_car_wash.service.JwtService;
import com.carwash.S.I_car_wash.service.UserService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Override
    public UserEntity createUser(UserDTO userDTO) {


        UserEntity user=new UserEntity();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setAddress(userDTO.getAddress());
        user.setRole(userDTO.getRole());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return userRepository.save(user);
    }



//    @Override
//    public String login(AuthReqDTO authReqDTO) {
//
//            Authentication authentication=authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authReqDTO.getUsername(),authReqDTO.getPassword())
//            );
//
//            if (authentication.isAuthenticated()){
//                return "kjasfd24339317793e";
//            }
//
//
//        return "fail";
//    }


    @Override
    public String login(UserDTO userDTO) {

        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDTO.getUsername(),userDTO.getPassword())
        );

        if (authentication.isAuthenticated()){
            return jwtService.generateToken(userDTO);
        }

        return "fail";
    }


    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteUsers(Long userId) {
        try {
            userRepository.deleteById(userId);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }

    }

    @Override
    public UserEntity updateUser(Long userId, UserDTO userDTO) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setAddress(userDTO.getAddress());
        user.setRole(userDTO.getRole());
        user.setPassword(user.getPassword());

        return userRepository.save(user);
    }
}
