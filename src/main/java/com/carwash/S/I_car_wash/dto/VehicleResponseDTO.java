package com.carwash.S.I_car_wash.dto;

import com.carwash.S.I_car_wash.Entity.Vehicles;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public class VehicleResponseDTO {
    @JsonProperty("vehicleId")
    private Long vehicleId;
    @JsonProperty("vehicleType")
    private String vehicleType;

    public VehicleResponseDTO(Vehicles vehicles) {
        this.vehicleId = vehicles.getVehicleId();
        this.vehicleType = vehicles.getVehicleType().name();
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
}
