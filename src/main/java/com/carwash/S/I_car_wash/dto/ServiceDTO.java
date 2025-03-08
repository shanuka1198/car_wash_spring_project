package com.carwash.S.I_car_wash.dto;

import com.carwash.S.I_car_wash.Entity.ServiceEntity.ServiceType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.List;

public class ServiceDTO {

    private Long serviceId;

    @NotNull(message = "Service type cannot be null")
    private ServiceType serviceType;

    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be greater than zero")
    private Double price;

    // List of appointment IDs
    private List<Long> appointmentIds;

    public ServiceDTO() {}

    public ServiceDTO(Long serviceId, ServiceType serviceType, Double price, List<Long> appointmentIds) {
        this.serviceId = serviceId;
        this.serviceType = serviceType;
        this.price = price;
        this.appointmentIds = appointmentIds;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Long> getAppointmentIds() {
        return appointmentIds;
    }

    public void setAppointmentIds(List<Long> appointmentIds) {
        this.appointmentIds = appointmentIds;
    }
}
