package com.carwash.S.I_car_wash.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class AppointmentDTO {

    private Long appointmentId;

    @NotNull(message = "Appointment date and time cannot be null")
    @FutureOrPresent(message = "Appointment date and time must be in the future or present")
    private LocalDateTime appointmentDateTime;

    @NotNull(message = "Vehicle ID cannot be null")
    private Long vehicleId;

    @NotNull(message = "Service ID cannot be null")
    private Long serviceId;

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    private String note;

    @NotNull(message = "Service fee cannot be null")
    private Double serviceFee=0.0;

    private int discount = 0;

    private Double totalFee = 0.0;

    public AppointmentDTO() {}

    public AppointmentDTO(Long appointmentId, LocalDateTime appointmentDateTime, Long vehicleId, Long serviceId, Long userId, String note, Double serviceFee, int discount, Double totalFee) {
        this.appointmentId = appointmentId;
        this.appointmentDateTime = appointmentDateTime;
        this.vehicleId = vehicleId;
        this.serviceId = serviceId;
        this.userId = userId;
        this.note = note;
        this.serviceFee = serviceFee;
        this.discount = discount;
        this.totalFee = totalFee;
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

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Double getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(Double serviceFee) {
        this.serviceFee = serviceFee;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Double totalFee) {
        this.totalFee = totalFee;
    }
}
