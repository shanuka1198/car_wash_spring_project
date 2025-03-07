package com.carwash.S.I_car_wash.Entity;

import com.carwash.S.I_car_wash.converter.StringListConverter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "service")
public class ServiceEntity {

    public enum ServiceType {
        FULL_SERVICE, BASIC_SERVICE, EXPRESS_SERVICE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    @Convert(converter = StringListConverter.class)
    @Column(name = "service_names",nullable = false)
    private List<String> serviceNames;

    @Column(nullable = false)
    private Double price;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Appointment> appointments;

    // Default constructor
    public ServiceEntity() {}

    // Constructor with parameters
    public ServiceEntity(ServiceType serviceType, List<String> serviceNames, Double price, List<Appointment> appointments) {
        this.serviceType = serviceType;
        this.serviceNames = serviceNames;
        this.price = price;
        this.appointments = appointments;
    }

    // Getters and setters
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

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
