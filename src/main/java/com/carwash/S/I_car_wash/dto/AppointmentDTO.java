package com.carwash.S.I_car_wash.dto;

import com.carwash.S.I_car_wash.Entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;


public class AppointmentDTO {

    private Long appointmentId;
    @NotNull(message = "Appointment date and time cannot be null")
    private LocalDateTime appointmentDateTime;

    @NotBlank(message = "Vehicle type cannot be empty")
    private String vehicleType;

    @NotBlank(message = "Service type cannot be empty")
    private String serviceType;

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    public AppointmentDTO() {
    }

    public AppointmentDTO(Long appointmentId, LocalDateTime appointmentDateTime, String vehicleType, String serviceType, Long userId) {
        this.appointmentId = appointmentId;
        this.appointmentDateTime = appointmentDateTime;
        this.vehicleType = vehicleType;
        this.serviceType = serviceType;
        this.userId = userId;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
