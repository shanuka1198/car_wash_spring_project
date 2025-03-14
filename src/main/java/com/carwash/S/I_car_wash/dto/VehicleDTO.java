package com.carwash.S.I_car_wash.dto;


import com.carwash.S.I_car_wash.Entity.Vehicles.VehicleType;
import jakarta.validation.constraints.NotNull;


public class VehicleDTO {

    private Long vehicleId;

    @NotNull(message = "Vehicle type is required")
    private VehicleType vehicleType; // Enum එක නිවැරදිව import කරලා ඇත.

    public VehicleDTO() {}

    public VehicleDTO(Long vehicleId, VehicleType vehicleType) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}

