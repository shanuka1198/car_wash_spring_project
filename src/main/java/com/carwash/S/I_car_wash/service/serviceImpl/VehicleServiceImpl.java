package com.carwash.S.I_car_wash.service.serviceImpl;

import com.carwash.S.I_car_wash.Entity.Vehicles;
import com.carwash.S.I_car_wash.dto.AppointmentResponseDTO;
import com.carwash.S.I_car_wash.dto.VehicleDTO;
import com.carwash.S.I_car_wash.dto.VehicleResponseDTO;
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
    public List<VehicleResponseDTO> getAllVehicles() {
        List<Vehicles>vehicles=vehicleRepository.findAll();
        return vehicles.stream().map(VehicleResponseDTO::new).toList();
    }

    @Override
    public boolean deleteVehicle(Long vehicleId) {
        Vehicles vehicles=vehicleRepository.findById(vehicleId).orElseThrow(()->(
                new RuntimeException("Vehicles Not Found")
                ));

        System.out.println(vehicles.getVehicleId());
        try {
            vehicleRepository.deleteById(vehicleId);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Vehicles updateVehicle(Long vehicleId, VehicleDTO vehicleDTO) {
        return null;
    }
}
