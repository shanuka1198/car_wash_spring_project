package com.carwash.S.I_car_wash.service.serviceImpl;

import com.carwash.S.I_car_wash.Entity.Vehicles;
import com.carwash.S.I_car_wash.dto.VehicleDTO;
import com.carwash.S.I_car_wash.repository.VehicleRepository;
import com.carwash.S.I_car_wash.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Vehicles createVehicle(VehicleDTO vehicleDTO) {
        Vehicles vehicles=new Vehicles();
        vehicles.setVehicleType(vehicleDTO.getVehicleType());
        return vehicleRepository.save(vehicles);
    }

    @Override
    public List<Vehicles> getAllVehicles() {
        return List.of();
    }

    @Override
    public boolean deleteVehicle(Long vehicleId) {
        return false;
    }

    @Override
    public Vehicles updateVehicle(Long vehicleId, VehicleDTO vehicleDTO) {
        return null;
    }
}
