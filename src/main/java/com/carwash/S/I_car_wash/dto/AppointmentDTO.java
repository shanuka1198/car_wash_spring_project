package com.carwash.S.I_car_wash.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class AppointmentDTO {

    private Long appointmentId;

    @NotNull(message = "Appointment Date and Time cannot be null")
    private LocalDateTime appointmentDateTime;

    @NotNull(message = "Vehicle type cannot be null")
    @Size(min = 1, max = 10, message = "Vehicle type must be between 1 and 10 characters")
    @Pattern(regexp = "CAR|VAN|BIKE|BUS|LORRY|SUV", message = "Vehicle type must be one of the following: CAR, VAN, BIKE, BUS, LORRY, SUV")
    private String vehicleType;

    @NotNull(message = "Service ID cannot be null")
    private Long serviceId;

    @NotNull(message = "User ID cannot be null")
    private Long userId;


    public AppointmentDTO() {}


    public AppointmentDTO(Long appointmentId, LocalDateTime appointmentDateTime, String vehicleType, Long serviceId, Long userId) {
        this.appointmentId = appointmentId;
        this.appointmentDateTime = appointmentDateTime;
        this.vehicleType = vehicleType;
        this.serviceId = serviceId;
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

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
