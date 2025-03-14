package com.carwash.S.I_car_wash.dto;

import com.carwash.S.I_car_wash.Entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonProperty;


public class UserResponseDTO {

    @JsonProperty("userId")
    private Long userId;
    @JsonProperty("username")
    private String username;
    @JsonProperty("email")
    private String email;
    @JsonProperty("address")
    private String address;
    @JsonProperty("role")
    private String role;
    @JsonProperty("password")
    private String password;

    public UserResponseDTO(UserEntity user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.address = user.getAddress();
        this.role = user.getRole().name();
        this.password = user.getPassword();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
