package com.carwash.S.I_car_wash.service;

import com.carwash.S.I_car_wash.Entity.Vehicles;
import com.carwash.S.I_car_wash.dto.VehicleDTO;
import com.carwash.S.I_car_wash.dto.VehicleResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {
    Vehicles createVehicle(VehicleDTO vehicleDTO);
    List<VehicleResponseDTO> getAllVehicles();
    boolean deleteVehicle(Long vehicleId);
    Vehicles updateVehicle(Long vehicleId,VehicleDTO vehicleDTO);
}
