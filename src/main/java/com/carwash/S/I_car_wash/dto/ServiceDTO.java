package com.carwash.S.I_car_wash.dto;

import com.carwash.S.I_car_wash.Entity.ServiceEntity;
import jakarta.persistence.Convert;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class ServiceDTO {

    @NotNull(message = "Service ID cannot be null")
    private Long serviceId;

    @NotNull(message = "Service type cannot be null")
    private ServiceEntity.ServiceType serviceType; // Enum converted to String for JSON serialization


    @NotEmpty(message = "Service names cannot be empty")
    @Size(min = 1, message = "At least one service name must be provided")
    private List<String> serviceNames;

    @NotNull(message = "Price cannot be null")
    @Min(value = 0, message = "Price must be greater than or equal to 0")
    private Double price;

    @NotNull(message = "Appointment ID cannot be null")
    private Long appointmentId; // Associated Appointment entity ID

    // Default constructor
    public ServiceDTO() {}

    // Constructor with parameters
    public ServiceDTO(Long serviceId, ServiceEntity.ServiceType serviceType, List<String> serviceNames, Double price, Long appointmentId) {
        this.serviceId = serviceId;
        this.serviceType = serviceType;
        this.serviceNames = serviceNames;
        this.price = price;
        this.appointmentId = appointmentId;
    }

    // Getters and setters
    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public ServiceEntity.ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceEntity.ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public List<String> getServiceNames() {
        return serviceNames;
    }

    public void setServiceNames(List<String> serviceNames) {
        this.serviceNames = serviceNames;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }
}
