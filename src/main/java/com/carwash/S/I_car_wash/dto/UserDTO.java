package com.carwash.S.I_car_wash.dto;

import com.carwash.S.I_car_wash.Entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDTO {

    private Long userId;

    @NotBlank(message = "User name cannot be empty")
    @Size(min = 3, max = 50, message = "User name must be between 3 and 50 characters")
    private String username;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be empty")
    private String email;

    @NotBlank(message = "Address cannot be empty")
    private String address;

    private UserEntity.Role role;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    public UserDTO() {
    }

    public UserDTO(String username, String email, String address, UserEntity.Role role, String password) {
        this.username = username;
        this.email = email;
        this.address = address;
        this.role = role;
        this.password = password;
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

    public void setUserName(String username) {
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

    public UserEntity.Role getRole() {
        return role;
    }

    public void setRole(UserEntity.Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
