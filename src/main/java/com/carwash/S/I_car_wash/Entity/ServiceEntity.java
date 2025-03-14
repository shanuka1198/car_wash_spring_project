package com.carwash.S.I_car_wash.Entity;


import jakarta.persistence.*;

import java.util.ArrayList;
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

    @Column(nullable = false,unique = true)
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;


    // One-to-Many relationship: One service can have multiple appointments
    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Appointment> appointments = new ArrayList<>();

    // Default Constructor
    public ServiceEntity() {}

    public ServiceEntity(Long serviceId, ServiceType serviceType) {
        this.serviceId = serviceId;
        this.serviceType = serviceType;
    }

    // Getters and Setters
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


    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
