package com.carwash.S.I_car_wash.dto;

import com.carwash.S.I_car_wash.Entity.Appointment.VehicleType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.FutureOrPresent;
import java.time.LocalDateTime;

public class AppointmentDTO {

    private Long appointmentId;

    @NotNull(message = "Appointment date and time cannot be null")
    @FutureOrPresent(message = "Appointment date and time must be in the future or present")
    private LocalDateTime appointmentDateTime;

    @NotNull(message = "Vehicle type cannot be null")
    private VehicleType vehicleType;

    @NotNull(message = "Service ID cannot be null")
    private Long serviceId; // Foreign Key for Service

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    public AppointmentDTO() {}

    public AppointmentDTO(Long appointmentId, LocalDateTime appointmentDateTime, VehicleType vehicleType, Long serviceId, Long userId) {
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

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
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
