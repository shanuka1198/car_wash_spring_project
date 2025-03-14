package com.carwash.S.I_car_wash.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "vehicles")

public class Vehicles {

    public enum VehicleType {
        CAR, VAN, BIKE, BUS, LORRY, SUV
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Appointment> appointments;

    public Vehicles() {}

    public Vehicles(Long vehicleId, VehicleType vehicleType, List<Appointment> appointments) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.appointments = appointments;
    }

    public Long getVehicleId() { return vehicleId; }
    public void setVehicleId(Long vehicleId) { this.vehicleId = vehicleId; }

    public VehicleType getVehicleType() { return vehicleType; }
    public void setVehicleType(VehicleType vehicleType) { this.vehicleType = vehicleType; }

    public List<Appointment> getAppointments() { return appointments; }
    public void setAppointments(List<Appointment> appointments) { this.appointments = appointments; }
}
