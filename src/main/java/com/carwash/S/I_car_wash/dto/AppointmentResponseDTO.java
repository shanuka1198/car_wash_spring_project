package com.carwash.S.I_car_wash.dto;

import com.carwash.S.I_car_wash.Entity.Appointment;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class AppointmentResponseDTO {

    @JsonProperty("appointmentId")
    private Long appointmentId;

    @JsonProperty("appointmentDateTime")
    private LocalDateTime appointmentDateTime;

    @JsonProperty("vehicleId")
    private Long vehicleId;

    @JsonProperty("vehicleType")
    private String vehicleType;

    @JsonProperty("serviceId")
    private Long serviceId;

    @JsonProperty("serviceName")
    private String serviceName;

    @JsonProperty("userId")
    private Long userId;

    @JsonProperty("username")
    private String username;

    @JsonProperty("note")
    private String note;

    @JsonProperty("serviceFee")
    private Double serviceFee;

    @JsonProperty("discount")
    private int discount=0;

    @JsonProperty("TotalFee")
    private Double totalFee=0.0;

    // 👇 **Default Constructor (Jackson Serialization issue fix)**
    public AppointmentResponseDTO() {}

    public AppointmentResponseDTO(Appointment appointment) {
        this.appointmentId = appointment.getAppointmentId();
        this.appointmentDateTime = appointment.getAppointmentDateTime();
        this.vehicleId = appointment.getVehicle().getVehicleId();
        this.vehicleType = appointment.getVehicle().getVehicleType().name();
        this.serviceId = appointment.getService().getServiceId();
        this.serviceName = appointment.getService().getServiceType().name();
        this.userId = appointment.getUser().getUserId();
        this.username = appointment.getUser().getUsername();
        this.note=appointment.getNote();
        this.serviceFee=appointment.getServiceFee();
        this.discount= appointment.getDiscount();
        this.totalFee=appointment.getTotalFee();
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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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
